Create Database Management;
Use Management;
--Table before Normalization(Un Normalized Table)

Create Table Products(Store_Id int, Store_Name varchar(50),
Store_PhoneNo Varchar(30),Store_Email Varchar(40),Store_Address varchar(40),Zipcode Varchar(30),
 Pro_Name varchar(50) Not null,
Pro_Price int,Pro_Quantity int,
Costumer_Name varchar(50),Costumer_Address Varchar(50),
Staff_Name varchar(50),Staff_Email varchar(50),Staff_PhoneNo varchar(50),
Salary int,Order_Status varchar(50),Required_Date date,Shipped_Date date);
Select * from Products;

--Input Values in the table
Insert into Products Values(101,'Awami Store','66478321','awamistore@gmail.com','27 Sabour',1452611,
'Loreal',500,20,'Ali','Gujrat','Zaheer','Zaheer12@gmail.com','53749232',22000,'Accepted',
'22 January 2020','24 January2020');
Insert into Products Values(102,'M Store','6647423232','Mstore@gmail.com','7 Gujrat',1254611
,'Fair lovely',890,23,'Zahid','Kharian','Abbas','Abbas23@gmail.com','7283212',35000,'Accepted',
'20 January 2020','22 January2020');
Insert into Products Values(103,'One Stop','62738212,6372393','onestop@gmail.com','Khariaan',28392,
'Olivia',990,89,'Asad','Khariaan','Abbas','Abbas23@gmail.com','7283212',30000,'Accepted',
'22 January 2020','23 January2020');
Insert into Products Values(104,'One Stop','7382212,3272393','onestop@gmail.com','Gujrat',1254611,
'Loreal',340,32,'Ali','Gujrat','Azhar','azhar232@gmail.com','213424,2452',33000,'Accepted',
'08 March 2020','10 March 2020');
Insert into Products Values(105,'One Stop','7382212,3272393','onestop@gmail.com','Gujrat',1254611,
'Garnier',340,32,'Ali','Gujrat','Azhar','azhar232@gmail.com','213424,2452',33000,'Accepted',
'08 March 2020','10 March 2020');
-- Types of Anomlaies
--Insertion Anomaly
Insert into Products Values('Al-Hassan','9203424,384832','hassan092@gmail.com','Gujrat','1254611');
--Update Anomaly
Select * from Products;
Update Products set Salary=25000 where Staff_Name='Abbass';
--Delete Anomaly
Delete from Products where Store_Id=105;
Select * from Products;

--Applying Normalization
--Apply 1st Normal Form
Create Table NProduct1(Store_Name varchar(50),
Store_PhoneNo Varchar(30),Store_Email Varchar(40),Store_Address varchar(40),Zipcode Varchar(30),
Pro_Name varchar(50) Not null,
Pro_Price int,Pro_Quantity int,
Costumer_Name varchar(50),Costumer_Address Varchar(50),
Staff_Name varchar(50),Staff_Email varchar(50),Staff_PhoneNo varchar(50),Salary int,
Order_Status varchar(50),Required_Date date,Shipped_Date date);
--Inserting Values in 1st normal form table

