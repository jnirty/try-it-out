INSERT INTO users (username, password, enabled) VALUES ('admin', 'admin', true);
INSERT INTO authorities (username, authority) VALUES ('admin','ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('admin','ROLE_ADMIN');
INSERT INTO users (username, password, enabled) VALUES ('guest', 'guest', true);
INSERT INTO authorities (username, authority) VALUES ('guest','ROLE_USER');
COMMIT;