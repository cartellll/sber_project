drop table if exists userPoint;
drop table if exists cars;
drop table if exists Points;
drop table if exists users;

create table IF NOT EXISTS Points(id BIGSERIAL primary key);
create table IF NOT EXISTS cars(id BIGSERIAL Primary key check(ID>0), model varchar(100),manufacturer varchar(100),
quantity int check(quantity>0), cost int check(cost>0), point int check(point>=0),foreign key (point) references Points(id));
create table IF NOT EXISTS Users(id BIGSERIAL primary key,name varchar(100),login varchar(100) unique,password varchar(100));
create table IF NOT EXISTS UserPoint(id_user int  references Users(id),id_point int references Points(id), primary key(id_user,id_point));

