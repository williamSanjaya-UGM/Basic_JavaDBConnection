CREATE DATABASE triggering;
USE triggering;

CREATE TABLE student(
	studentId INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(25) NOT NULL,
    address varchar(255)
    ) ENGINE = InnoDB;

CREATE TABLE student_dump(
	studentId INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(25) NOT NULL,
    address varchar(255)
    ) ENGINE = InnoDB;

Insert into student(name, email,address) VALUES('William','william@mail.com','alamaat william'),
('Sanjaya','sanjaya@mail.com','alamaat sanjaya'),
('James','james@mail.com','alamaat james'),
('Janggo','janggo@mail.com','alamaat janggo'),
('Stewart','stewart@mail.com','alamaat stewart');

DROP TRIGGER IF EXISTS tr_ins_student_dump;

DELIMITER $$
CREATE TRIGGER tr_ins_student_dump
AFTER INSERT ON student
FOR EACH ROW
BEGIN
	INSERT INTO student_dump(`studentId`,`name`,`email`,`address`) VALUES
    (new.studentId,new.name,new.email,new.address);
END $$