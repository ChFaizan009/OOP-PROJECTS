use Student;

Select * from students;
Begin Transaction
update students
Set Stu_Class=11
where Stu_RollNo=101;

rollback;



Select * from students;
Begin Transaction
update students
Set Stu_Class=10
where Stu_RollNo=101;

commit;