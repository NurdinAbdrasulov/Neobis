 alter table car_models drop foreign key FK4b1p38n8ajvxw1obwfn4hgrb1;
 alter table cars drop foreign key FK8u2qxfl5fxb90neutelhsmt1w;
 alter table cars drop foreign key FK6hctqxdwhcl223hfxh4swhdxm;
 alter table cars drop foreign key FKkys7hpraytmuby6dgcwfk7bxk;
 alter table cars_garage drop foreign key FK2bxv9sndsm7ecf81p7dk0q1wd;
 alter table manufacturers drop foreign key FKhf3v0megehc0nr2sqdpjalyhu;
 alter table ordered_cars_cars drop foreign key FKai1o2piywp8wbfbl6r9bnxi22;
 alter table ordered_cars_cars drop foreign key FKg80apc83ytelqd2vc9rby1kpq;
 alter table sales drop foreign key FKhb80sy23hk4kk9s4g271uw9ci;
 alter table sales drop foreign key FK7vawuoopb9gaswjhck9d9kpje;
 alter table sales drop foreign key FK2jitm3kpqyikxeo6s0a37v99j;
 drop table if exists car_brands;
 drop table if exists car_models;
 drop table if exists cars;
 drop table if exists cars_garage;
 drop table if exists clients;
 drop table if exists employees;
 drop table if exists manufacturers;
 drop table if exists ordered_cars;
 drop table if exists ordered_cars_cars;
 drop table if exists sales;

 create table car_brands (
id integer not null auto_increment,
brand varchar(255),
primary key (id));

 create table car_models (
id integer not null auto_increment,
model varchar(255),
car_brand_id integer,
primary key (id));

 create table cars (
id integer not null auto_increment,
body_style varchar(255),
color varchar(255),
price double precision,
year_of_manufacture datetime(6),
brand_id integer,
manufacturer_id integer,
model_id integer,
primary key (id));

 create table cars_garage (
id integer not null auto_increment,
count_of_cars integer not null,
cars_id integer,
primary key (id));

 create table clients (
id integer not null auto_increment,
address varchar(255),
date_of_birth datetime(6),
fio varchar(255),
gender varchar(255),
phone_number varchar(255),
registration_date datetime(6),
primary key (id));

 create table employees (
id integer not null auto_increment,
address varchar(255),
fio varchar(255),
gender varchar(255),
phone_number varchar(255),
position varchar(255),
primary key (id)) ;

 create table manufacturers (
 id integer not null auto_increment,
 address varchar(255),
 country varchar(255),
 phone_number varchar(255),
 brand_id integer,
 primary key (id));

 create table ordered_cars (
id integer not null auto_increment,
order_date datetime(6),
count_of_cars integer not null,
status varchar(255),
primary key (id));

 create table ordered_cars_cars
(ordered_cars_id integer not null,
 cars_id integer not null);


 create table sales (
id integer not null auto_increment,
count_of_cars integer not null,
paid double precision not null,
payment_amount double precision not null,
registration_date datetime(6),
status varchar(255),
car_id integer,
clients_id integer,
employee_id integer,
primary key (id));


 alter table ordered_cars_cars
add constraint UK_4m4243ho698t8hfh6n6mfigew unique (cars_id);

 alter table car_models
add constraint FK4b1p38n8ajvxw1obwfn4hgrb1 foreign key (car_brand_id) references car_brands (id);

 alter table cars
add constraint FK8u2qxfl5fxb90neutelhsmt1w foreign key (brand_id) references car_brands (id);

 alter table cars
add constraint FK6hctqxdwhcl223hfxh4swhdxm foreign key (manufacturer_id) references manufacturers (id);

 alter table cars
add constraint FKkys7hpraytmuby6dgcwfk7bxk foreign key (model_id) references car_models (id);

 alter table cars_garage
add constraint FK2bxv9sndsm7ecf81p7dk0q1wd foreign key (cars_id) references cars (id);

 alter table manufacturers add
constraint FKhf3v0megehc0nr2sqdpjalyhu foreign key (brand_id) references car_brands (id);

 alter table ordered_cars_cars
add constraint FKai1o2piywp8wbfbl6r9bnxi22 foreign key (cars_id) references cars (id);

 alter table ordered_cars_cars
add constraint FKg80apc83ytelqd2vc9rby1kpq foreign key (ordered_cars_id) references ordered_cars (id);

 alter table sales
add constraint FKhb80sy23hk4kk9s4g271uw9ci foreign key (car_id) references cars (id);

 alter table sales
add constraint FK7vawuoopb9gaswjhck9d9kpje foreign key (clients_id) references clients (id);

 alter table sales
add constraint FK2jitm3kpqyikxeo6s0a37v99j foreign key (employee_id) references employees (id);
