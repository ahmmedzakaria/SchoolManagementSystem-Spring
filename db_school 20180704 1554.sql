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
  `user_id` int(10) unsigned NOT NULL,
  `record_bs_id` int(10) unsigned NOT NULL,
  `group_id` int(10) unsigned NOT NULL,
  `attendance_status` bit(1) NOT NULL,
  `attendance_date` date NOT NULL,
  PRIMARY KEY  (`attendance_id`),
  KEY `FK_attendance_user_id` (`user_id`),
  KEY `FK_attendance_class_id` USING BTREE (`record_bs_id`),
  KEY `FK_attendance_group_id` (`group_id`),
  CONSTRAINT `FK_attendance_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `FK_attendance_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`),
  CONSTRAINT `FK_attendance_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance`
--

/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;


--
-- Definition of table `attendance_report`
--

DROP TABLE IF EXISTS `attendance_report`;
CREATE TABLE `attendance_report` (
  `attendance_report_id` int(10) unsigned NOT NULL auto_increment,
  `total_presents` int(10) unsigned NOT NULL,
  `total_absents` int(10) unsigned NOT NULL,
  `report_type_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `record_bs_id` int(10) unsigned NOT NULL,
  `attendance_rp_date` date NOT NULL,
  PRIMARY KEY  (`attendance_report_id`),
  KEY `FK_attendance_report_record_bs_id` (`record_bs_id`),
  KEY `FK_attendance_report_user_id` (`user_id`),
  KEY `FK_attendance_report_report_type_id` (`report_type_id`),
  CONSTRAINT `FK_attendance_report_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`),
  CONSTRAINT `FK_attendance_report_report_type_id` FOREIGN KEY (`report_type_id`) REFERENCES `attendance_report_type` (`report_type_id`),
  CONSTRAINT `FK_attendance_report_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_report`
--

/*!40000 ALTER TABLE `attendance_report` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance_report` ENABLE KEYS */;


--
-- Definition of table `attendance_report_type`
--

DROP TABLE IF EXISTS `attendance_report_type`;
CREATE TABLE `attendance_report_type` (
  `report_type_id` int(10) unsigned NOT NULL auto_increment,
  `type_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`report_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `attendance_report_type`
--

/*!40000 ALTER TABLE `attendance_report_type` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `exams`
--

/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` (`exam_id`,`exam_name`) VALUES 
 (1,'First Terms'),
 (2,'Second Terms'),
 (3,'Final');
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;


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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;


--
-- Definition of table `groups`
--

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `group_id` int(10) unsigned NOT NULL auto_increment,
  `group_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;


--
-- Definition of table `gurdian`
--

DROP TABLE IF EXISTS `gurdian`;
CREATE TABLE `gurdian` (
  `gurdian_id` int(10) unsigned NOT NULL auto_increment,
  `gurdian_name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone_no` varchar(45) NOT NULL,
  `mobile_no` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY  (`gurdian_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `gurdian`
--

/*!40000 ALTER TABLE `gurdian` DISABLE KEYS */;
INSERT INTO `gurdian` (`gurdian_id`,`gurdian_name`,`address`,`phone_no`,`mobile_no`,`email`) VALUES 
 (1,'Abdul Alim','Dhaka','02788978','01918765656','alim@gmail.com');
/*!40000 ALTER TABLE `gurdian` ENABLE KEYS */;


--
-- Definition of table `marks`
--

DROP TABLE IF EXISTS `marks`;
CREATE TABLE `marks` (
  `marks_id` int(10) unsigned NOT NULL auto_increment,
  `subject_id` int(10) unsigned NOT NULL,
  `record_dt_id` int(10) unsigned NOT NULL,
  `exam_id` int(10) unsigned NOT NULL default '100',
  `written_marks` int(10) unsigned NOT NULL,
  `mcq_marks` int(10) unsigned NOT NULL,
  `practical_marks` int(10) unsigned NOT NULL default '0',
  `grade_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`marks_id`),
  KEY `FK_marks_subject_id` (`subject_id`),
  KEY `FK_result_marks_exam_id` (`exam_id`),
  KEY `FK_marks_class_id` USING BTREE (`record_dt_id`),
  KEY `FK_marks_grade_id` (`grade_id`),
  CONSTRAINT `FK_marks_exam_id` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`),
  CONSTRAINT `FK_marks_grade_id` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`grade_id`),
  CONSTRAINT `FK_marks_record_dt_id` FOREIGN KEY (`record_dt_id`) REFERENCES `student_record_dt` (`record_dt_id`),
  CONSTRAINT `FK_marks_subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks`
