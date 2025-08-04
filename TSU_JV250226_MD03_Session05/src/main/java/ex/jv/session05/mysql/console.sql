create database tsubasa_javaweb_session05 ;
use tsubasa_javaweb_session05 ;
CREATE TABLE students (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          studentName VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL UNIQUE,
                          birthday DATE NOT NULL,
                          avgMark DOUBLE NOT NULL
);

DELIMITER //

CREATE PROCEDURE AddStudent(
    IN p_studentName VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_birthday DATE,
    IN p_avgMark DOUBLE
)
BEGIN
    INSERT INTO students (studentName, email, birthday, avgMark)
    VALUES (p_studentName, p_email, p_birthday, p_avgMark);
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE UpdateStudent(
    IN p_id BIGINT,
    IN p_studentName VARCHAR(255),
    IN p_email VARCHAR(255),
    IN p_birthday DATE,
    IN p_avgMark DOUBLE
)
BEGIN
    UPDATE students
    SET studentName = p_studentName,
        email = p_email,
        birthday = p_birthday,
        avgMark = p_avgMark
    WHERE id = p_id;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE DeleteStudent(
    IN p_id BIGINT
)
BEGIN
    DELETE FROM students WHERE id = p_id;
END //

DELIMITER ;
DELIMITER //

CREATE PROCEDURE FindAllStudents(IN search VARCHAR(255), IN sort VARCHAR(10))
BEGIN
    if sort = 'ASC' then
    SELECT * from students s where
            search is null or s.studentName like concat('%',search,'%') or
            s.email like concat('%',search,'%') ;
    end if ;

    if sort = 'DESC' then
        SELECT * from students s where
            search is null or s.studentName like concat('%',search,'%') or
            s.email like concat('%',search,'%') order by s.id DESC ;
    end if ;
END //

DELIMITER ;

DELIMITER //
    create procedure findStudentById(in in_id long)
    begin
        select * from students s where s.id = in_id limit 1 ;
    end //

//
DELIMITER ;