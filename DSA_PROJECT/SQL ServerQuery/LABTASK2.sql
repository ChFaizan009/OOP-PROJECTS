use StudentRecords;
create table Students
(
Student_ID int primary key,
Student_Name varchar(4500),
Student_Number varchar(80) not null,
Student_DOB int ,
constraint chek check (Student_DOB>15)
);

CREATE TABLE Student_Courses(
Course_ID INT PRIMARY KEY,
Course_Title varchar(45) UNIQUE,
Course_Num int
);
























CREATE TABLE Enrolled_Courses
(
Student_ID int,
Course_ID int,
Semster varchar(300) default 'Fall20',
constraint For_key1 FOREIGN KEY (Student_Id) references Students(Student_Id),
constraint For_key2 FOREIGN KEY (Course_Id) references Student_Courses(Course_Id),
constraint Pri_keys PRIMARY KEY (Student_Id, Course_Id)
);