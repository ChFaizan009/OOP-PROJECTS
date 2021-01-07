use StudentsData;
select * from Stu;


Create Procedure Pro
as
begin
select * from Stu;
end

execute Pro


/*Alter */
ALTER PROCEDURE Pro
as 
begin
Select Student_Name, Student_RollNo  from Stu where Student_RollNo=102
end
execute Pro

/* drop*/
drop PROCEDURE Pro

/* Parameter*/
Create Procedure Pros
@Student_Name varchar(50),
@Student_RollNo int
as
begin
select * from Stu where Student_Name=@Student_Name and Student_RollNo=@Student_RollNo
end

execute Pros 'Faizan',100