Insert into NProduct1 Values('Awami Store','66478321','awamistore@gmail.com','27 Sabour',1452611,
'Loreal',500,20,'Ali','Gujrat','Zaheer','Zaheer12@gmail.com','53749232',22000,'Accepted',
'22 January 2020','24 January2020');
Insert into NProduct1 Values('M Store','6647423232','Mstore@gmail.com','7 Gujrat',1254611,
'Fair lovely',890,23,'Zahid','Kharian','Abbas','Abbas23@gmail.com','7283212',35000,'Accepted',
'20 January 2020','22 January2020');
Insert into NProduct1 Values('One Stop','62738212','onestop@gmail.com','Khariaan',28392,
'Olivia',990,89,'Asad','Khariaan','Abbas','Abbas23@gmail.com','7283212',30000,'Accepted',
'22 January 2020','23 January2020');
Insert into NProduct1 Values('One Stop','6372393','onestop@gmail.com','Khariaan',28392,
'Olivia',990,89,'Asad','Khariaan','Abbas','Abbas23@gmail.com','7283212',30000,'Accepted',
'22 January 2020','23 January2020');
Insert into NProduct1 Values('One Stop','7382212','onestop@gmail.com','Gujrat',1254611,
'Loreal',340,32,'Ali','Gujrat','Azhar','azhar232@gmail.com','213424',33000,'Accepted',
'08 March 2020','10 March 2020');
Insert into NProduct1 Values('One Stop','3272393','onestop@gmail.com','Gujrat',1254611,
'Loreal',340,32,'Ali','Gujrat','Azhar','azhar232@gmail.com','2452',33000,'Accepted',
'08 March 2020','10 March 2020');
Insert into Products Values('One Stop','7382212','onestop@gmail.com','Gujrat',1254611,
'Garnier',340,32,'Ali','Gujrat','Azhar','azhar232@gmail.com','213424',33000,'Accepted',
'08 March 2020','10 March 2020');
Insert into Products Values('One Stop','3272393','onestop@gmail.com','Gujrat',1254611,
'Garnier',340,32,'Ali','Gujrat','Azhar','azhar232@gmail.com','2452',33000,'Accepted',
'08 March 2020','10 March 2020');

Select * from NProduct1;

--Applying 2nd Normal Form 
--Table of store data
Create Table Store(Store_Id int Primary key ,Store_Name Varchar(30),Store_Email Varchar(30)
,Store_Address Varchar(30),Zipcode varchar(30));

Insert into Store values(101,'Awami Store','awamistore@gmail.com','27 Sabour','1452611');
Insert into Store values(102,'M Store','Mstore@gmail.com','7 Gujrat','1254611');
Insert into Store values(103,'One Stop','onestop@gmail.com','Khariaan','28392');
Insert into Store values(104,'One Stop','onestop@gmail.com','Gujrat',1254611);

select * from Store; --Dropped)
--Now Creating table to store phone numbers
Create Table StorePhNum(Store_Id int,Store_PhoneNo Varchar(30),Foreign Key(Store_Id) References Store_D(Store_Id));
Insert into StorePhNum Values(101,'66478321');
Insert into StorePhNum Values(102,'6647423232');
Insert into StorePhNum Values(103,'62738212');
Insert into StorePhNum Values(103,'6372393');
Insert into StorePhNum Values(104,'7382212');
Insert into StorePhNum Values(104,'3272393');
select * from StorePhNum;

--Table of Product data
Create Table Product_Data(Prod_Id int Primary key,Pro_Name varchar(40),Pro_Price int,Store_Id int,
foreign key(Store_Id) references Store_D(Store_Id));
Insert into Product_Data values(201,'Loreal',500,103);
Insert into Product_Data values(202,'Fair Lovely',890,104);
Insert into Product_Data values(203,'Olivia',990,101);
Insert into Product_Data values(204,'Garnier',700,102);
Insert into Product_Data values(205,'Lakme',1199,104);
Select * from Product_Data;

--Table for Quantity
Create Table Product_Qty(Prod_Id int, Prod_Quant int,Foreign key (Prod_Id) references Product_Data(Prod_Id));
Insert Into Product_Qty Values(201,20);
Insert Into Product_Qty Values(202,23);
Insert Into Product_Qty Values(203,89);
Insert Into Product_Qty Values(204,22);
Insert Into Product_Qty Values(205,25);
Select * from Product_Qty;


--Table for Costumer
Create Table Costumer_Data(Costumer_Id int Primary Key,Costumer_Name Varchar(40),Order_Id int,
foreign key(Order_Id) references Orders(Order_Id));
Insert into Costumer_Data Values(301,'Ali',1);
Insert into Costumer_Data Values(302,'Zahid',1);
Insert into Costumer_Data Values(303,'Asad',4);
Insert into Costumer_Data Values(304,'Aliyan',3);
Insert into Costumer_Data Values(305,'Nazish',2);
select * from Costumer_Data;

