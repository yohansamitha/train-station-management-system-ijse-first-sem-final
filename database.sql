DROP DATABASE IF EXISTS train_stationMS;
CREATE DATABASE IF NOT EXISTS train_stationMS;
USE train_stationMS;

CREATE TABLE customer(
customer_ID VARCHAR(10) PRIMARY KEY ,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50),
status VARCHAR (10) DEFAULT 'active'
);

CREATE TABLE primary_driver(
primary_driver_ID VARCHAR(10) PRIMARY KEY,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50) DEFAULT 'Not added',
reg_date DATE NOT NULL,
position VARCHAR(20),
status VARCHAR (10) DEFAULT 'active'
);

CREATE TABLE assistant_driver(
assistant_driver_ID VARCHAR(10) PRIMARY KEY,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50) DEFAULT 'Not added',
reg_date DATE NOT NULL,
position VARCHAR(20),
status VARCHAR (10) DEFAULT 'active'
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
train_name VARCHAR (100) NOT NULL,
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

CREATE TABLE users(
user_ID int AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR (50) NOT NULL ,
user_password VARCHAR (20) NOT NULL,
position VARCHAR (10) NOT NULL
);

CREATE TABLE cashier(
cashier_ID VARCHAR(10) PRIMARY KEY,
user_ID int Not NULL,
first_name VARCHAR(60) NOT NULL,
last_name VARCHAR(60) NOT NULL,
DOB DATE,
address VARCHAR(60) NOT NULL,
email_address VARCHAR(50) DEFAULT 'Not added',
reg_date DATE NOT NULL,
position VARCHAR(20),
status VARCHAR (10) DEFAULT 'active',
FOREIGN KEY (user_ID) REFERENCES users(user_ID)
);

CREATE TABLE booking(
booking_ID VARCHAR (10) PRIMARY KEY ,
schedule_ID VARCHAR (10) NOT NULL ,
customer_ID VARCHAR (10) NOT NULL ,
ticket_price_ID VARCHAR (10) NOT NULL,
cashier_ID VARCHAR(10) NOT NULL ,
FOREIGN KEY (schedule_ID) REFERENCES schedule(schedule_ID),
FOREIGN KEY (customer_ID) REFERENCES customer(customer_ID),
FOREIGN KEY (ticket_price_ID) REFERENCES ticket_prices(ticket_price_ID),
FOREIGN KEY (cashier_ID) REFERENCES cashier(cashier_ID)
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



INSERT INTO users(user_name,user_password,position) VALUES("admin","1234","admin");
INSERT INTO users(user_name,user_password,position) VALUES("yohan","1234","admin");
INSERT INTO users(user_name,user_password,position) VALUES("lochana","1234","cashier");
INSERT INTO users(user_name,user_password,position) VALUES("hashan","1234","cashier");

desc station;
desc route;

INSERT INTO cashier(cashier_ID, user_ID, first_name, last_name, DOB, address, email_address, reg_date, position) VALUES
("E001",3,"Lochana","mithudam","2020-09-16","no 25 panadura","lochanathiwanka@gmail.com","2020-09-16","cashier");

INSERT INTO cashier(cashier_ID, user_ID, first_name, last_name, DOB, address, email_address, reg_date, position) VALUES
("E002",4,"hashan","saminda",'1992-06-10',"no 25 mathugama","hashansaminda@gmail.com",'2020-09-22',"cashier");

INSERT INTO cashier(cashier_ID, user_ID, first_name, last_name, DOB, address, email_address, reg_date, position) VALUES
("E003",2,"yohan","samitha",'2000-12-25',"no 25 panadura","yohansamitha123@gmail.com",'2020-09-25',"admin");

INSERT INTO assistant_driver(assistant_driver_ID, first_name, last_name, DOB, address, email_address, reg_date, position) VALUES
("A001","malindu","umesh",'1999-03-02',"no 69 polonnaruwa","malinduUmash123@gmail.com",'2020-09-25',"assistantDriver");

INSERT INTO assistant_driver(assistant_driver_ID, first_name, last_name, DOB, address, email_address, reg_date, position) VALUES
("A002","gathsara","umesh",'2000-05-20',"no 69 rathnapura","gathsaraumesh123@gmail.com",'2020-09-25',"assistantDriver");

INSERT INTO primary_driver(primary_driver_ID, first_name, last_name, DOB, address, email_address, reg_date, position) VALUES
("P001","udara","janith",'2000-01-09',"no 69 parana para","udaraJanith123@gmail.com",'2020-09-25',"primaryDriver");

INSERT INTO customer(customer_ID, first_name, last_name, DOB, address, email_address) VALUES
("C001","mallika","perera",'2000-01-11',"no 20 yapanaya","mallika@gmail.com"),
("C002","hemanthi","silva",'2000-02-12',"no 20 nalluruwa","hemanthi@gmail.com"),
("C003","awanthi","shashikala",'2000-03-13',"no 20 ambalangoda","awanthi@gmail.com"),
("C004","udara","janith",'2000-04-14',"no 20 paraththa","udara@gmail.com"),
("C005","siripala","punsuri",'2000-05-15',"no 20 thunpane","siripala@gmail.com"),
("C006","nittawa","aefeae",'2000-06-16',"no 20 mulathiw","nittawa@gmail.com"),
("C007","lochana","thiwanka",'2000-07-17',"no 20 nalluruwa","lochana@gmail.com"),
("C008","thilina","dilshan",'2000-08-18',"no 20 halawatha","thilina@gmail.com");

INSERT INTO route(route_ID, route_rank, start, destination, estimated_time) VALUES
("R001","1","petta","badulla","19:30:10");

INSERT INTO station(station_ID, route_ID, station_name, distance, duration) VALUES
("S001","R001","moratuwa station",10,"01:00:00"),
("S002","R001","rawathawatta station",20,"02:00:00"),
("S003","R001","galkissa station",30,"03:00:00"),
("S004","R001","pothupiitiya station",40,"04:00:00"),
("S005","R001","rathmalana station",50,"05:00:00"),
("S006","R001","galla station",60,"06:00:00");

INSERT INTO train(engine_number, train_name, engine_type, fuel_capacity, station_ID) VALUES
("Eng1020","mallika","Express",100,"S002");

INSERT INTO seat_detail(engine_number, 1st_clas_seat_count, 2st_clas_seat_count, 3st_clas_seat_count) VALUES
("Eng1020",30,40,50);

INSERT INTO ticket_prices(ticket_price_ID, station_ID, route_ID, 1st_class_seat_price, 2st_class_seat_price, 3st_class_seat_price) VALUES
("T001","S001","R001",100,80,60);

select cashier_ID,first_name,last_name,DOB,address,email_address,reg_date,position from cashier union
select primary_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from primary_driver union
select assistant_driver_ID,first_name,last_name,DOB,address,email_address,reg_date,position from assistant_driver;

-- select * from member where memberID like '"+txtSearch.getText()+"%' or"
--                 + " name like '"+txtSearch.getText()+"%' or "
--                 + "address like '"+txtSearch.getText()+"%' or "
--                 + "type like '"+txtSearch.getText()+"%' or "
--                 + "contactNumber like '"+txtSearch.getText()+"%'
btn.setOnMouseEntered(e -> {
            btn.setEffect(new Bloom(0));
            btn.setStyle("-fx-border-color: #ffffff;");
        });
        btn.setOnMouseExited(e -> {
            btn.setEffect(new Bloom(1));
            btn.setStyle("-fx-background-color: transparent;");
        });
-- working
-- select * from cashier where cashier_ID like '"+E002+"%' or first_name like '"hashan+"%'























