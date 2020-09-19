DROP DATABASE IF EXISTS train_stationMS;
CREATE DATABASE IF NOT EXISTS train_stationMS;
USE train_stationMS;

CREATE TABLE customer(
customer_ID VARCHAR(10) PRIMARY KEY ,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50)
);

CREATE TABLE primary_driver(
primary_driver_ID VARCHAR(10) PRIMARY KEY,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50) DEFAULT 'Not added',
reg_date DATE NOT NULL,
position VARCHAR(15)
);

CREATE TABLE assistant_driver(
assistant_driver_ID VARCHAR(10) PRIMARY KEY,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50) DEFAULT 'Not added',
reg_date DATE NOT NULL,
position VARCHAR(15)
);

CREATE TABLE cashier(
cashier_ID VARCHAR(10) PRIMARY KEY,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50) DEFAULT 'Not added',
reg_date DATE NOT NULL,
position VARCHAR(15)
);

CREATE TABLE route(
route_ID VARCHAR (10) PRIMARY KEY ,
route_rank VARCHAR (10) NOT NULL,
start VARCHAR (10) NOT NULL,
destination VARCHAR (10) NOT NULL,
estimated_time time NOT NULL
);

CREATE TABLE station(
station_ID VARCHAR(10) PRIMARY KEY,
route_ID VARCHAR (10) NOT NULL,
station_name VARCHAR(60) NOT NULL,
distance int(11) NOT NULL,
duration VARCHAR (11) NOT NULL,
FOREIGN KEY (route_ID) REFERENCES route(route_ID)
);

CREATE TABLE train(
engine_number VARCHAR(10) PRIMARY KEY,
engine_type VARCHAR(10) NOT NULL,
fuel_capacity int(10) NOT NULL,
station_ID VARCHAR(10),
FOREIGN KEY (station_ID) REFERENCES station(station_ID)
);

CREATE TABLE seat_detail(
engine_number VARCHAR(10),
1st_clas_seat_count int(10),
2st_clas_seat_count int(10),
3st_clas_seat_count int(10),
FOREIGN KEY (engine_number) REFERENCES Train(engine_number)
);

CREATE TABLE schedule(
schedule_ID VARCHAR (10) PRIMARY KEY,
engine_number VARCHAR (10) NOT NULL,
primary_driver_ID VARCHAR(10) NOT NULL,
assistant_driver_ID VARCHAR(10) NOT NULL,
route_ID VARCHAR (10) NOT NULL,
date DATE NOT NULL,
time TIME  NOT NULL,
FOREIGN KEY (engine_number) REFERENCES Train(engine_number),
FOREIGN KEY (primary_driver_ID) REFERENCES primary_driver(primary_driver_ID),
FOREIGN KEY (assistant_driver_ID) REFERENCES assistant_driver(assistant_driver_ID),
FOREIGN KEY (route_ID) REFERENCES route(route_ID)
);

CREATE TABLE ticket_prices(
ticket_price_ID VARCHAR (10) PRIMARY KEY,
station_ID VARCHAR(10),
route_ID VARCHAR (10),
1st_class_seat_price int(10),
2st_class_seat_price int(10),
3st_class_seat_price int(10),
FOREIGN KEY (station_ID) REFERENCES station(station_ID),
FOREIGN KEY (route_ID) REFERENCES route(route_ID)
);

CREATE TABLE booking(
booking_ID VARCHAR (10) PRIMARY KEY ,
schedule_ID VARCHAR (10) NOT NULL ,
customer_ID VARCHAR (10) NOT NULL ,
ticket_price_ID VARCHAR (10) NOT NULL,
FOREIGN KEY (schedule_ID) REFERENCES schedule(schedule_ID),
FOREIGN KEY (customer_ID) REFERENCES customer(customer_ID),
FOREIGN KEY (ticket_price_ID) REFERENCES ticket_prices(ticket_price_ID)
);

CREATE TABLE booking_Details(
booking_Details_ID VARCHAR (10) PRIMARY KEY ,
booking_ID VARCHAR (10),
reserved_class VARCHAR (10),
reserved_seat_count INT (10),
FOREIGN KEY (booking_ID) REFERENCES booking(booking_ID)
);

CREATE TABLE payment(
payment_ID VARCHAR (10) PRIMARY KEY ,
booking_ID VARCHAR (10) NOT NULL ,
ticket_price DOUBLE (10,2) NOT NULL,
paid_price DOUBLE (10,2) NOT NULL,
payment_method VARCHAR (10) DEFAULT 'not paid'
);

CREATE TABLE users(
-- user_ID int AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR (50) PRIMARY KEY ,
user_password VARCHAR (20) NOT NULL,
position VARCHAR (10) NOT NULL
);

INSERT INTO users(user_name,user_password,position) VALUES("admin","1234","admin");
INSERT INTO users(user_name,user_password,position) VALUES("yohan","1234","admin");
INSERT INTO users(user_name,user_password,position) VALUES("lochana","1234","employee");
INSERT INTO users(user_name,user_password,position) VALUES("hashan","1234","employee");

desc station;
desc route;
