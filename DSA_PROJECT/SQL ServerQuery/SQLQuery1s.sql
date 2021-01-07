use Count;
create table author(
author_Id int Primary key,
author_Name varchar(100)
);
create table book(
Isbn varchar(100) Primary key,
title varchar(150) Not Null,
author_Id int Not Null,
);






DROP TABLE author;






select * from author;
select * from book;

UPDATE book
SET Isbn = 'CS-105', author_Id= 4
WHERE title= 'Struture';

