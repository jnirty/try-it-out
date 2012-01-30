-- INNER JOIN - get all people that have company and car
select p.name, p.surname, c.plate_no
from person p
inner join car c
on c.fk_person_id = p.pk_person_id;

SELECT 
	c.color, 
	c.plate_no,
	p.name,
	p.surname,
	comp.name AS company
FROM car c INNER JOIN person p
ON c.fk_person_id = p.pk_person_id
INNER JOIN company_person comp_pers
ON p.pk_person_id = comp_pers.fk_person_id
INNER JOIN company comp
ON comp.pk_company_id = comp_pers.fk_company_id;

-- LEFT OUTER JOIN - get all people and company & car data if they exist

SELECT 
	c.color, 
	c.plate_no,
	p.name,
	p.surname,
	comp.name AS company
FROM person p LEFT OUTER JOIN car c
ON c.fk_person_id = p.pk_person_id
LEFT OUTER JOIN company_person comp_pers
ON p.pk_person_id = comp_pers.fk_person_id
LEFT OUTER JOIN company comp
ON comp.pk_company_id = comp_pers.fk_company_id
GROUP BY c.color, c.plate_no, p.name, p.surname, comp.name;

select p.name, p.surname, c.plate_no
from person p
left outer join car c
on c.fk_person_id = p.pk_person_id;

-- LEFT OUTER JOIN - get all people and car (if exist for person)

select p.name, p.surname, c.plate_no  
from person p
left outer join car c
on c.fk_person_id = p.pk_person_id;

-- RIGHT JOIN

select p.name, p.surname, c.plate_no
from person p
right outer join car c
on c.fk_person_id = p.pk_person_id;

-- FULL JOIN - get all people and companies

select p.name, p.surname, c.plate_no
from person p
full join car c
on c.fk_person_id = p.pk_person_id;

--UNION - combine data from deferent tables, but the column number and data type of combined data must be the same

select p.name, p.surname
from person p
UNION
select c.plate_no, c.color from car c;

-- VIEW - a view is a frozen query (you can only SELECT from it)
-- Oracle, MySQL, MSSQL allow UPDATABLE VIEW - a view 
-- on which you can INSERT, UPDATE & DELETE, but it can be 
-- constructed from only one table.
-- ! performance: a view is only as fast as a query

DROP VIEW IF EXISTS vwPeopleWithCar;

CREATE VIEW vwPeopleWithCar
AS
	SELECT p.pk_person_id, p.name, p.surname, c.plate_no, c.color
	FROM person p INNER JOIN car c
	ON p.pk_person_id = c.fk_person_id;


-- insert new data and check that the view will contain new line:
select count(*) from vwPeopleWithCar;
INSERT INTO person VALUES(5,'Jan','Maliniak');
INSERT INTO car    VALUES(5,'blue','el3003',5);
select count(*) from vwPeopleWithCar;

SELECT name, surname 
FROM vwPeopleWithCar
WHERE color = 'red';

-- you can combie views and tables in SELECTs
SELECT DISTINCT vw.name, vw.surname, c.name
FROM vwPeopleWithCar vw
INNER JOIN company_person cp
ON cp.fk_person_id = vw.pk_person_id
INNER JOIN company c
ON cp.fk_company_id = c.pk_company_id;


-- MATERIALIZED VIEW - a view that must be periodically refreshed, because
-- it updates only during a refresh, not when data is inserted to tables from which it 
-- was originally created.
-- ! performance: it is like a table, searches quicker, indexes can be set
-- in PostgreSQL currently possible only by creating tables from unmaterialized view
-- and adding triggers to update the table when original tables change
DROP TABLE IF EXISTS mvwPeopleWithCar;

CREATE TABLE mvwPeopleWithCar
AS
	SELECT *
	FROM vwPeopleWithCar;


-- insert new data and check that the materialized view will not be updated:
select count(*) from mvwPeopleWithCar;
select * from mvwPeopleWithCar;
INSERT INTO person VALUES(6,'Adam','Zaorski');
INSERT INTO car    VALUES(6,'cyan','el3113',6);
select count(*) from mvwPeopleWithCar;
select * from mvwPeopleWithCar;

-- INTERSECT - include only the records from 1st query that 
-- have matching records in 2nd query
-- each intersect query must have the same number of columns
SELECT pk_person_id FROM person
INTERSECT
SELECT fk_person_id FROM car;

--EXCEPT - oposite to INTERSECT, include only the records from 1st query that 
-- DO NOT have matching records in 2nd query
SELECT pk_person_id FROM person
EXCEPT
SELECT fk_person_id FROM car;


-- SYNONYMS/ALIASES - PostgreSLQ does not support, in Oracle:
-- CREATE ALIAS osoba for people

