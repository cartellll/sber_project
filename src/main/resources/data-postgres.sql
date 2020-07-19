insert into points default values;
insert into points default values;
insert into points default values;
insert into points default values;
insert into points default values;
insert into points default values;

insert into users (name,login,password) values('ivan','cartel','111');
insert into users (name,login,password) values('petr','petro','531');
insert into users (name,login,password) values('Sidr','serdaro','asd123');

insert into userpoint values(1,1);
insert into userpoint values(1,2);
insert into userpoint values(2,4);
insert into userpoint values(2,1);
insert into userpoint values(3,5);
insert into userpoint values(3,3);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('x6', 'bmw', 213, 21, 1);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('a5', 'audi', 13, 213, 1);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('granta', 'lada', 23, 39, 4);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('kalina', 'lada', 35, 83, 2);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('vesta', 'lada', 53, 73, 3);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('niva', 'shevrolet', 25, 63, 1);

INSERT INTO cars(model, manufacturer, quantity, cost, point)
VALUES ('sss', 'shevrolet', 213, 213, 5);

drop sequence if exists cars_sequence;
drop sequence if exists points_sequence;
drop sequence if exists users_sequence;

CREATE SEQUENCE cars_SEQUENCE START WITH 8 INCREMENT BY 1 no cycle;
CREATE SEQUENCE points_SEQUENCE START WITH 7 INCREMENT BY 1 no cycle;
CREATE SEQUENCE users_SEQUENCE START WITH 4 INCREMENT BY 1 no cycle;
