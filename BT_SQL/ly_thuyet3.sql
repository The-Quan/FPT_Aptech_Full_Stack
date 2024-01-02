
CREATE TABLE Student (
    SID INT PRIMARY KEY NOT NULL,
    S_FName VARCHAR(20) NOT NULL,
    S_LName VARCHAR(30) NOT NULL
);


CREATE TABLE Course (
    CID INT PRIMARY KEY NOT NULL,
    C_Name VARCHAR(30) NOT NULL
);

CREATE TABLE Course_Grades (
    CGID INT PRIMARY KEY NOT NULL,
    Semester CHAR(4) NOT NULL,
    CID INT NOT NULL,
    SID INT NOT NULL,
    Grade CHAR(2) NOT NULL,
    FOREIGN KEY (CID) REFERENCES Course(CID),
    FOREIGN KEY (SID) REFERENCES Student(SID)
);

INSERT INTO Student (SID, S_FName, S_LName) VALUES
(12345, 'Chris', 'Rock'),
(23456, 'Chris', 'Farley'),
(34567, 'David', 'Spade'),
(45678, 'Liz', 'Lemon'),
(56789, 'Jack', 'Donaghy');

INSERT INTO Course (CID, C_Name) VALUES
(101001, 'Intro to Computers'),
(101002, 'Programming'),
(101003, 'Databases'),
(101004, 'Websites'),
(101005, 'IS Management');

INSERT INTO Course_Grades (CGID, Semester, CID, SID, Grade) VALUES
(2010101, 'SP10', 101005, 34567, 'D+'),
(2010308, 'FA10', 101005, 34567, 'A-'),
(2010309, 'FA10', 101001, 45678, 'B+'),
(2011308, 'FA11', 101003, 23456, 'B-'),
(2012206, 'SU12', 101002, 56789, 'A+');

ALTER TABLE Student
ALTER COLUMN S_FName VARCHAR(30);

ALTER TABLE Course
ADD Faculty_LName VARCHAR(30) NOT NULL DEFAULT 'TBD';

UPDATE Course
SET C_Name = 'Intro to Wizardry', Faculty_LName = 'Potter'
WHERE CID = 101001;

EXEC sp_rename 'Course.C_Name', 'Course_Name', 'COLUMN';

DELETE FROM Course
WHERE Course_Name = 'Websites';

select * from Student
select * from course
select * from Course_Grades