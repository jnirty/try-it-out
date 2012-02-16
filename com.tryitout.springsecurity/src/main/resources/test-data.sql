-- create groups
insert into groups(group_name) values ('Users');
insert into groups(group_name) values ('Administrators');

-- add roles to groups
insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Users'; 
insert into group_authorities(group_id, authority) select id,'ROLE_USER' from groups where group_name='Administrators'; 
insert into group_authorities(group_id, authority) select id,'ROLE_ADMIN' from groups where group_name='Administrators'; 

-- create users
INSERT INTO users (username, password, enabled, salt) VALUES ('admin', 'admin', true, CAST(RAND() * 1000000000 as varchar));
INSERT INTO users (username, password, enabled, salt) VALUES ('guest', 'guest', true, CAST(RAND() * 1000000000 as varchar));

-- add users to groups
insert into group_members(group_id, username) select id,'guest' from groups where group_name='Users';
insert into group_members(group_id, username) select id,'admin' from groups where group_name='Administrators';

COMMIT;