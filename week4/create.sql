CREATE DATABASE week4;
USE week4;

CREATE TABLE cars(
id int ,
brand varchar(21) not null,
model varchar(21) not null,
body_style varchar(21),
year_of_manufacture date,
color varchar(21),
price double);

CREATE TABLE clients(
id int,
fio varchar(255) not null,
gender varchar(6) not null,
phone_number varchar(10),
date_of_birth date,
registration_date date not null,
address varchar(100));

CREATE TABLE sales(
id int,
_status varchar(21),
car_id int,
client_id int);


ALTER TABLE cars 
MODIFY COLUMN id INT auto_increment primary key;

ALTER TABLE clients 
MODIFY COLUMN id INT auto_increment primary key;

ALTER TABLE sales 
MODIFY COLUMN id INT auto_increment primary key;

ALTER TABLE sales
ADD ( CONSTRAINT fk_car_id foreign key(car_id) references cars(id),
 CONSTRAINT fk_client_id foreign key(client_id) references clients(id));


INSERT INTO cars
VALUES(1, "bmw", "x6", "crossover", "2020-01-01", "white", 91000.1),
(2, "lexus", "LX570", "SUV", "2020-01-02", "white", 92000.2),
(3, "mercedes", "GLS 450", "SUV", "2020-01-03", "white", 93000.3),
(4, "toyota", "land cruiser 200", "SUV", "2020-01-04", "white", 94000.4),
(5, "subaru", "brz", "coupe", "2020-01-05", "white", 95000.5);

INSERT INTO clients
VALUES(1, "ФИО1", "male", "0777111111", "2000-01-01", "2020-09-01", "Chuy 1"),
(2, "ФИО2", "male", "0777111222", "2000-02-01", "2020-09-02", "Chuy 2"),
(3, "ФИО3", "female", "0777111333", "2000-03-01", "2020-09-03", "Chuy 3"),
(4, "Фамлия Имя Отчество", "male", "0777111444", "2000-04-01", "2020-09-04", "Chuy 4");

INSERT INTO sales
VALUES(1, "success", 1, 1),
(2, "success", 2, 1),
(3, "success", 3, 2),
(4, "success", 4, 3),
(5, "in process", 5, 4);

