DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS company_person;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS company;

CREATE TABLE person(
pk_person_id int primary key,
name varchar(255),
surname varchar(255)
);

CREATE TABLE car(
pk_car_id int primary key,
color varchar(255),
plate_no varchar(255),
fk_person_id int references person(pk_person_id),
engine_num   varchar(20),
manuf_date date,
country varchar(20)
);
	
CREATE TABLE company(
pk_company_id int primary key,
name varchar(255)
);

CREATE TABLE company_person(
fk_company_id int references company(pk_company_id),
fk_person_id int references person(pk_person_id)
);

INSERT INTO person VALUES(0,'Jan','Kowalski');
INSERT INTO person VALUES(1,'Adam','Mickiewicz');
INSERT INTO person VALUES(2,'Zofia','Pawlikowska');
INSERT INTO person VALUES(3,'Henryk','Sienkiewicz');
INSERT INTO person VALUES(4,'Konstanty','Gałczyński');

INSERT INTO car VALUES(0,'red','ezg2334',1);
INSERT INTO car VALUES(1,'silver','el3445',1);
INSERT INTO car VALUES(2,'green','po2333',2);
INSERT INTO car VALUES(3,'red','wa4455',3);
INSERT INTO car VALUES(4,'yellow','wl885',null);

INSERT INTO company VALUES(0,'PTC');
INSERT INTO company VALUES(1,'Teleca');
INSERT INTO company VALUES(2,'TT');

INSERT INTO company_person VALUES(0,0);
INSERT INTO company_person VALUES(0,1);
INSERT INTO company_person VALUES(1,1);
