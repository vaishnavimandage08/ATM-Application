create database atm;

show databases;

create table  signup(formno varchar(20),name varchar(20),fname varchar(20),dob varchar (30),gender varchar(20) ,email varchar(20), marital_status varchar(20),address varchar(40) , 
city varchar(25), state varchar(20),pin varchar(25));

create table  signup2(formno varchar(20),religion varchar(20),category  varchar(20),income varchar (30),
education varchar(20) ,occupation varchar(20), pan varchar(20),aadhar varchar(40) , scitizen varchar(25), eaccount varchar (20));

create table signup3(formno varchar(20) , atype varchar(25),cardno varchar(50),pin varchar(30),facility varchar(30));

create table login(formno varchar(20),cardno varchar(30),pin varchar(35));

create table bank (pin varchar(25),date DATE ,Withdrawl varchar(50),amount varchar(50)); 

select * from bankbank