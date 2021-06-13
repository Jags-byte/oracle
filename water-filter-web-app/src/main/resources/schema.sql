create table users(
	username varchar(50) not null primary key,
	first_name varchar(50),
	last_name varchar(50),
	password varchar(200) not null,
	email varchar(100) not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
