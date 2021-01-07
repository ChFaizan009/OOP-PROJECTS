Create Database labtask;
use labtask;
create table Customers
(

Customer_ID int,
Customer_Name varchar(20),
Customer_Age int,
Customer_Date Date
);

insert into Customers (Customer_ID, Customer_Name, Customer_Age, Customer_Date) values (1, 'Faizan', 18, '1-Nov-2000');
insert into Customers (Customer_ID, Customer_Name, Customer_Age, Customer_Date) values (2, 'Kamran', 36, '15-Nov-1985');
insert into Customers (Customer_ID, Customer_Name, Customer_Age, Customer_Date) values (3, 'Ali Hamza', 28, '18-Oct-2000');
insert into Customers (Customer_ID, Customer_Name, Customer_Age, Customer_Date) values (4, 'Hammad', 20, '27-Nov-1997');
insert into Customers (Customer_ID, Customer_Name, Customer_Age, Customer_Date) values (5, 'Fahad', 19, '19-Nov-1968');

select * from Customers;


/*Conversion*/
Select Customer_ID, Customer_Name, Customer_Age, 
CONVERT (varchar,Customer_Date) as Date
From Customers;


SELECT GETDATE();


/*Add one year to a date*/
SELECT DATEADD(YEAR,1,'2018/07/025') as dateAdd;

/*Return differnece betwwen two dates*/
select DATEDIFF(YEAR,1,'2018/07/025') as dateDiff;

/*Return Specific part of dates*/
select DATENAME(YEAR,'2018/07/025') as DateString;





SELECT POWER(5,2);







/*Round Function*/


SELECT ROUND(112.50,4)AS RoundValues;




/*Sign Function*/

SELECT SIGN(240.69);



/*Return Square root*/
SELECT SQRT(81);


/*Return ASCII Value*/


SELECT ASCII(Customer_Name)as Numofcodeofchar
from Customers;


/*User  Name*/
select User_Name()as User_Name;


/*SUSER Name*/
select SUSER_Name()as Name;



SELECT CHARINDEX('m','mehran');


select DATEPART(YEAR, '2018/07/025')AS DatePartInt;

select CONVERT (int, Cust_Salary) from Customer_Salary;

drop table Customer_Salary;

select getdate ();

select DATEADD (year, 2, getdate());

select DATENAME (year, getdate());

select DATEPART (month, getdate());

select DATEDIFF (year, getdate(), '2020/11/24');

select POWER (4, 7);

select ROUND (3421.40, -4);

select SIGN (-13);

select SQRT (46);

select FLOOR (-4.5);

select CEILING (-7.7);

select ABS (-10.8);

select UPPER (Cust_Name) as 'Upper Case' from Customer_Salary;

select LOWER (Cust_Name) as 'Lower Case' from Customer_Salary;

select REVERSE (Cust_Name) as 'Reverse Name' from Customer_Salary;

select REPLICATE ('Faiq ', 3);

select RIGHT ('Faiq', 3);

select LEN ('Faiq');

select ASCII ('N');

select CHARINDEX ('m', 'Faiq');

select SUBSTRING ('Bilal', 4, 7);

select CHAR (84);

select STUFF ('Tony Shark', 4, 2, 'y_Iron_');

select DB_ID ('company');

select DB_NAME (8);

select HOST_ID ();

select HOST_NAME ();

select ISNULL (NULL, 54);


Create table EmployeeTable

(

EmpID int,

EmpName varchar(30),

EmpSalary int,

EmployeeFile Text

)

Go

insert into employeeTable values('1','Smith','200000','Mrs. Smith has worked in Infosys since 22/7/2010')

Go

Select * from employeeTable


/*Read Text*/
Declare @pointer varbinary(30)

Select @pointer =TEXTPTR (EmployeeFile)from employeeTable
Where EmpID=1

ReadText employeeTable.EmployeeFile @pointer 1 20


/*Write Text*/
Declare @pointer varbinary(30)

Select @pointer =TEXTPTR (EmployeeFile)from employeeTable

Where EmpID=1

Writetext employeeTable.EmployeeFile @pointer 'Rohatash'

Go

Select * from EmployeeTable