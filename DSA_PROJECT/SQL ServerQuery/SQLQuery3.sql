use Lab;

create table author(
author_Id int Primary key,
author_Name varchar(100)
);
create table book(
Isbn varchar(100) Primary key,
title varchar(150) Not Null,
author_Id int Not Null,

Constraint ck check (author_Id>0 AND Isbn='NULL')
/* Constraint fk FOREIGN KEY(author_Id) References author(author_Id)*/
);
Drop table book;
Drop table author;