show databases;
DROP DATABASE IF EXISTS p0_brms;
CREATE database p0_brms;
use p0_brms;
DROP TABLE IF EXISTS bus;
CREATE TABLE bus(Bus_Reg_No varchar(10),
 Bus_Type varchar(10),TotalSeats numeric,No_of_Births varchar(25), PRIMARY KEY (Bus_Reg_No));
DESC bus;
 use p0_brms;
 create table admin(user_id varchar(20) unique not null, password varchar(20) not null);

