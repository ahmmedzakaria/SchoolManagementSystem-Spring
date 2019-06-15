-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_school
--

CREATE DATABASE IF NOT EXISTS db_school;
USE db_school;

--
-- Definition of table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance` (
  `attendance_id` int(10) unsigned NOT NULL auto_increment,
  `record_bs_id` int(10) unsigned NOT NULL,
  `attendance_status` int(10) unsigned NOT NULL,
  `attendance_date` date NOT NULL,
  `month_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`attendance_id`),
  KEY `FK_attendance_class_id` USING BTREE (`record_bs_id`),
  KEY `FK_attendance_month_id` (`month_id`),
  CONSTRAINT `FK_attendance_month_id` FOREIGN KEY (`month_id`) REFERENCES `months` (`month_id`),
  CONSTRAINT `FK_attendance_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` (`attendance_id`,`record_bs_id`,`attendance_status`,`attendance_date`,`month_id`) VALUES 
 (1,7,0,'2018-08-03',9),
 (2,14,1,'2018-08-03',9),
 (3,12,0,'2018-08-03',9),
 (4,13,1,'2018-08-03',9);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;


--
-- Definition of trigger `attendance_before_insert`
--

DROP TRIGGER /*!50030 IF EXISTS */ `attendance_before_insert`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `attendance_before_insert` BEFORE INSERT ON `attendance` FOR EACH ROW BEGIN
If NEW.attendance_status=1 THEN
UPDATE db_school.attendance_report SET total_presents=total_presents+1
where record_bs_id=NEW.record_bs_id AND month_id=NEW.month_id;
ELSEIF NEW.attendance_status=0 THEN
UPDATE db_school.attendance_report SET total_absents=total_absents+1
where record_bs_id=NEW.record_bs_id AND month_id=NEW.month_id;
END IF;
END $$

DELIMITER ;

--
-- Definition of trigger `attendance_before_update`
--

DROP TRIGGER /*!50030 IF EXISTS */ `attendance_before_update`;

DELIMITER $$

CREATE DEFINER = `root`@`localhost` TRIGGER `attendance_before_update` AFTER UPDATE ON `attendance` FOR EACH ROW BEGIN
IF NEW.attendance_status=1 THEN
 	IF old.attendance_status=0 THEN
    UPDATE db_school.attendance_report SET total_presents=total_presents+1 AND total_absents=total_absents-1
    where record_bs_id=NEW.record_bs_id AND month_id=NEW.month_id;
	END IF;
ELSEIF NEW.attendance_status=0 THEN
	IF old.attendance_status=1 THEN
    UPDATE db_school.attendance_report SET total_absents=total_absents+1 AND total_presents=total_presents-1
    where record_bs_id=NEW.record_bs_id AND month_id=NEW.month_id;
	END IF;
END IF;
END $$

DELIMITER ;

--
-- Definition of table `attendance_report`
--

DROP TABLE IF EXISTS `attendance_report`;
CREATE TABLE `attendance_report` (
  `attendance_report_id` int(10) unsigned NOT NULL auto_increment,
  `total_presents` int(10) unsigned NOT NULL,
  `total_absents` int(10) unsigned NOT NULL,
  `record_bs_id` int(10) unsigned NOT NULL,
  `month_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`attendance_report_id`),
  KEY `FK_attendance_report_record_bs_id` (`record_bs_id`),
  KEY `FK_attendance_report_month_id` (`month_id`),
  CONSTRAINT `FK_attendance_report_month_id` FOREIGN KEY (`month_id`) REFERENCES `months` (`month_id`),
  CONSTRAINT `FK_attendance_report_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_report`
--

/*!40000 ALTER TABLE `attendance_report` DISABLE KEYS */;
INSERT INTO `attendance_report` (`attendance_report_id`,`total_presents`,`total_absents`,`record_bs_id`,`month_id`) VALUES 
 (1,0,1,7,9),
 (2,1,0,14,9),
 (3,0,1,12,9),
 (4,1,0,13,9);
/*!40000 ALTER TABLE `attendance_report` ENABLE KEYS */;


--
-- Definition of table `attendance_report_type`
--

DROP TABLE IF EXISTS `attendance_report_type`;
CREATE TABLE `attendance_report_type` (
  `report_type_id` int(10) unsigned NOT NULL auto_increment,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`report_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_report_type`
--

/*!40000 ALTER TABLE `attendance_report_type` DISABLE KEYS */;
INSERT INTO `attendance_report_type` (`report_type_id`,`type_name`) VALUES 
 (1,'Monthly'),
 (2,'On Exam'),
 (3,'Yearly');
/*!40000 ALTER TABLE `attendance_report_type` ENABLE KEYS */;


--
-- Definition of table `classes`
--

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `class_id` int(10) unsigned NOT NULL auto_increment,
  `class_name` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classes`
--

/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`class_id`,`class_name`) VALUES 
 (6,'Six'),
 (7,'Seven'),
 (8,'Eight'),
 (9,'Nine'),
 (10,'Ten');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;


