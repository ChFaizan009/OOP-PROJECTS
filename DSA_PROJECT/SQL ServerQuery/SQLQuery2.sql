create DataBase School
create table students(
 Stu_Name varchar(364),
 Stu_Rollno int,
 Stu_Class varchar(364),
 Stu_Adress varchar(364),
 Numbers int);

 INSERT INTO students values ('Faizan',1,'Fourth Year','Gujrat',98);
 INSERT INTO students values ('Sheraz',2,'Fourth Year','Gujrat',80);
 INSERT INTO students values ('Saqlain',3,'Thirld Year','Gujrat',56);
 INSERT INTO students values ('Bilal',4,'Fourth Year','Sialkot',93);
 INSERT INTO students values ('Ahmed',5,'Fourth Year','Lahore',78);
 INSERT INTO students values ('Kamran',6,'First Year','Sialkot',87);
 INSERT INTO students values ('Ali',7,'Second Year','Gujrat',56);
 INSERT INTO students values ('Noman',8,'Fourth Year','Gujrat',57);
 INSERT INTO students values ('Abdullah',9,'Fourth Year','Lala Musa',87);
 INSERT INTO students values ('Saad',10,'Firsr Year','Karachi',98);
 INSERT INTO students values ('Shabaz',11,'Thirld Year','Bagowala',46);
 INSERT INTO students values ('Saqib',12,'Fourth Year','Gujrat',88);
 INSERT INTO students values ('Khan',13,'First Year','Gojra',86);
 INSERT INTO students values ('Ali',14,'Fifth Year','Gujrat',93);
 INSERT INTO students values ('Faizan',15,'Fifth Year','Gujrawala',51);
 INSERT INTO students values ('Usama',16,'Fifth Year','Gujrat',68);
 INSERT INTO students values ('Shawaiz',17,'Fourth Year','Kotla',58);
 INSERT INTO students values ('Sabeel',18,'Fourth Year','Gujrat',86);
 INSERT INTO students values ('Fahad',19,'Fifth Year','Lahore',79);
 INSERT INTO students values ('Hassan',20,'Fourth Year','Gujrawala',90);


SELECT Distinct Stu_Adress,Stu_Name FROM students;


UPDATE students SET Stu_Class='Fifth Year' WHERE Stu_Class='Fourth Year';

SELECT *FROM students ORDER BY Stu_Adress;

Delete FROM students WHERE Stu_Rollno =18;


SELECT *FROM students where Stu_Adress='Gujrat' AND Stu_Class='Fifth Year';