--Table to store Costumer Addresses
Create Table Costumer_Addr(Costumer_Id int,Costumer_Address Varchar(40),
Foreign Key(Costumer_Id) references Costumer_Data(Costumer_Id));
Insert into Costumer_Addr Values(301,'Gujrat');
Insert into Costumer_Addr Values(301,'Khariaan');
Insert into Costumer_Addr Values(302,'Khariaan');
Insert into Costumer_Addr Values(302,'Lalamusa');
Insert into Costumer_Addr Values(303,'Khariaan');
Insert into Costumer_Addr Values(304,'Sabour');
Insert into Costumer_Addr Values(305,'Islamabad');
select  * from Costumer_Addr;


--Table to Store Staff Record
Create Table Staff(Staff_Id int Primary key,Costumer_Id int,Staff_Name varchar(40),
Staff_Email varchar(40),Salary int,foreign key (Costumer_Id) references  Costumer_Data(Costumer_Id));
Insert into Staff values(401,301,'Zaheer','zaheer12@gmail.com',22000);
Insert into Staff values(402,302,'Abbas','Abbas23@gmail.com',35000);
Insert into Staff values(403,301,'Azhar','azhar232@gmail.com',33000);
Insert into Staff values(404,304,'Faizan','fazian33@gmail.com',29000);
Insert into Staff values(405,303,'Afifa','afifa89@gmail.com',35000);
Insert into Staff values(406,304,'fakhar','fakhar76@gmail.com',35000);
select * from Staff;

--Table to store staff phone_no
Create Table Staff_phNo(Staff_Id int,Staff_PhoneNo varchar(30),Foreign key(Staff_Id) references Staff(Staff_Id));
Insert into Staff_phNo values(401,'53749232');
Insert into Staff_phNo values(402,'7283212');
Insert into Staff_phNo values(402,'2134242');
Insert into Staff_phNo values(403,'2452342');
Insert into Staff_phNo values(404,'9837421');

Select  * from Staff_phNo;
--Table to store order data
Create Table Orders(Order_Id int Primary key,Order_Status varchar(40));
Insert into Orders Values(1,'Accepted');
Insert into Orders Values(2,'Rejected');
Insert into Orders Values(3,'Peniding');
Insert into Orders Values(4,'Delivered');
Select * from Orders;
--Table To store Order Date
Create table Order_Date(Order_Id int,Required_Date Date,Shipped_Date Date,
foreign Key(Order_Id) references Orders(Order_Id));
Insert into Order_date Values(1,'23 Jan 2020','25 Jan 2020');
Insert into Order_date Values(2,'2 Feb 2020','5 Feb 2020');
Insert into Order_date Values(1,'6 Feb 2020','9 Feb 2020');
Insert into Order_date Values(4,'8 Jan 2020','13 Jan 2020');
Insert into Order_date Values(4,'2 March 2020','5 March 2020');
Insert into Order_date Values(3,'31 Dec 2020','2 Jan 2021');
Insert into Order_date Values(7,'31 Dec 2020','2 Jan 2021');
Select * from Order_Date;

--2nd Normal Form Completed

--Now 3rd Normal Form on table of store
Create table Store_D(Store_Id int Primary key,Staff_Id int, Store_Name varchar(30),Store_Email varchar(30),
Store_address_Id int,foreign key(Store_address_Id) references StoreAdrs(Address_Id),
foreign key(Staff_Id) references Staff(Staff_Id));
insert into Store_D values(101,401,'Awami','awamistore@gmail.com',703);
insert into Store_D values(102,403,'M Store','Mstore@gmail.com',701);
insert into Store_D values(103,402,'One Stop','onestop@gmail.com',702);
insert into Store_D values(104,401,'One Stop','onestop@gmail.com',701);
insert into Store_D values(105,404,'U-MART','umart@gmail.com',702);
select * from Store_D;

