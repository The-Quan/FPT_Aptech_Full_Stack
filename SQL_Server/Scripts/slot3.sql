create table students(
id int primary key ,
name varchar (250) not null,
address varchar (250)
);
insert into students (id, name, address) 
value (1, 'Nguyen hai ngoc', 'Vinh Phu'),
      (2, 'Vy', 'Ha Noi'),
      (25, 'Duong', 'Long Bien')
      
select * from students ;

CREATE TABLE account(
id int PRIMARY KEY,
username varchar(30),
password varchar(30)
);
INSERT INTO account VALUES (1,'admin','admin123')

select * from account where username='admin' and password= 'admin123';

create table subjects(
id int auto_increment primary key,
name varchar(255) not null
);
insert into subjects (name) values 
('Mathematics'), ('Physics'), ('Chemistry'), ('Biology'), ('History')

select * from subjects;

create table marks(
id int auto_increment primary key,
student_id int,
subject_id int,
mark Float,
foreign key (student_id) REFERENCES students(id),
foreign key (subject_id) REFERENCES subjects(id)
);
insert into marks(student_id, subject_id, mark)
values 
(1, 1, 9.5),
(2, 3, 8.5),
(25, 3, 10)

select * from marks;


