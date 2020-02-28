drop schema if exists school;
create schema school;
use school;

CREATE TABLE Course(
  course_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  title VARCHAR (45) NOT NULL,
  description VARCHAR (45) NOT NULL,
  PRIMARY KEY (course_id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE Student(
  student_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR (45) NOT NULL,
  LAST_NAME VARCHAR (45) NOT NULL,
  course_id SMALLINT UNSIGNED ,
  PRIMARY KEY (student_id)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into student (student_id, first_name, last_name, course_id)
            values  (1, 'Sergey', 'Sergeyev', 1),
                    (2, 'Ivan', 'Ivanov', 2),
                    (3, 'Mikhail', 'Mikhailov', 1),
                    (4, 'Anna', 'Sidorova', 3),
                    (5, 'Olga', 'Antonova', 3),
                    (6, 'Dmitry', 'Dmitriyev', NULL),
                    (7, 'Svetlana', 'Svetlakova', NULL);

insert into Course (course_id, title, description)
            values  (1, 'Java', 'Java Basics Programming'),
                    (2, 'QA', 'Quality Assurance and Testing'),
                    (3, 'Angular', 'JavaScript Framework'),
                    (4, 'DevOps', 'Developer Operations');

select first_name, last_name, title
from Student
left join Course on Student.course_id = Course.course_id;

select first_name, last_name, title
from Student
right join Course on Student.course_id = Course.course_id;

select first_name, last_name, title
from Student
left join Course on Student.course_id = Course.course_id
union
select first_name, last_name, title
from Student
right join Course on Student.course_id = Course.course_id;