--

/*!40000 ALTER TABLE `marks` DISABLE KEYS */;
/*!40000 ALTER TABLE `marks` ENABLE KEYS */;


--
-- Definition of table `marks_pattern`
--

DROP TABLE IF EXISTS `marks_pattern`;
CREATE TABLE `marks_pattern` (
  `marks_pattern_id` int(10) unsigned NOT NULL auto_increment,
  `written_marks` int(10) unsigned NOT NULL,
  `mcq_marks` int(10) unsigned NOT NULL,
  `practical_marks` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`marks_pattern_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `marks_pattern`
--

/*!40000 ALTER TABLE `marks_pattern` DISABLE KEYS */;
/*!40000 ALTER TABLE `marks_pattern` ENABLE KEYS */;


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
  `record_dt_id` int(10) unsigned NOT NULL,
  `first_term_marks` int(10) unsigned NOT NULL default '0',
  `second_term_marks` int(10) unsigned NOT NULL default '0',
  `final_marks` int(10) unsigned NOT NULL default '0',
  `avg_marks` double NOT NULL default '0',
  `persentage_marks` double NOT NULL default '0',
  PRIMARY KEY  (`progress_report_id`),
  KEY `FK_progress_report_student_id` USING BTREE (`record_dt_id`),
  CONSTRAINT `FK_progress_report_record_dt_id` FOREIGN KEY (`record_dt_id`) REFERENCES `student_record_dt` (`record_dt_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `religion`
--

/*!40000 ALTER TABLE `religion` DISABLE KEYS */;
/*!40000 ALTER TABLE `religion` ENABLE KEYS */;


--
-- Definition of table `result`
--

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `result_id` int(10) unsigned NOT NULL auto_increment,
  `record_dt_id` int(10) unsigned NOT NULL,
  `result_status` bit(1) NOT NULL,
  `grade` double NOT NULL,
  `total_marks` double unsigned zerofill NOT NULL,
  `merit_position` int(10) unsigned NOT NULL,
  `attendance` double NOT NULL,
  `result_date` date NOT NULL,
  PRIMARY KEY  USING BTREE (`result_id`),
  KEY `FK_result_student_id` USING BTREE (`record_dt_id`),
  CONSTRAINT `FK_result_record_dt_id` FOREIGN KEY (`record_dt_id`) REFERENCES `student_record_dt` (`record_dt_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `routine_sedule`
--

/*!40000 ALTER TABLE `routine_sedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `routine_sedule` ENABLE KEYS */;


--
-- Definition of table `section`
--

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `section_id` int(10) unsigned NOT NULL auto_increment,
  `section_name` varchar(45) NOT NULL,
  PRIMARY KEY  (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `section`
--

/*!40000 ALTER TABLE `section` DISABLE KEYS */;
/*!40000 ALTER TABLE `section` ENABLE KEYS */;


--
-- Definition of table `student_payment`
--

DROP TABLE IF EXISTS `student_payment`;
CREATE TABLE `student_payment` (
  `student_payment_id` int(10) unsigned NOT NULL auto_increment,
  `payment_id` int(10) unsigned NOT NULL,
  `st_payment_tp_id` int(10) unsigned NOT NULL,
  `record_dt_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`student_payment_id`),
  KEY `FK_student_payment_st_payment_tp_id` (`st_payment_tp_id`),
  KEY `FK_student_payment_record_dt_id` (`record_dt_id`),
  CONSTRAINT `FK_student_payment_record_dt_id` FOREIGN KEY (`record_dt_id`) REFERENCES `student_record_dt` (`record_dt_id`),
  CONSTRAINT `FK_student_payment_st_payment_tp_id` FOREIGN KEY (`st_payment_tp_id`) REFERENCES `student_payment_type` (`st_payment_tp_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_payment_type`
--

/*!40000 ALTER TABLE `student_payment_type` DISABLE KEYS */;
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
  `record_date` date NOT NULL,
  PRIMARY KEY  USING BTREE (`record_bs_id`),
  KEY `FK_student_record_bs_class_id` (`class_id`),
  KEY `FK_student_record_bs_section_id` (`section_id`),
  KEY `FK_student_record_bs_session_id` (`session_id`),
  KEY `FK_student_record_bs_group_id` (`group_id`),
  CONSTRAINT `FK_student_record_bs_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `FK_student_record_bs_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
  CONSTRAINT `FK_student_record_bs_section_id` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`),
  CONSTRAINT `FK_student_record_bs_session_id` FOREIGN KEY (`session_id`) REFERENCES `student_session` (`session_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_record_bs`
--

/*!40000 ALTER TABLE `student_record_bs` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_record_bs` ENABLE KEYS */;


--
-- Definition of table `student_record_dt`
--

DROP TABLE IF EXISTS `student_record_dt`;
CREATE TABLE `student_record_dt` (
  `record_dt_id` int(10) unsigned NOT NULL auto_increment,
  `roll_number` int(10) unsigned NOT NULL,
  `record_bs_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`record_dt_id`),
  KEY `FK_student_record_dt_user_id` (`user_id`),
  KEY `FK_student_record_dt_record_bs_id` (`record_bs_id`),
  CONSTRAINT `FK_student_record_dt_record_bs_id` FOREIGN KEY (`record_bs_id`) REFERENCES `student_record_bs` (`record_bs_id`),
  CONSTRAINT `FK_student_record_dt_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_session`
--

/*!40000 ALTER TABLE `student_session` DISABLE KEYS */;
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
  `gurdian_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`student_id`),
  KEY `FK_students_gurdian_id` (`gurdian_id`),
  KEY `FK_students_user_id` (`user_id`),
  CONSTRAINT `FK_students_gurdian_id` FOREIGN KEY (`gurdian_id`) REFERENCES `gurdian` (`gurdian_id`),
  CONSTRAINT `FK_students_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `students`
--

/*!40000 ALTER TABLE `students` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjects`
--

/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
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
  CONSTRAINT `FK_teacher_classes_group_id` FOREIGN KEY (`group_id`) REFERENCES `groups` (`group_id`),
  CONSTRAINT `FK_teacher_classes_class_id` FOREIGN KEY (`class_id`) REFERENCES `classes` (`class_id`),
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
  `f_name` varchar(45) NOT NULL,
  `l_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `contact_number` varchar(45) NOT NULL,
  `image_path` varchar(45) NOT NULL,
  `register_date` date NOT NULL,
  `gender` int(10) unsigned NOT NULL,
  `religion_id` int(10) unsigned NOT NULL,
  `present_address` varchar(45) NOT NULL,
  `permanent_address` varchar(45) NOT NULL,
  `reg_date` date NOT NULL,
  PRIMARY KEY  USING BTREE (`user_id`),
  KEY `FK_users_religion_id` (`religion_id`),
  KEY `FK_user_role_id` USING BTREE (`role_id`),
  CONSTRAINT `FK_users_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FK_users_religion_id` FOREIGN KEY (`religion_id`) REFERENCES `religion` (`religion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
