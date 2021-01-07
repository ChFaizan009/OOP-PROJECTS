use Lab;
create table books(
Isbn varchar(100),
title varchar(150),
author varchar(200),
constraint pk_Name PRIMARY KEY (Isbn,title)
);
