CREATE TABLE users(
	id integer auto_increment primary key,
    username varchar(255) not null,
    password varchar(255) not null
);

describe users;

CREATE TABLE generators(
	id integer auto_increment primary key,
    name varchar(255) not null,
    description text,
    rate integer(11),
    base_cost integer(11),
    unlock_at integer(11) ,
    created_by integer(11) references users(id), index(created_by)
);

describe generators;

CREATE TABLE events(
	id integer auto_increment primary key ,
    name varchar(255) not null,
    description text,
    trigger_at integer, 
    created_by integer references users(id), index(created_by)
);

describe events;

CREATE TABLE quantities(
	generator_id integer(11) not null references generators(id), index(generator_id),
    token varchar(255),
    quantity integer(11) default 0
);

describe quantities;

insert into users (id, username, password) values (0, "admin", "cs3220password"),(0, "me", "notapassword");

select * from users;


insert into generators (id, name, description, rate, base_cost, unlock_at, created_by) values
(0, "Grandma", "Grandma likes to make cookies", 5, 10, 10, 1),
(0, "Factory", "Factory to produce cookies" , 10, 50, 50, 1),
(0, "Mine" , "Mining cookies", 20, 200, 200, 2);

select * from generators;


insert into events (id, name, description, trigger_at, created_by) values
(0 , "Grandma shows up", "You always know grandma likes to make cookies", 10, 1),
(0 , "You can construct factory now!", "Factory to produce cookies", 50, 1),
(0 , "We've found cookies in deep mountain ... in the mine?", "Mining cookies", 200, 2),
(0 , "sample event", "This is a sample event. Please delete me", 99999, 2);

select * from events;

insert into quantities(generator_id, token, quantity) values
(1,"c7a69d44e0b9b415b2d9956cb26b944a",2), 
(2,"c7a69d44e0b9b415b2d9956cb26b944a",1), 
(1,"80516ce4663c3bd0c8385309a2fe226e",20), 
(2,"80516ce4663c3bd0c8385309a2fe226e",30);