--
-- Definition of table `exams`
--

DROP TABLE IF EXISTS `exams`;
CREATE TABLE `exams` (
  `exam_id` int(10) unsigned NOT NULL auto_increment,
  `exam_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exams`
--

/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` (`exam_id`,`exam_name`) VALUES 
 (1,'First Terms'),
 (2,'Second Terms'),
 (3,'Final'),
 (4,'Class Test'),
 (5,'Test'),
 (6,'Pre-Test');
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;


--
-- Definition of table `gender`
--

DROP TABLE IF EXISTS `gender`;
CREATE TABLE `gender` (
  `gender_id` int(10) unsigned NOT NULL auto_increment,
  `gender_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`gender_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gender`
--

/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` (`gender_id`,`gender_name`) VALUES 
 (1,'Male'),
 (2,'Femail');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;


--
-- Definition of table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `grade_id` int(10) unsigned NOT NULL auto_increment,
  `grade_name` varchar(45) NOT NULL,
  `grade_point` double NOT NULL,
  `parcentage` double NOT NULL,
  PRIMARY KEY  (`grade_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` (`grade_id`,`grade_name`,`grade_point`,`parcentage`) VALUES 
 (1,'A+',5,80),
 (2,'A',4,70),
 (3,'A-',3.5,60),
 (4,'B',3,50),
 (5,'C',2,40),
 (6,'D',1,33),
 (7,'F',0,0);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;


--
-- Definition of table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `group_id` int(10) unsigned NOT NULL auto_increment,
  `group_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT INTO `groups` (`group_id`,`group_name`) VALUES 
 (1,'None'),
 (2,'Science'),
 (3,'Commerce'),
 (4,'Arts');
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;


--
-- Definition of table `guardian`
--

DROP TABLE IF EXISTS `guardian`;
CREATE TABLE `guardian` (
  `guardian_id` int(10) unsigned NOT NULL auto_increment,
  `guardian_name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`guardian_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `guardian`
--

/*!40000 ALTER TABLE `guardian` DISABLE KEYS */;
INSERT INTO `guardian` (`guardian_id`,`guardian_name`,`address`,`phone_no`,`mobile_no`,`email`) VALUES 
 (1,'Abdul Rohim','Dhaka','02788978','01918765656','alim@gmail.com'),
 (2,'Jamal','Dhaka','87982032','012908192','jamal@gmail.com'),
 (3,'Kasem','Dhaka','02788978','01918765656','alim@gmail.com');
/*!40000 ALTER TABLE `guardian` ENABLE KEYS */;


--
-- Definition of table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE `marks` (
  `marks_id` int(10) unsigned NOT NULL auto_increment,
  `subject_id` int(10) unsigned NOT NULL,
  `record_bs_id` int(10) unsigned NOT NULL,
  `exam_id` int(10) unsigned NOT NULL default '100',
  `written_marks` int(10) unsigned NOT NULL,
  `mcq_marks` int(10) unsigned NOT NULL,
  `practical_marks` int(10) unsigned NOT NULL default '0',
  `grade_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`marks_id`),
  KEY `FK_marks_subject_id` (`subject_id`),
  KEY `FK_result_marks_exam_id` (`exam_id`),
  KEY `FK_marks_grade_id` (`grade_id`),
  KEY `FK_marks_class_id` USING BTREE (`record_bs_id`),
  CONSTRAINT `FK_marks_exam_id` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`),
  CONSTRAINT `FK_marks_grade_id` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`),
  CONSTRAINT `FK_marks_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`),
  CONSTRAINT `FK_marks_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
INSERT INTO `marks` (`marks_id`,`subject_id`,`record_bs_id`,`exam_id`,`written_marks`,`mcq_marks`,`practical_marks`,`grade_id`) VALUES 
 (1,3,1,1,0,0,0,7),
 (2,3,2,1,0,0,0,7),
 (3,3,3,1,0,0,0,7);
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;


--
-- Definition of table `marks_pattern`
--

DROP TABLE IF EXISTS `marks_pattern`;
CREATE TABLE `marks_pattern` (
  `marks_pattern_id` int(10) unsigned NOT NULL auto_increment,
  `written_marks` int(10) unsigned NOT NULL,
  `mcq_marks` int(10) unsigned NOT NULL,
  `practical_marks` int(10) unsigned NOT NULL default '0',
  `pattern_name` varchar(45) NOT NULL,
  `note` varchar(45) NOT NULL default '',
  PRIMARY KEY  USING BTREE (`marks_pattern_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks_pattern`
--

/*!40000 ALTER TABLE `marks_pattern` DISABLE KEYS */;
INSERT INTO `marks_pattern` (`marks_pattern_id`,`written_marks`,`mcq_marks`,`practical_marks`,`pattern_name`,`note`) VALUES 
 (1,50,50,0,'General',''),
 (2,35,35,25,'Science','');
/*!40000 ALTER TABLE `marks_pattern` ENABLE KEYS */;


--
-- Definition of table `months`
--

DROP TABLE IF EXISTS `months`;
CREATE TABLE `months` (
  `month_id` int(10) unsigned NOT NULL auto_increment,
  `month_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`month_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `months`
--

/*!40000 ALTER TABLE `months` DISABLE KEYS */;
INSERT INTO `months` (`month_id`,`month_name`) VALUES 
 (1,'January'),
 (2,'February'),
 (3,'March'),
 (4,'April'),
 (5,'May'),
 (6,'June'),
 (7,'July'),
 (8,'August'),
 (9,'September'),
 (10,'October'),
 (11,'November'),
 (12,'December');
/*!40000 ALTER TABLE `months` ENABLE KEYS */;


--
-- Definition of table `notice`
--

DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(10) unsigned NOT NULL auto_increment,
  `file_location` varchar(45) NOT NULL,
  `notice_date` date NOT NULL,
  `notice_status` bit(1) NOT NULL,
  PRIMARY KEY  (`notice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice`
--

/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `payment_id` int(10) unsigned NOT NULL auto_increment,
  `amount` varchar(45) NOT NULL,
  `month_no` int(10) unsigned NOT NULL,
  `payment_date` date NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `payment_method` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`payment_id`),
  KEY `FK_payment_user_id` (`user_id`),
  CONSTRAINT `FK_payment_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `progress_report`
--

DROP TABLE IF EXISTS `progress_report`;
CREATE TABLE `progress_report` (
  `progress_report_id` int(10) unsigned NOT NULL auto_increment,
  `record_bs_id` int(10) unsigned NOT NULL,
  `first_term_marks` int(10) unsigned NOT NULL default '0',
  `second_term_marks` int(10) unsigned NOT NULL default '0',
  `final_marks` int(10) unsigned NOT NULL default '0',
  `avg_marks` double NOT NULL default '0',
  `persentage_marks` double NOT NULL default '0',
  PRIMARY KEY  (`progress_report_id`),
  KEY `FK_progress_report_student_id` USING BTREE (`record_bs_id`),
  CONSTRAINT `FK_progress_report_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `progress_report`
--

/*!40000 ALTER TABLE `progress_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `progress_report` ENABLE KEYS */;


--
-- Definition of table `religion`
--

DROP TABLE IF EXISTS `religion`;
CREATE TABLE `religion` (
  `religion_id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY  (`religion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `religion`
--

/*!40000 ALTER TABLE `religion` DISABLE KEYS */;
INSERT INTO `religion` (`religion_id`,`name`) VALUES 
 (1,' Islam'),
 (2,'Hinduism'),
 (3,'Christianity'),
 (4,'Buddhism');
/*!40000 ALTER TABLE `religion` ENABLE KEYS */;


--
-- Definition of table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `result_id` int(10) unsigned NOT NULL auto_increment,
  `record_bs_id` int(10) unsigned NOT NULL,
  `result_status` bit(1) NOT NULL,
  `grade` double NOT NULL,
  `total_marks` double unsigned zerofill NOT NULL,
  `merit_position` int(10) unsigned NOT NULL,
  `attendance` double NOT NULL,
  `result_date` date NOT NULL,
  PRIMARY KEY  USING BTREE (`result_id`),
  KEY `FK_result_student_id` USING BTREE (`record_bs_id`),
  CONSTRAINT `FK_result_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `result`
--

/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(10) unsigned NOT NULL auto_increment,
  `role_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`,`role_name`) VALUES 
 (1,'Admin'),
 (2,'Teacher'),
 (3,'Office'),
 (4,'Student');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `routine_maintainer`
--

DROP TABLE IF EXISTS `routine_maintainer`;
CREATE TABLE `routine_maintainer` (
  `routine_maintain_id` int(10) unsigned NOT NULL auto_increment,
  `record_bs_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `sedule_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`routine_maintain_id`),
  KEY `FK_routine_maintainer_record_bs_id` (`record_bs_id`),
  KEY `FK_routine_maintainer_user_id` (`user_id`),
  KEY `FK_routine_maintainer_sedule_id` (`sedule_id`),
  CONSTRAINT `FK_routine_maintainer_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`),
  CONSTRAINT `FK_routine_maintainer_sedule_id` FOREIGN KEY (`sedule_id`) REFERENCES `routine_sedule` (`sedule_id`),
  CONSTRAINT `FK_routine_maintainer_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `routine_maintainer`
--

/*!40000 ALTER TABLE `routine_maintainer` DISABLE KEYS */;
/*!40000 ALTER TABLE `routine_maintainer` ENABLE KEYS */;


--
-- Definition of table `routine_sedule`
--

DROP TABLE IF EXISTS `routine_sedule`;
CREATE TABLE `routine_sedule` (
  `sedule_id` int(10) unsigned NOT NULL auto_increment,
  `class_start_time` datetime NOT NULL,
  `class_end_time` datetime NOT NULL,
  `sedule_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`sedule_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `routine_sedule`
--

/*!40000 ALTER TABLE `routine_sedule` DISABLE KEYS */;
INSERT INTO `routine_sedule` (`sedule_id`,`class_start_time`,`class_end_time`,`sedule_name`) VALUES 
 (1,'2018-00-01 09:00:00','2018-00-01 09:45:00','klj');
/*!40000 ALTER TABLE `routine_sedule` ENABLE KEYS */;


--
-- Definition of table `section`
--

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `section_id` int(10) unsigned NOT NULL auto_increment,
  `section_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`section_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `section`
--

/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` (`section_id`,`section_name`) VALUES 
 (1,'A'),
 (2,'B'),
 (3,'C');
/*!40000 ALTER TABLE `section` ENABLE KEYS */;


--
-- Definition of table `st_payment_by_class`
--

DROP TABLE IF EXISTS `st_payment_by_class`;
CREATE TABLE `st_payment_by_class` (
  `payment_by_cls_id` int(10) unsigned NOT NULL auto_increment,
  `class_id` int(10) unsigned NOT NULL,
  `st_payment_tp_id` int(10) unsigned NOT NULL,
  `payment_amount` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`payment_by_cls_id`),
  KEY `FK_st_payment_by_class_class_id` (`class_id`),
  KEY `FK_st_payment_by_class_st_payment_tp_id` (`st_payment_tp_id`),
  CONSTRAINT `FK_st_payment_by_class_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FK_st_payment_by_class_st_payment_tp_id` FOREIGN KEY (`st_payment_tp_id`) REFERENCES `student_payment_type` (`st_payment_tp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `st_payment_by_class`
--

/*!40000 ALTER TABLE `st_payment_by_class` DISABLE KEYS */;
INSERT INTO `st_payment_by_class` (`payment_by_cls_id`,`class_id`,`st_payment_tp_id`,`payment_amount`) VALUES 
 (1,6,1,40),
 (2,7,1,50),
 (3,8,1,60),
 (4,9,1,70),
 (5,10,1,80),
 (6,6,2,70),
 (7,7,2,80),
 (8,8,2,90),
 (9,9,2,10),
 (10,10,2,10),
 (11,8,3,800),
 (12,10,3,1500);
/*!40000 ALTER TABLE `st_payment_by_class` ENABLE KEYS */;


--
-- Definition of table `student_payment`
--

DROP TABLE IF EXISTS `student_payment`;
CREATE TABLE `student_payment` (
  `student_payment_id` int(10) unsigned NOT NULL auto_increment,
  `payment_id` int(10) unsigned NOT NULL,
  `payment_by_cls_id` int(10) unsigned NOT NULL,
  `record_bs_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`student_payment_id`),
  KEY `FK_student_payment_st_payment_tp_id` USING BTREE (`payment_by_cls_id`),
  KEY `FK_student_payment_record_dt_id` USING BTREE (`record_bs_id`),
  CONSTRAINT `FK_student_payment_payment_by_cls_id` FOREIGN KEY (`payment_by_cls_id`) REFERENCES `st_payment_by_class` (`payment_by_cls_id`),
  CONSTRAINT `FK_student_payment_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_payment`
--

/*!40000 ALTER TABLE `student_payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_payment` ENABLE KEYS */;


--
-- Definition of table `student_payment_type`
--

DROP TABLE IF EXISTS `student_payment_type`;
CREATE TABLE `student_payment_type` (
  `st_payment_tp_id` int(10) unsigned NOT NULL auto_increment,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`st_payment_tp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_payment_type`
--

/*!40000 ALTER TABLE `student_payment_type` DISABLE KEYS */;
INSERT INTO `student_payment_type` (`st_payment_tp_id`,`type_name`) VALUES 
 (1,'Student Montly Fee'),
 (2,'Exam Fee'),
 (3,'Form Fillup Fee'),
 (4,'Seminar Fee'),
 (5,'Library Fee');
/*!40000 ALTER TABLE `student_payment_type` ENABLE KEYS */;


--
-- Definition of table `student_record_bs`
--

DROP TABLE IF EXISTS `student_record_bs`;
CREATE TABLE `student_record_bs` (
  `record_bs_id` int(10) unsigned NOT NULL auto_increment,
  `class_id` int(10) unsigned NOT NULL,
  `group_id` int(10) unsigned NOT NULL,
  `section_id` int(10) unsigned NOT NULL,
  `session_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `roll_number` int(10) unsigned NOT NULL,
  `record_date` date NOT NULL,
  PRIMARY KEY  USING BTREE (`record_bs_id`),
  KEY `FK_student_record_bs_class_id` (`class_id`),
  KEY `FK_student_record_bs_section_id` (`section_id`),
  KEY `FK_student_record_bs_session_id` (`session_id`),
  KEY `FK_student_record_bs_group_id` (`group_id`),
  KEY `FK_student_record_bs_user_id` (`user_id`),
  CONSTRAINT `FK_student_record_bs_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FK_student_record_bs_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `FK_student_record_bs_section_id` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`),
  CONSTRAINT `FK_student_record_bs_session_id` FOREIGN KEY (`session_id`) REFERENCES `student_session` (`session_id`),
  CONSTRAINT `FK_student_record_bs_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_record_bs`
--

/*!40000 ALTER TABLE `student_record_bs` DISABLE KEYS */;
INSERT INTO `student_record_bs` (`record_bs_id`,`class_id`,`group_id`,`section_id`,`session_id`,`user_id`,`roll_number`,`record_date`) VALUES 
 (1,6,4,1,1,5,1,'2018-01-01'),
 (2,6,1,1,1,12,1,'2018-07-14'),
 (3,6,1,2,1,13,2,'2018-07-14'),
 (7,6,1,3,2,17,2,'2018-07-15'),
 (8,7,2,2,3,30,5,'2018-07-20'),
 (9,8,2,1,4,33,3,'2018-07-20'),
 (10,8,3,1,3,35,8,'2018-07-21'),
 (11,8,2,2,2,40,6,'2018-08-02'),
 (12,9,2,3,2,42,1,'2018-08-02'),
 (13,9,3,2,2,46,2,'2018-08-02'),
 (14,7,1,1,2,48,1,'2018-08-02');
/*!40000 ALTER TABLE `student_record_bs` ENABLE KEYS */;


--
-- Definition of table `student_record_dt`
--

DROP TABLE IF EXISTS `student_record_dt`;
CREATE TABLE `student_record_dt` (
  `record_dt_id` int(10) unsigned NOT NULL auto_increment,
  `roll_number` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`record_dt_id`),
  KEY `FK_student_record_dt_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_record_dt`
--

/*!40000 ALTER TABLE `student_record_dt` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_record_dt` ENABLE KEYS */;


--
-- Definition of table `student_session`
--

DROP TABLE IF EXISTS `student_session`;
CREATE TABLE `student_session` (
  `session_id` int(10) unsigned NOT NULL auto_increment,
  `session_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`session_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_session`
--

/*!40000 ALTER TABLE `student_session` DISABLE KEYS */;
INSERT INTO `student_session` (`session_id`,`session_name`) VALUES 
 (1,'2015'),
 (2,'2016'),
 (3,'2017'),
 (4,'2018');
/*!40000 ALTER TABLE `student_session` ENABLE KEYS */;


--
-- Definition of table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `student_id` int(10) unsigned NOT NULL auto_increment,
  `father_name` varchar(45) NOT NULL,
  `mother_name` varchar(45) NOT NULL,
  `dob` date NOT NULL,
  `guardian_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`student_id`),
  KEY `FK_students_user_id` (`user_id`),
  KEY `FK_students_gurdian_id` USING BTREE (`guardian_id`),
  CONSTRAINT `FK_students_guardian_id` FOREIGN KEY (`guardian_id`) REFERENCES `guardian` (`guardian_id`),
  CONSTRAINT `FK_students_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`student_id`,`father_name`,`mother_name`,`dob`,`guardian_id`,`user_id`) VALUES 
 (1,'Rofiqul','Amina','2018-01-01',1,4);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;


--
-- Definition of table `sub_scholarship`
--

DROP TABLE IF EXISTS `sub_scholarship`;
CREATE TABLE `sub_scholarship` (
  `sub_schol_id` int(10) unsigned NOT NULL auto_increment,
  `class_id` int(10) unsigned NOT NULL,
  `boy_amount` double NOT NULL,
  `girl_amount` double NOT NULL,
  `eligble_att_pd` double NOT NULL,
  `eligible_result` double NOT NULL,
  PRIMARY KEY  (`sub_schol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sub_scholarship`
--

/*!40000 ALTER TABLE `sub_scholarship` DISABLE KEYS */;
/*!40000 ALTER TABLE `sub_scholarship` ENABLE KEYS */;


--
-- Definition of table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects` (
  `subject_id` int(10) unsigned NOT NULL auto_increment,
  `group_id` int(10) unsigned NOT NULL default '0',
  `subject_name` varchar(45) NOT NULL,
  `marks_pattern_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`subject_id`),
  KEY `FK_subjects_marks_pattern_id` (`marks_pattern_id`),
  KEY `FK_subjects_group_id` (`group_id`),
  CONSTRAINT `FK_subjects_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `FK_subjects_marks_pattern_id` FOREIGN KEY (`marks_pattern_id`) REFERENCES `marks_pattern` (`marks_pattern_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` (`subject_id`,`group_id`,`subject_name`,`marks_pattern_id`) VALUES 
 (1,1,'Bangla',1),
 (2,1,'English',1),
 (3,1,'Mathematics',1),
 (4,1,'Social Science',1),
 (5,1,'General Science',1),
 (6,1,'Islamic Study',1),
 (7,1,'Hinduism Study',1),
 (8,1,'Information And Communication Technology',1),
 (9,1,'Agricultural Science',1),
 (10,1,'Home Echonomics',1),
 (11,2,'Physics',2),
 (12,2,'Chemistry',2),
 (13,2,'Biology',2),
 (14,2,'Higher Mathematics',2),
 (15,4,'Civics',2),
 (16,4,'History',2),
 (17,4,'Giography',2),
 (18,4,'Islamic History',2),
 (19,3,'Management',2),
 (20,3,'Accoounting',2),
 (21,3,'Marketing',2);
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;


--
-- Definition of table `teacher_classes`
--

DROP TABLE IF EXISTS `teacher_classes`;
CREATE TABLE `teacher_classes` (
  `teacher_classes_id` int(10) unsigned NOT NULL auto_increment,
  `subject_id` int(10) unsigned NOT NULL,
  `class_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `group_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`teacher_classes_id`),
  KEY `FK_teacher_classes_subject_id` (`subject_id`),
  KEY `FK_teacher_classes_user_id` (`user_id`),
  KEY `FK_teacher_classes_class_id` USING BTREE (`class_id`),
  KEY `FK_teacher_classes_group_id` USING BTREE (`group_id`),
  CONSTRAINT `FK_teacher_classes_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FK_teacher_classes_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `FK_teacher_classes_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`),
  CONSTRAINT `FK_teacher_classes_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `teacher_classes`
--

/*!40000 ALTER TABLE `teacher_classes` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_classes` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(10) unsigned NOT NULL auto_increment,
  `role_id` int(10) unsigned NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) default NULL,
  `user_name` varchar(45) default NULL,
  `user_password` varchar(45) default NULL,
  `contact_number` varchar(45) default NULL,
  `image_path` varchar(45) default NULL,
  `register_date` date default NULL,
  `gender_id` int(10) unsigned NOT NULL,
  `religion_id` int(10) unsigned NOT NULL,
  `present_address` varchar(45) default NULL,
  `permanent_address` varchar(45) default NULL,
  `dob` date default NULL,
  PRIMARY KEY  USING BTREE (`user_id`),
  KEY `FK_users_religion_id` (`religion_id`),
  KEY `FK_user_role_id` USING BTREE (`role_id`),
  KEY `FK_users_gender_id` (`gender_id`),
  CONSTRAINT `FK_users_gender_id` FOREIGN KEY (`gender_id`) REFERENCES `gender` (`gender_id`),
  CONSTRAINT `FK_users_religion_id` FOREIGN KEY (`religion_id`) REFERENCES `religion` (`religion_id`),
  CONSTRAINT `FK_users_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`user_id`,`role_id`,`first_name`,`last_name`,`email`,`user_name`,`user_password`,`contact_number`,`image_path`,`register_date`,`gender_id`,`religion_id`,`present_address`,`permanent_address`,`dob`) VALUES 
 (2,1,'islam','afsana','jkh','jkh','lk','9808','iou','2018-07-07',2,1,'Dhaka','Foridpur','2018-07-07'),
 (3,1,'Salam','Abdus','jkh','87687987','lk','9808','iou','2018-07-07',1,1,'iuyi','uyoi','2018-07-07'),
 (4,2,'Shikdar','Rubel','jkh','jkh','lk','9808','iou','2018-07-08',1,1,'iuyi','uyoi','2018-07-07'),
 (5,4,'Sofia','Begum','jkh','jkh','4567890','9808','iou','2018-07-08',2,1,'Dhaka','Cumilla','2018-07-07'),
 (7,4,'Rubel','Mia','skdflsj','rubel','123',NULL,NULL,'2018-07-12',1,1,NULL,NULL,'2018-07-12'),
 (12,4,'Atik','cvcvpoiu','dui','ios','lkjh',NULL,NULL,'2018-07-14',1,1,NULL,NULL,'2018-07-14'),
 (13,4,'Shofique','uiweru','jkdf','cmvnj','jkdsf',NULL,NULL,'2018-07-14',1,1,NULL,NULL,'2018-07-14'),
 (17,4,'Arif','lskdf','lksdf','klsdf','klsdf',NULL,NULL,'2018-07-15',1,1,NULL,NULL,'2018-07-15'),
 (19,2,'English Teacher','lkjds','kljasdf','lkjdsf','kjsdaf',NULL,NULL,'2018-07-18',2,1,NULL,NULL,'2018-07-18'),
 (20,3,'lkajlkj','lkjs','lkj','lkjs','lkjs',NULL,NULL,'2018-07-18',1,1,NULL,NULL,'2018-07-18'),
 (21,1,'Zakaria','lksd','lkjlskj','lkjs','lkjsl',NULL,NULL,'2018-07-19',1,1,NULL,NULL,'2018-07-19'),
 (22,2,'Teacher','kljdsa','kjsdf','kljsdlk','kjsdfkj',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (23,3,'Office','kljsd','kjs','kjsl','lkjs',NULL,NULL,'2018-07-20',2,1,NULL,NULL,'2018-07-20'),
 (24,4,'Masud','uiweru','jkdf','cmvnj','jkdsf',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (26,4,'Riaz','lkja','jkla',NULL,NULL,NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (27,2,'lksdfa','lksdf','jkla;df','kljadsf','lkjasdf',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (28,4,'Saddam','lkjas','kjaf','kla','lkjasdf',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (30,4,'Sumon','klsd','klja;','jlkas','kljas',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (31,4,'Rohman','uiweru','jkdf','cmvnj','jkdsf',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (32,4,'Labon','lkjsdf','l;akds','jklasdf','klsda',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (33,4,'Jamal','asdfkl','kja','ksdfa','klasdj',NULL,NULL,'2018-07-20',1,1,NULL,NULL,'2018-07-20'),
 (34,4,'Munna','lkja','lkj','lkja','kl;saf',NULL,NULL,'2018-07-21',1,1,NULL,NULL,'2018-07-21'),
 (35,4,'Pavel','lkja','lkj','lkja','kl;saf',NULL,NULL,'2018-07-21',1,1,NULL,NULL,'2018-07-21'),
 (36,4,'Polash','lksdj','jlka','kljasd','lkja',NULL,NULL,'2018-07-22',1,1,NULL,NULL,'2018-07-22'),
 (37,4,'Limon','lksdj','jlka','kljasd','lkja',NULL,NULL,'2018-07-22',1,1,NULL,NULL,'2018-07-22'),
 (38,2,'Physics Teacher','lkja','jlkaf','lkjaf','lkjsd',NULL,NULL,'2018-07-23',1,1,NULL,NULL,'2018-07-23'),
 (39,4,'Nurul','lkjsld','kjlsadf','lksja','kjls',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (40,4,'Nafiz','lkjsld','kjlsadf','lksja','kjls',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (41,4,'Solman','lkjs','lk','kjsda','lkjsd',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (42,4,'Jabed','lkjs','lk','kjsda','lkjsd',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (43,4,'Josim','sdf','lkja','lksjda','lkjsd',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (44,4,'Kayes','sdf','lkja','lksjda','lkjsd',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (45,4,'Khadiza','kjsdl','jlkadf','lkds','jlsd',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (46,4,'Amina','kjsdl','jlkadf','lkds','jlsd',NULL,NULL,'2018-08-02',1,1,NULL,NULL,'2018-08-02'),
 (47,4,'Basir','lkjsd','kjsdfa','jksld','lkjsd',NULL,NULL,'2018-08-02',2,1,NULL,NULL,'2018-08-02'),
 (48,4,'Chomok','lkjsd','kjsdfa','jksld','lkjsd',NULL,NULL,'2018-08-02',2,1,NULL,NULL,'2018-08-02');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
