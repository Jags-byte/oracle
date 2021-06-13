INSERT into users(username,first_name, last_name, password,email) values ('jags', 'Jagadeesh', 'Murali', '{noop}password','jags@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('user', 'User', 'User Lname', '{noop}password','user@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('admin', 'Admin', 'Admin Lname', '{noop}password','admin@gmail.com');
INSERT into authorities values ('user','USER');
INSERT into authorities values ('admin','ADMIN');
INSERT into authorities values ('jags','ADMIN');

