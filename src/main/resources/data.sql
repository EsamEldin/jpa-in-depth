insert into course (id, name,created_date,last_updated_date) values (10001,'jpa',sysdate(),sysdate());
insert into course (id, name,created_date,last_updated_date) values (10002,'hibernate',sysdate(),sysdate());
insert into course (id, name,created_date,last_updated_date) values (10003,'boot',sysdate(),sysdate());

insert into passport(id,number) values(4001,'E123456');
insert into passport(id,number) values(4002,'N123456');
insert into passport(id,number) values(4003,'F123456');

insert into Student(id,name,passport_id) values(2001,'Essam',4001);
insert into Student(id,name,passport_id) values(2002,'Ahmed',4002);
insert into Student(id,name,passport_id) values(2003,'gad',4003);



insert into Review(id,rating,description,course_id) values(6001,'1','great course',10001);
insert into Review(id,rating,description,course_id) values(6002,'2','bad course',10001);
insert into Review(id,rating,description,course_id) values(6003,'3','medium course',10002);

insert into student_course(student_id,course_id) values (2001,10002);
insert into student_course(student_id,course_id) values (2001,10003);
insert into student_course(student_id,course_id) values (2002,10003);