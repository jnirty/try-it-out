-- performance tuning using execution plans, in PostgreSLQ:
-- http://www.postgresql.org/docs/8.1/static/sql-explain.html

---------------------------------------------------
-- compare performance when using function index:
---------------------------------------------------
drop table if exists test_performance;
create table test_performance(
	pk_id integer,
	txt varchar(255)
);
-- create func. to insert test data
CREATE FUNCTION insert_test_data () RETURNS integer AS '
  DECLARE
  	result INTEGER = 0;
	BEGIN
		WHILE result != 1000 LOOP
			insert into test_performance values (result,''txt'');
  		result := result + 1;
   	END LOOP;
	RETURN result;
	END;
' LANGUAGE 'plpgsql';

-- invoke function
SELECT insert_test_data ();
-- check data count
SELECT count(*) from test_performance;

drop index if exists txt_indx;
create index txt_indx on test_performance(txt);


EXPLAIN ANALYZE select count(*) from test_performance where txt = 'txt';

--Aggregate  (cost=20.00..20.01 rows=1 width=0) (actual time=0.693..0.693 rows=1 loops=1)
--   ->  Seq Scan on test_performance  (cost=0.00..17.50 rows=1000 width=0) (actual time=0.014..0.428 rows=1000 loops=1)
--         Filter: ((txt)::text = 'txt'::text)
-- Total runtime: 0.722 ms
--(4 rows)
EXPLAIN ANALYZE select count(*) from test_performance where UPPER(txt) = 'TXT';
--Aggregate  (cost=20.01..20.02 rows=1 width=0) (actual time=1.218..1.218 rows=1 loops=1)
--   ->  Seq Scan on test_performance  (cost=0.00..20.00 rows=5 width=0) (actual time=0.102..0.943 rows=1000 loops=1)
--        Filter: (upper((txt)::text) = 'TXT'::text)
-- Total runtime: 1.246 ms
--(4 rows)

drop index if exists txt_indx;
create index txt_indx on test_performance(UPPER(txt));

EXPLAIN ANALYZE select count(*) from test_performance where txt = 'txt';
-- Aggregate  (cost=20.00..20.01 rows=1 width=0) (actual time=0.687..0.687 rows=1 loops=1)
--   ->  Seq Scan on test_performance  (cost=0.00..17.50 rows=1000 width=0) (actual time=0.012..0.420 rows=1000 loops=1)
--         Filter: ((txt)::text = 'txt'::text)
-- Total runtime: 0.712 ms
--(4 rows)

EXPLAIN ANALYZE select count(*) from test_performance where UPPER(txt) = 'TXT';
--Aggregate  (cost=9.65..9.66 rows=1 width=0) (actual time=0.792..0.792 rows=1 loops=1)
--   ->  Bitmap Heap Scan on test_performance  (cost=4.29..9.63 rows=5 width=0) (actual time=0.253..0.510 rows=1000 loops=1)
--         Recheck Cond: (upper((txt)::text) = 'TXT'::text)
--         ->  Bitmap Index Scan on txt_indx  (cost=0.00..4.29 rows=5 width=0) (actual time=0.237..0.237 rows=1000 loops=1)
--               Index Cond: (upper((txt)::text) = 'TXT'::text)
-- Total runtime: 0.826 ms
--(6 rows)