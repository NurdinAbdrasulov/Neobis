
create table car_brands (
                            id integer not null,
                            brand varchar(255),
                            primary key (id))  ;

create table car_models (
                            id integer not null,
                            model varchar(255),
                            car_brand_id integer,
                            primary key (id))  ;

create table cars (
                      id integer not null,
                      body_style varchar(255),
                      color varchar(255),
                      price double precision,
                      year_of_manufacture date,
                      brand_id integer,
                      manufacturer_id integer,
                      model_id integer, primary key (id))  ;

create table cars_garage (
                             id integer not null,
                             count_of_cars integer not null,
                             cars_id integer,
                             primary key (id))  ;

create table clients (
                         id integer not null,
                         address varchar(255),
                         date_of_birth date,
                         fio varchar(255),
                         gender varchar(255),
                         login varchar(255),
                         password varchar(255),
                         phone_number varchar(255),
                         registration_date date,
                         role varchar(255),
                         primary key (id))  ;

create table employees (id integer not null, address varchar(255), fio varchar(255), gender varchar(255), login varchar(255), password varchar(255), phone_number varchar(255), position varchar(255), role varchar(255), primary key (id))  ;
create table manufacturers (id integer not null, address varchar(255), country varchar(255), phone_number varchar(255), brand_id integer, primary key (id))  ;
create table ordered_cars (id integer not null, order_date date, count_of_cars integer not null, status varchar(255), primary key (id))  ;
create table ordered_cars_cars (ordered_cars_id integer not null, cars_id integer not null)  ;
create table sales (id integer not null, count_of_cars integer not null, paid double precision not null, payment_amount double precision not null, registration_date date, status varchar(255), car_id integer, clients_id integer, employee_id integer, primary key (id))  ;
alter table ordered_cars_cars add constraint UK_4m4243ho698t8hfh6n6mfigew unique (cars_id);
alter table car_models add constraint FK4b1p38n8ajvxw1obwfn4hgrb1 foreign key (car_brand_id) references car_brands (id);
alter table cars add constraint FK8u2qxfl5fxb90neutelhsmt1w foreign key (brand_id) references car_brands (id);
alter table cars add constraint FK6hctqxdwhcl223hfxh4swhdxm foreign key (manufacturer_id) references manufacturers (id);
alter table cars add constraint FKkys7hpraytmuby6dgcwfk7bxk foreign key (model_id) references car_models (id);
alter table cars_garage add constraint FK2bxv9sndsm7ecf81p7dk0q1wd foreign key (cars_id) references cars (id);
alter table manufacturers add constraint FKhf3v0megehc0nr2sqdpjalyhu foreign key (brand_id) references car_brands (id);
alter table ordered_cars_cars add constraint FKai1o2piywp8wbfbl6r9bnxi22 foreign key (cars_id) references cars (id);
alter table ordered_cars_cars add constraint FKg80apc83ytelqd2vc9rby1kpq foreign key (ordered_cars_id) references ordered_cars (id);
alter table sales add constraint FKhb80sy23hk4kk9s4g271uw9ci foreign key (car_id) references cars (id);
alter table sales add constraint FK7vawuoopb9gaswjhck9d9kpje foreign key (clients_id) references clients (id);
alter table sales add constraint FK2jitm3kpqyikxeo6s0a37v99j foreign key (employee_id) references employees (id);
