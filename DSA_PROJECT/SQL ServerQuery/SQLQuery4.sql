use School;
select * from students;
select Top 70 percent * from students where Stu_Adress='Gujrat';
select COUNT(Stu_Adress) AS STUDENT_NUMBERS from students;
update students 
Set Stu_Name='Shabaz',Stu_Adress='Bagowal'
Where Stu_Rollno=11;

Select * from students
where stu_Name LIKE '%[b-s-p]';
where Stu_Name not LIKE '_a_%';

use Count;
SELECT  Count(*) FROM Information where ID = 1;
select	Sum(Number) from Information;
