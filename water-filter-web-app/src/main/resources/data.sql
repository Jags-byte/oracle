INSERT into users(username,first_name, last_name, password,email) values ('jags', 'Jagadeesh', 'Murali', '{noop}password','jags@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('user', 'Agent', 'User', '{noop}password','user@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('admin', 'Admin', 'Admin', '{noop}password','admin@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('agent1', 'Agent', 'Philip', '{noop}password','user@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('agent2', 'Agent', 'Two', '{noop}password','user@gmail.com');
INSERT into users(username,first_name, last_name, password,email) values ('agent3', 'Agent', 'Three', '{noop}password','user@gmail.com');
INSERT into authorities values ('user','USER');
INSERT into authorities values ('admin','ADMIN');
INSERT into authorities values ('jags','ADMIN');
INSERT into authorities values ('agent1','USER');
INSERT into authorities values ('agent2','USER');
INSERT into authorities values ('agent3','USER');