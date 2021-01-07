use Project;

create table Products(
Store_Id int  ,Store_Name varchar(50),
Store_PhoneNo Varchar(30),Store_Email Varchar(40),Store_Address varchar(40),Zipcode Varchar(30),
Pro_Id int ,Pro_Name varchar(50) Not null,
Pro_Price int,Pro_Quantity int,Costumer_Id int ,
Costumer_Name varchar(50),Costumer_Address Varchar(50),
Staff_Id int ,Staff_Name varchar(50),Staff_Email varchar(50),Staff_PhoneNo varchar(50),Salary int,
Order_Id int Not Null,Order_Status varchar(50),Required_Date date,Shipped_Date date);


select * from Products;

DISTINCT

SELECT DISTINCT Cost_Address FROM Products;

SELECT COUNT (DISTINCT Staff_Email)as Count FROM Products;


Where 

SELECT Cost_Name,Cost_Address FROM Products
WHERE Cost_Id=300;



Operators


SELECT Order_Status,Required_Date,Shipped_Date FROM Products
WHERE Order_Id=503 AND Order_Date='2020-04-19';

SELECT Pro_Price,Pro_Quantity FROM Products
WHERE Pro_Id=201 OR Pro_Name='Sweet';


SELECT Store_Id,Staff_Name,Store_PhoneNumber,Store_Email FROM Products
WHERE NOT Store_Address='Gujrat';


SELECT Store_Id,Staff_Email,Staff_PhoneNumber FROM Products
WHERE Store_Address='Gujrat' AND (Store_Name='CBS' OR ZipCode=3242);

SELECT Cost_Id,Cost_Name FROM Products
WHERE NOT Cost_Address='Lahore' AND NOT Staff_Id=600;


Order By


SELECT Staff_Id,Staff_Name,Staff_Email,Staff_PhoneNumber FROM Products
ORDER BY Store_Name DESC;

Insert


INSERT INTO Products(Store_Id,Store_Name,Store_PhoneNumber,Store_Email,Store_Address,ZipCode,Pro_Id,Pro_Name,Pro_Price,Pro_Quantity,Cost_Id,Cost_Name,Cost_Address,Staff_Id,Staff_Name,Staff_Email,Staff_PhoneNumber,Salary,Order_Id,Order_Date,Order_Status,Required_Date,Shipped_Date)
VALUES (105,'CBS','03023423432','CBS@gmail.com','Kotla',4323,205,'Tomato',400,12,305,'Atif','Sadwal',405,'Ahmed','ahmed@gmail.com','032556436',41500,505,'2020-08-24','Ok','2020-08-30','2020-08-28');


select * from Products


Null


SELECT Store_Name, Store_Email, Store_Address
FROM Products
WHERE Store_Address IS  NOT NULL;

SELECT Store_Name, Store_Email, Store_Address
FROM Products
WHERE Store_Address IS NULL;


Update

UPDATE Products
SET Store_Name = 'One Stop', Store_Email= 'onestop@gmail.com'
WHERE Store_Id = 104;
select * from Products


Delete 

DELETE FROM Products WHERE Store_Id=105;
select * from Products

TOP

SELECT TOP 3 * FROM Products;
SELECT TOP 50 PERCENT * FROM Products;

MIN MAX

SELECT  MAX(Salary) AS Salary
FROM Products;
SELECT  MIn(Salary) AS Salary
FROM Products;

SELECT COUNT(Cost_Id)
FROM Products;

SELECT AvG(Salary) as AverageSalary
FROM Products;

SELECT Sum(Salary) as SumSalary
FROM Products;









Like
SELECT Cost_Id,Cost_Address FROM Products
WHERE Cost_Name LIKE '%or%';

SELECT Cost_Id,Cost_Address FROM Products
WHERE Store_Name LIKE '%s';

SELECT Cost_Id,Cost_Address,Cost_Name FROM Products
WHERE Cost_Name LIKE '%mr%';

SELECT Cost_Id,Cost_Address FROM Products
WHERE Cost_Name LIKE '_l%';

SELECT Cost_Id,Cost_Address FROM Products
WHERE Cost_Name LIKE '[ali]%';

SELECT Cost_Id,Cost_Address FROM Products
WHERE Cost_Name LIKE '[a-i]%'



IN Operator

SELECT Store_Id,Store_Name,Staff_PhoneNumber,Staff_Email FROM Products
WHERE Store_Address IN ('Lahore', 'Gujrat', 'Kotla');

SELECT Store_Id,Store_Name,Staff_PhoneNumber,Staff_Email FROM Products
WHERE Store_Address not IN ('Lahore', 'Gujrat', 'Kotla');


Between

SELECT Cost_Id,Cost_Name,Cost_Address FROM Products
WHERE Salary BETWEEN 10000 AND 45000;

SELECT Cost_Id,Cost_Name,Cost_Address FROM Products
WHERE Salary NOT BETWEEN 10000 AND 45000;

















