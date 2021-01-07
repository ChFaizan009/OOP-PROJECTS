create database fastFood;
use fastFood;

CREATE TABLE EMPLOYEE(
employeeCode INT,
employeeName VARCHAR (50) DEFAULT NULL,
employeeAge INT DEFAULT NULL, 
employeeContactNumber long DEFAULT NULL, 
employeeWorkHours INT DEFAULT NULL, 
employeeStatus VARCHAR (15) DEFAULT NULL, 
employeeAddress VARCHAR (100) DEFAULT NULL, 
employeeSalary INT DEFAULT NULL, 
isWorking BOOLEAN DEFAULT NULL,
PRIMARY KEY (employeeCode));

CREATE TABLE CUSTOMER(
customerEntryNumber INT, 
customerName VARCHAR (50) DEFAULT NULL, 
customerBill INT DEFAULT NULL, 
customerFoodItemIds VARCHAR (50) DEFAULT NULL, 
customerFoodPurchaseTime VARCHAR (100) DEFAULT NULL,
foodItem varchar(50) DEFAULT NULL, 
customerMemberShipId INT DEFAULT NULL, 
orderId INT DEFAULT NULL,
PRIMARY KEY (customerEntryNumber)
);

CREATE TABLE CUSTOMER_MEMBER_SHIP(
memberShipID INT default null, 
memberShipCode int unique, 
memberShipName VARCHAR(50) DEFAULT NULL, 
memberShipStartDate VARCHAR (50) DEFAULT NULL, 
memberShipEndDate VARCHAR (50) DEFAULT NULL, 
memberShipType VARCHAR (10) DEFAULT NULL,
isActive bool DEFAULT NULL,
PRIMARY KEY (memberShipCode));

CREATE TABLE ORDERS(
orderId INT, 
orderStartTime VARCHAR (50) DEFAULT NULL, 
orderEndTime VARCHAR (50) DEFAULT NULL, 
orderDileveryTime VARCHAR (50) DEFAULT NULL,
customerEntryNumber INT DEFAULT NULL, 
memberShipCode INT DEFAULT NULL, 
PRIMARY KEY (orderId));

CREATE TABLE FoodItem(
foodItemId INT, 
foodItemName VARCHAR (50) DEFAULT NULL, 
foodItemPrice INT DEFAULT NULL, 
foodItemSize VARCHAR (50) DEFAULT NULL, 
isAvailable bool DEFAULT NULL,
foodItemCategory VARCHAR(20), 
PRIMARY KEY (foodItemId));

create table AdminSecurity(
	adminId int ,
	adminUserName VARCHAR (50),
	adminPassWord VARCHAR (50),
    PRIMARY KEY (adminId)
);