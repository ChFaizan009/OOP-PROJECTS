create TABLE Customers(
CustomerId int,
CustomerName varchar(200),
ContactName varchar(200),
City varchar(255),
PostalCode varchar(255)
);


/* to watch Table*/
SELECT * FROM Customers
WHERE CustomerId=1;

/* to Insert Data */
INSERT INTO Customers values(1,'Faizan','03018761778','Gujrat','4012');
INSERT INTO Customers values(2,'Bilal','0300625585','Sialkot','7802');
INSERT INTO Customers values(3,'Kamran','030025575','Lahore','7892');

/*Display Data*/
SELECT *FROM Customers;

/*Select DISTRINCIT*/
SELECT COUNT(Distinct City) FROM Customers;
SELECT Distinct City FROM Customers;

/*Delete*/
Delete from Customers where CustomerId=2;
Delete from Customers;