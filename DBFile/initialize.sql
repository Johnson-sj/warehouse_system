-- create database Warehouse;

 -- create table users (
 -- account char(20) primary key,
 -- pwd char(40),
 -- type int );

 drop table orderstatus,produce,sale,address,restock,deliver,warehouse;

create table warehouse(
id int primary key,
stocks int not null,
Qos int not null);



create table produce(
id int primary key,
name char(40),
price float);
create table sale(
price float ,
number int ,
id int,
orderno int primary key,
totalprice float ,
name char(40));
create table  restock(
id int,
name char(40),
quantity int,
foreign key(id) references produce(id));

create table address (
express int primary key,
addr char(40) );


create table deliver(
orderno int  primary key,
expressno int,
foreign key(orderno) references sale(orderno));

create table orderstatus(
orderno int primary key, 
state char(40),
foreign key(orderno) references sale(orderno));



insert into produce(id,name,price) values(1,'coconut',5.0);
insert into produce(id,name,price)values(2,'milk',3.0);
insert into warehouse(id,stocks,Qos) values(1,500,0);
insert into warehouse(id,stocks,Qos) values(2,500,0);