Create table StoreAdrs(Address_Id int Primary key,Store_Address Varchar(30),ZipCode varchar(30));
Insert into StoreAdrs values(701,'Gujrat', '1254611');
Insert into StoreAdrs values(702,'Khariaan',  '28392');
Insert into StoreAdrs values(703,'27 Sabour', '1254611');
Insert into StoreAdrs values(704,'Lalamusa', '374832');
Insert into StoreAdrs values(705,'Sheikhpur', '8239832');
Insert into StoreAdrs values(706,'Sialkot',null);

select * from StoreAdrs;
--Table Of Store Orders
Create Table Store_Order(Store_OrderId int Primary key,
Store_Id int,Staff_Id int,Costumer_Id int,Product_Id int,Order_Id int,
foreign key(Store_Id) references Store_D(Store_Id),
foreign key(Staff_Id) references Staff(Staff_Id),
foreign key(Costumer_Id) references Costumer_Data(Costumer_Id),
foreign key(Product_Id) references Product_Data(Prod_Id),
foreign key(Order_Id) references Orders(Order_Id));
Insert into Store_Order Values(601,101,401,301,201,1);
Insert into Store_Order Values(602,102,402,303,202,3);
Insert into Store_Order Values(603,103,403,302,203,4);
Select * from Store_Order;

--Normalization Done

						--Queries
						--Select Queruies

--SQL SELECT Statement
Select * from Costumer_Data;
Select * from Store_D;
Select Store_Name,Store_Email from Store_D;
Select * from Staff;


--SQL SELECT DISTINCT Statement
Select Distinct Store_Address from StoreAdrs;
Select Distinct Costumer_Address from Costumer_Addr;
Select COUNT(Distinct Costumer_Address) from Costumer_Addr;
		
		
		--SQL WHERE Clause
Select * from  Costumer_Addr where Costumer_Address='Gujrat';

--Greate than
Select * from Staff where Salary>29000;
--Less than
Select * from Staff where Salary<35000;
--Equal To
Select * from Staff where Salary=29000;
Select * from Staff where Salary=35000;
--Between
Select  Staff_Name from Staff where Salary between 29000 AND 38000;
--LIKE
Select * from Staff where Staff_Name like 'A%';
--IN
Select * from Costumer_Addr where Costumer_Address IN('Gujrat','Khariaan');
Select * from Staff where Salary IN(22000,35000);

		--SQL AND, OR and NOT Operators
--AND 
Select * from Staff where Staff_Id=403 AND Costumer_Id=301;
--OR
Select * from Staff where Staff_Id=403 OR Costumer_Id=302;
--NOT
Select * from Staff where Not Staff_Id=403;

		--SQL ORDER BY Keyword
--ASCENDING
Select Staff_Name,Staff_Email,Salary from Staff ORDER BY Salary ASC; 
--ORDER BY Alphabets
Select * from Staff ORDER By Staff_Name;
--DESCENDING
Select * from Staff ORDER BY Salary DESC;
--ORDER BY Several Column
Select * from Staff ORDER BY Costumer_Id ,Staff_Name;
--ORDER BY Several Column With Ascending and Descending
Select * from Staff ORDER BY Costumer_Id ASC ,Staff_Name DESC;

		--SQL INSERT INTO Statement
--First Way
Insert into Store_D(Store_Id,Staff_Id,Store_Name,Store_Email,Store_address_Id)
Values(106,403,'AL-Karam','alkaramstore@gamil.com',701);
--Second Way
Insert into Store_D values(107,402,'Kayseria','kayseriastore@gmail.com',705);
--Check that all values are inserted
select * from Store_D;

		--SQL NULL Values
