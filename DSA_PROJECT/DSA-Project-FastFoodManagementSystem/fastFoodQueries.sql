use fastFood;

#insert queries for employee
INSERT INTO employee VALUES (12231,'Muhammad Saqib',20,03321234321,12,'Single','Jail Chowk,Gujrat',23000,1);
INSERT INTO employee VALUES (12232,'Usman',30,03321234322,10,'Single','Shadman,Gujrat',18000,0);
INSERT INTO employee VALUES (12233,'Ali',25,03321234323,8,'Single','Prince chowk,Gujrat',20000,1);
INSERT INTO employee VALUES (12234,'Sidra',19,03321234324,6,'Single','Jail Chowk,Gujrat',23500,0);
SELECT * FROM fastfood.employee;

#insert queries for customer_member_ship
INSERT INTO customer_member_ship VALUES (1001,1321,'Muhammad Saqib', '2020-12-23', '2021-01-03' ,'GOLD',1);
INSERT INTO customer_member_ship VALUES (1002,1322,'Zunair Ahmed', '2020-12-23', '2021-01-03' ,'GOLD',1);
INSERT INTO customer_member_ship VALUES (1003,1323,'Arooj Saghar', '2020-12-23', '2021-01-03' ,'GOLD',0);
INSERT INTO customer_member_ship VALUES (1004,1324,'Usman', '2020-12-23', '2021-01-03'  ,'SILVER',1);
SELECT * FROM fastfood.customer_member_ship;

#insert queries for fooditem
INSERT INTO fooditem VALUES (1,'Chicken Burger', 120, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (2,'Patty Burger', 150, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (3,'Zinger Burger', 180, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (4,'Beef Burger', 320, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (5,'Cheese Sticks', 120, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (6,'Cheese Rolls', 220, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (7,'BBQ Pizza', 820, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (8,'Chicken Fajita Pizza', 920, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (9,'Spicy Pizza', 1000, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (10,'Cheesy Pizza', 1200, 'REGULAR', 1 , 'FastFood');
INSERT INTO fooditem VALUES (11,'Ice Shake', 150, 'REGULAR', 1 , 'FastFood');
select * from fooditem;

#insert queries for customer
INSERT INTO customer VALUES (1311,'Muhammad Saqib', 1500, '1,4,7', '13:46:37 23-12-2020', 'Chicken Burger,Zinger Burger,Cheesy Pizza', 0,1322);
INSERT INTO customer VALUES (1312,'Muhammad Abdullah', 1200, '11,4,7', '13:46:37 23-12-2020', 'Chicken Burger,Zinger Burger,Cheesy Pizza', 0,1321);
INSERT INTO customer VALUES (1313,'Zunair Ahmed', 1300, '1,3,7', '13:46:37 23-12-2020', 'Chicken Burger,Zinger Burger,Cheesy Pizza', 0,1323);
INSERT INTO customer VALUES (1314,'Ayesha', 1000, '1,4,5', '13:46:37 23-12-2020', 'Chicken Burger,Zinger Burger,Cheesy Pizza', 0,1321);
INSERT INTO customer VALUES (1315,'Usama Raheem', 5500, '2,3,7', '13:46:37 23-12-2020', 'Chicken Burger,Zinger Burger,Cheesy Pizza', 0,1322);
INSERT INTO customer VALUES (1316,'Usama Saeed', 150, '7', '13:46:37 23-12-2020', 'Chicken Burger,Zinger Burger,Cheesy Pizza', 0,1321);
INSERT INTO customer VALUES (1317,'Usama Mustafa', 150, '7', '13:46:37 23-12-2020', 'Ice Shake', 0,0);
SELECT * FROM fastfood.customer;

#insert queries for ORDERS
INSERT INTO orders VALUES (1125,'23:13:07 28-12-2020' ,'14:17:18 23-12-2020' , '14:02:18 23-12-2020', 1316,1331);
INSERT INTO orders VALUES (1126,'23:13:07 28-12-2020' ,'14:17:18 23-12-2020', '14:02:18 23-12-2020', 1317,1332);
SELECT * FROM fastfood.orders;

#insert queries for AdminSecurity
INSERT INTO adminsecurity VALUES (1540,"admin","admin");
INSERT INTO adminsecurity VALUES (1541,"SaQib1","sAqIb");

