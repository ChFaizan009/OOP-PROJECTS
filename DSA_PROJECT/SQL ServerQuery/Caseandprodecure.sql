use labtask;

SELECT OrderID, Quantity,
CASE
    WHEN Quantity > 30 THEN 'The quantity is greater than 30'
    WHEN Quantity = 30 THEN 'The quantity is 30'
    ELSE 'The quantity is under 30'
END AS QuantityText
FROM OrderDetails;

use labtask;

SELECT CustomerName, City, Country
FROM Customer
ORDER BY
(CASE
    WHEN City IS NULL THEN Country
    ELSE City
END);



drop SelectAllCustomers;

use JOINS;

CREATE PROCEDURE SelectAllCustomer
AS
SELECT * FROM Customers
GO;

EXEC Cos;





ALTER PROCEDURE [dbo].[SelectAllCostomers] @City varchar(50), @PostalCode varchar(50)
AS
SELECT * FROM Customers WHERE City = @City AND PostalCode = @PostalCode


EXEC SelectAllCostomers;















with one parameter

CREATE PROCEDURE SelectAllCustomer @City varchar(50)
AS
SELECT * FROM Customers WHERE City = @City
;GO;





EXEC SelectAllCustomer @City = 'Lahore';


	Create optional parameters



CREATE PROCEDURE uspFindProducts(
    @min_list_price AS DECIMAL = 0
    ,@max_list_price AS DECIMAL = 999999
    ,@name AS VARCHAR(max)
)
AS
BEGIN
    SELECT
        product_name,
        list_price
    FROM 
        production.products
    WHERE
        list_price >= @min_list_price AND
        list_price <= @max_list_price AND
        product_name LIKE '%' + @name + '%'
    ORDER BY
        list_price;
END;




with multiple parameter






CREATE PROCEDURE SelectAllCostomers @City varchar(50), @PostalCode int
AS
SELECT * FROM Customers WHERE City = @City AND PostalCode = @PostalCode
;



EXEC SelectAllCostomers @City = 'Gujrat', @PostalCode = 14589;




EXECUTE SelectAllCostomers 
    @PostalCode = 900, 
    @PostalCode = 1000;









	
Delcare variable
DECLARE @City varchar(50);

SET @City = 'Lahore';
 
SELECT CustomerName, City, Country
FROM Customer
WHERE 
    City = @City
order by(CASE
    WHEN City IS NULL THEN Country
    ELSE City
END);

1)	Store query result in a variable

DECLARE @Customer_count INT;

SET @Customer_count = (
    SELECT 
        COUNT(*) 
    FROM 
        Customer 
);

DECLARE @count INT;

EXEC [uspFindProductByModel]
    @model_year = 2018,
    @product_count = @count OUTPUT;

SELECT @count AS 'Number of products found';



15)	Create output parameters

CREATE PROCEDURE [uspFindProductByModel] (
    @model_year SMALLINT,
    @product_count INT OUTPUT
) AS
BEGIN
    SELECT 
        product_name,
        list_price
    FROM
        production.products
    WHERE
        model_year = @model_year;

    SELECT @product_count = @@ROWCOUNT;
END;