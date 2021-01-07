use JOINS;
select * from Customers;
select * from Orders;

select * from Customers inner join Orders 
on Customers.CustomerID=Orders.CustomerId;


select * from Customers right join Orders 
on Customers.CustomerID=Orders.CustomerId;



select * from Customers left join Orders 
on Customers.CustomerID=Orders.CustomerId;


select * from Customers Full join Orders 
on Customers.CustomerID=Orders.CustomerId;