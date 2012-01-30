-- indexes increase performance of queries when include columns used in WHERE or GROUP BY clauses
-- index can be made on multiple columns, an order matters - first col. name is most important, 
-- 	sometimes DB does not use index if WHERE contains 2nd, 3rd,.. index columns
-- indexes are by default set on primary key columns
-- Function-based index (FBI) - e.g. when we want to use functions in WHERE, e.g. case insensitive match
-- indexes work better on columns with numerical values, worse on text values
-- UNIQUE INDEX - set on column which has unique values (and value cannot be NULL)
-- CLUSTERED INDEX - in Oracle = index organized table (IOT), can be only one per table,
--      when created on table then data is organized in tablle according to index (highest search performance)
--      should be created on columns with most static data, every change of data results in reordering the table

-- create an index
DROP INDEX IF EXISTS ix_person_name;
CREATE INDEX ix_person_name ON person(name);

-- create function-based index
DROP INDEX IF EXISTS ix_person_name;
CREATE INDEX ix_person_name ON person(UPPER(name));
-- then this query will use index:
select * from person where UPPER(name) = 'ADAM';

-- create clustered index in PostgreSLQ
CLUSTER person USING ix_person_name;


-- Oracle has a feature to try out how dropping an index impacts performance
-- without dropping it, but making it invisible (but only withing a session);
-- ALTER INDEX <index_name> INVISIBLE;
