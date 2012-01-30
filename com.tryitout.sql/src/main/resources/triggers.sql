-- triggers are stored procedures (functions stored in DB) that execute
-- after specific event, e.g: UPDATE, CREATE on DB objects (table, index, sequence)
-- http://www.postgresql.org/docs/8.1/static/triggers.html
-- http://www.postgresql.org/docs/9.1/static/sql-createtrigger.html
-- http://wiki.postgresql.org/wiki/A_Brief_Real-world_Trigger_Example

-- create trigger function:
CREATE OR REPLACE FUNCTION check_person_update() RETURNS TRIGGER AS '
	DECLARE
		num INTEGER;
		str VARCHAR(255);
	BEGIN
		IF TG_RELNAME = ''person'' THEN
			-- check if no more than 2 users with same name and surname exist
			SELECT count(*) INTO num FROM person WHERE name=NEW.name AND surname=NEW.surname;
			IF num <= 2 THEN
				-- person is valid
				RETURN NEW;
			ELSE
				str := ''Error inserting/updating table: '' || TG_RELNAME || '' => 2 people already exist with this name,surname!'' ;
				RAISE EXCEPTION ''%'',str;
				-- RAISE NOTICE ''%'',str;
				RETURN NULL;
			END IF;
		END IF;
	END
' LANGUAGE plpgsql;

-- create trigger
DROP TRIGGER IF EXISTS check_update;
CREATE TRIGGER check_update 
	BEFORE UPDATE OR INSERT ON person
	FOR EACH ROW
	EXECUTE PROCEDURE check_person_update();
	
-- try inserting more than 2 people with the same name/surname
insert into person(pk_person_id,name,surname)values(9,'jan','opania');
insert into person(pk_person_id,name,surname)values(10,'jan','opania');
insert into person(pk_person_id,name,surname)values(11,'jan','opania');


SELECT count(*) FROM person WHERE name='jan' AND surname='opania';
