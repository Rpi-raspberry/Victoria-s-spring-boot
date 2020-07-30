
/**
Create Table
 */
DROP TABLE IF EXISTS firstproject.user_info;
CREATE TABLE firstproject.user_info (
    id int NOT NULL primary key,
    username varchar(32) NOT NULL,
    password varchar(128) NOT NULL

);
/**
Insert values
 */
INSERT INTO firstproject.user_info VALUES ('1', 'admin', '$2a$10$V5iwRgfXKN10XuAuR4lng.uFCQMFmsPu00wa7.YN.9JQJdGH9LAeW');
INSERT INTO firstproject.user_info VALUES ('2', 'user', '$2a$10$CU7Qh78LMsv5cjZ8dvaxC.47fjlWYIWldl2NKlf.ddIIFFSKd0vqu');
INSERT INTO firstproject.user_info VALUES ('3', 'test', '$2a$10$9HDPxT93IDRw3WmNezFOzu9W/h0lBEDllTTDtSqMRf6RnB2TReXqW');