--IS Null
Select Store_Address from StoreAdrs Where ZipCode is null;
--IS Not Null
Select Store_Address ,ZipCode from StoreAdrs Where ZipCode is not null;
 
		--SQL UPDATE Statement
Update Staff set Staff_Name='Mubaram' where Staff_Id=403;
Select * from Staff;

		--SQL DELETE Statement
Delete from Costumer_Addr where Costumer_Id=302 and Costumer_Address='Khariaan';
Select * from Costumer_Addr
		
		--SQL TOP Clause
--SQL SELECT TOP Clause
Select Top 2 * from Staff;
Select Top 2 * from Staff where Salary>25000;
SELECT TOP 50 PERCENT * FROM Staff;

		--SQL MIN() and MAX() Functions
--Min() Function
Select MIN(Pro_Price) AS Lowest_Price from Product_Data;
Select * from Product_Data;
--MAX() Function
Select MAX(Pro_Price) AS  Maximum_Price from Product_Data;

		--SQL COUNT(), AVG() and SUM() Functions
--Count() Function
Select Count(Prod_Id)AS Total_Records from Product_Data ;
--AVG() Function
Select AVG(Salary) AS Average_Salary from Staff;
--Sum() Function
Select Sum(Prod_Quant) As Total_Quantity from Product_Qty;
Select * from Product_Qty;

		--SQL LIKE Operator
Select * from Store_D where Store_Name like 'A%';
Select * from Costumer_Data where Costumer_Name like '%i%';
Select * from Costumer_Data where Costumer_Name like '_a%';

		--SQL WildCard Operator
SELECT * FROM Costumer_Addr
WHERE Costumer_Address LIKE 'kha%';

		--SQL In Operator
SELECT * FROM StoreAdrs
WHERE Store_Address IN (SELECT Costumer_Address FROM Costumer_Addr);

		--SQL BETWEEN Operator
Select  Staff_Name,Salary from Staff where Salary between 29000 AND 38000;
Select * from Product_Data where Pro_Price between 700 AND 1000;

		--SQL NOT BETWEEN 
Select * from Product_Data where Pro_Price Not between 700 AND 1000;

		--BETWEEN with IN Example
Select * from Product_Data where Pro_Price  between 700 AND 1000 AND Store_Id Not in(103,104);

		--SQL Aliases
Select Costumer_Id As ID,Costumer_Name As Costumer from Costumer_Data;

Select Staff_Id,Staff_Name+' , '+Staff_Email As Staff_Detail from Staff;

Select * from Staff;
Select * from Costumer_Data;
Select * from Orders;
Select Orders.Order_Id,Orders.Order_Status,Costumer_Data.Costumer_Name from Costumer_Data,Orders 
where Costumer_Data.Costumer_Name='Asad' And Costumer_Data.Order_Id=Orders.Order_Id;

		--SQL Joins
-- Join Keyword
Select * from
Orders  Join Costumer_Data On Orders.Order_Id=Costumer_Data.Order_Id;

Select Orders.Order_Id,Costumer_Data.Costumer_Name,Orders.Order_Status from
Orders Join Costumer_Data On Orders.Order_Id=Costumer_Data.Order_Id;

--Inner Join Keyword
Select Orders.Order_Id,Costumer_Data.Costumer_Name,Orders.Order_Status from
Orders Inner Join Costumer_Data On Orders.Order_Id=Costumer_Data.Order_Id;

Select * from
Orders Inner Join Costumer_Data On Orders.Order_Id=Costumer_Data.Order_Id;

--Left Join Keyword
Select *  from Costumer_Data Left Join Orders On Costumer_Data.Costumer_Id=Orders.Order_Id;

Select *  from Costumer_Data Left Join Staff On Costumer_Data.Costumer_Id=Staff.Costumer_Id;

--SQL RIGHT JOIN Keyword
Select *  from Staff Right Join Costumer_Data On Staff.Costumer_Id=Costumer_Data.Costumer_Id 
ORDER BY Staff_Name;

