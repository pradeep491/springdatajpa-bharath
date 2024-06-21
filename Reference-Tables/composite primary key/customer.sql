use mydb

CREATE TABLE customer1 (
    id int NOT NULL ,
    email varchar(255) NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id,email)
);

select * from customer1;


drop table customer;
