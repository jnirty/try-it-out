CREATE DATABASE LINK REMOTE_SCHEMA
CONNECT TO REMOTE_SCHEMA IDENTIFIED BY schema_password
USING 'LINK_NAME';


select * from REMOTE_TABLE@LINK_NAME