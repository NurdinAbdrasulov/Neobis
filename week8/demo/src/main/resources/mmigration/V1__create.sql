drop table if exists cars;

create table cars (
id integer not null auto_increment,
brand varchar(255),
model varchar(255),
body_style varchar(255),
year_of_manufacture datetime(6),
color varchar(255),
price double precision,
primary key (id));