--Full Outer Join
Select *  from Costumer_Data Full Outer Join Staff On Costumer_Data.Costumer_Id=Staff.Costumer_Id
Order By Costumer_Data.Costumer_Name ;

--SQL UNION Operator
Select Staff_Name from Staff
UNION 
Select Costumer_Name from Costumer_Data 
--SQL UNION Operator with Where Clause
Select Staff_Name from Staff
UNION 
Select Costumer_Name from Costumer_Data where Costumer_Id>302;

		--SQL GROUP BY Statement
Select COUNT(Costumer_Id) AS Repetition,Costumer_Address from Costumer_Addr Group By Costumer_Address;

--Group With Count and Order
Select COUNT(Costumer_Id) AS Repetition,Costumer_Address from Costumer_Addr Group By Costumer_Address 
ORDER BY COUNT(Costumer_Id) DESC;

		--SQL Having Statement
Select Count(Costumer_Id) AS Repetition,Costumer_Address from Costumer_Addr Group By Costumer_Address
Having Count(Costumer_Id)>1;

		--SQL EXISTS Operator
Select Staff_Name from Staff
where Exists (Select Costumer_Name from Costumer_Data where Costumer_Data.Costumer_Id=Staff.Costumer_Id 
AND Costumer_Id>301);

Select * from Costumer_Data;
Select * from Staff;


		--SQL ANY and ALL Operators
--Any
Select * from Staff where Costumer_Id=Any(Select Costumer_Id from Costumer_Data where Costumer_Id>302);

Select Staff_Name from Staff where Costumer_Id=Any(Select Costumer_Id from Costumer_Data where Costumer_Id>302);
--All
Select Staff_Name from Staff where Costumer_Id=All(Select Costumer_Id from Costumer_Data where Costumer_Id=302);

Select * from Staff where Costumer_Id=All(Select Costumer_Id from Costumer_Data where Costumer_Id=302);
Select * from Store_D;
Select * from StoreAdrs
		--SQL CASE Statement
Select Store_Name,Store_Email,
Case 
when Store_address_id =701 Then  ' The Store Is in Gujrat'
when Store_address_id =702 Then  ' The Store Is in Khariaan'
when Store_address_id =703 Then  ' The Store Is in Sabour'
when Store_address_id =704 Then  ' The Store Is in Lalamusa'
when Store_address_id =705 Then   ' The Store Is in Sheikhpur'
when Store_address_id =706 Then   ' The Store Is in Sialkot'
else 'No Address is registered' 
End AS Store_Detail
From Store_D;

--case 2
SELECT Pro_Name,Pro_Price
FROM Product_Data
ORDER BY
(CASE
    WHEN Prod_Id IS NULL THEN Pro_Name
    ELSE Pro_Price
END);

		--SQL Stored Procedures
--Creation of Procedure
Create Procedure SelectAllProd
AS
Select * from Product_Data;
--Execute a Stored Procedure
Exec SelectAllProd;

--Stored Procedure With One Parameter
Create Procedure  SelectStore @ID int
AS
Select * from Store_D where Store_address_Id=@ID;
--Execute Procedure
Exec SelectStore @ID=701;

select * from Staff;

--Stored Procedure With Multiple Parameters
Create Proc SelectStaff @Salary int,@Cost_Id int
AS
Select * from Staff where Salary>@Salary And Costumer_Id=@Cost_Id;
--Execute Procedure
Exec SelectStaff @Salary=20000 ,@Cost_Id=301;

		--Views
Create View [Staff Salary] 
AS
Select Staff_Name,Staff_Email,Salary from Staff where Salary>30000;
 
select * from [Staff Salary];






Select * from Products;
Begin Transaction
update Product_Qty
Set Store_Address='Sabour'
where Address_Id=101;

rollback;



Select * from students;
Begin Transaction
update students
Set Stu_Class=10
where Stu_RollNo=101;

commit;