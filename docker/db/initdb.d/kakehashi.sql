-- Project Name : kakehashi
-- Date/Time    : 2022/12/18 18:15:57
-- Author       : crossover
-- RDBMS Type   : MySQL
-- Application  : A5:SQL Mk-2
DROP DATABASE IF EXISTS kakehashi;
CREATE DATABASE IF NOT EXISTS kakehashi;
USE kakehashi;

-- branch
DROP TABLE if exists branch CASCADE;

CREATE TABLE branch (
  id int auto_increment NOT NULL COMMENT 'id'
  , branch_name varchar(123) NOT NULL COMMENT 'branch_name'
  , name_bystudent varchar(45) COMMENT 'name_bystudent'
  , headquarter_id int NOT NULL COMMENT 'headquarter_id'
  , ward_id int NOT NULL COMMENT 'ward_id'
  , zone_id int NOT NULL COMMENT 'zone_id'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , CONSTRAINT branch_PKC PRIMARY KEY (id,headquarter_id,ward_id,zone_id)
) COMMENT 'branch' ;

CREATE INDEX fk_branch_headquarter1_idx
  ON branch(headquarter_id,ward_id,zone_id);

-- citizen
DROP TABLE if exists citizen CASCADE;

CREATE TABLE citizen (
  id int auto_increment NOT NULL COMMENT 'id'
  , municipality varchar(45) NOT NULL COMMENT '市町村名'
  , prefecture varchar(45) NOT NULL COMMENT '県名'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , CONSTRAINT citizen_PKC PRIMARY KEY (id)
) COMMENT 'citizen' ;

-- district
DROP TABLE if exists district CASCADE;

CREATE TABLE district (
  id int auto_increment NOT NULL COMMENT 'id'
  , district_name varchar(123) NOT NULL COMMENT 'district_name'
  , branch_id int NOT NULL COMMENT 'branch_id'
  , headquarter_id int NOT NULL COMMENT 'headquarter_id'
  , ward_id int NOT NULL COMMENT 'ward_id'
  , zone_id int NOT NULL COMMENT 'zone_id'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , CONSTRAINT district_PKC PRIMARY KEY (id,branch_id,headquarter_id,ward_id,zone_id)
) COMMENT 'district' ;

CREATE INDEX fk_district_branch1_idx
  ON district(branch_id,headquarter_id,ward_id,zone_id);

-- examination
DROP TABLE if exists examination CASCADE;

CREATE TABLE examination (
  id int auto_increment NOT NULL COMMENT 'id'
  , examination_name varchar(123) NOT NULL COMMENT 'examination_name'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , CONSTRAINT examination_PKC PRIMARY KEY (id)
) COMMENT 'examination' ;

ALTER TABLE examination ADD UNIQUE examination_name_UNIQUE (examination_name) ;

-- headquarter
DROP TABLE if exists headquarter CASCADE;

CREATE TABLE headquarter (
  headquarter_name varchar(123) NOT NULL COMMENT 'headquarter_name'
  , id int auto_increment NOT NULL COMMENT 'id'
  , name_bystudent varchar(45) COMMENT 'name_bystudent'
  , ward_id int NOT NULL COMMENT 'ward_id'
  , zone_id int NOT NULL COMMENT 'zone_id'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , CONSTRAINT headquarter_PKC PRIMARY KEY (id,ward_id,zone_id)
) COMMENT 'headquarter' ;

CREATE INDEX fk_headquarter_ward1_idx
  ON headquarter(ward_id,zone_id);

-- login_user
DROP TABLE if exists login_user CASCADE;

CREATE TABLE login_user (
  id int auto_increment COMMENT 'id'
  , member_id INT COMMENT 'member_id'
  , role_id INT NOT NULL COMMENT 'role_id'
  , login_user_name varchar(45) NOT NULL COMMENT 'login_user_name'
  , email varchar(255) NOT NULL COMMENT 'email'
  , isEnabled int NOT NULL COMMENT 'isEnabled'
  , updatedat datetime COMMENT 'updatedat'
  , createdat datetime COMMENT 'createdat'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , CONSTRAINT login_user_PKC PRIMARY KEY (id)
) COMMENT 'login_user' ;

ALTER TABLE login_user ADD UNIQUE email_UNIQUE (email) ;

CREATE INDEX fk_login_user_has_role_login_user1_idx
  ON login_user(role_id);

-- member
DROP TABLE if exists member CASCADE;

CREATE TABLE member (
  id int auto_increment COMMENT 'id'
  ,uuid varchar(32) NOT NULL COMMENT 'uuid'
  , member_name varchar(45) NOT NULL COMMENT 'member_name'
  , address varchar(45) COMMENT 'address'
  , grade varchar(45) COMMENT 'grade'
  , birthday varchar(8) COMMENT 'birthday'
  , note varchar(1024) COMMENT 'note'
  , mobile_phone varchar(13) COMMENT 'mobile_phone'
  , phone varchar(13) COMMENT 'phone'
  , can_visit tinyint COMMENT 'can_visit'
  , citizen_id int COMMENT 'citizen_id'
  , position_id int COMMENT 'position_id'
  , examination_id int COMMENT 'examination_id'
  , school_id int NOT NULL COMMENT 'school_id'
  , district_id int NOT NULL COMMENT 'district_id'
  , branch_id int NOT NULL COMMENT 'branch_id'
  , headquarter_id int NOT NULL COMMENT 'headquarter_id'
  , ward_id int NOT NULL COMMENT 'ward_id'
  , zone_id int NOT NULL COMMENT 'zone_id'
  , createdat datetime COMMENT 'createdat'
  , createdby varchar(123) COMMENT 'createdby'
  , updatedat datetime COMMENT 'updatedat'
  , updatedby varchar(123) COMMENT 'updatedby'
  , CONSTRAINT member_PKC PRIMARY KEY (id,district_id,branch_id,headquarter_id,ward_id,zone_id)
) COMMENT 'member' ;

CREATE INDEX fk_member_citizen1_idx
  ON member(citizen_id);

CREATE INDEX fk_member_position1_idx
  ON member(position_id);

CREATE INDEX fk_member_examination1_idx
  ON member(examination_id);

CREATE INDEX fk_member_school1_idx
  ON member(school_id);

CREATE INDEX fk_member_district1_idx
  ON member(district_id,branch_id,headquarter_id,ward_id,zone_id);

-- member_session
DROP TABLE if exists member_session CASCADE;

CREATE TABLE member_session (
  id int auto_increment NOT NULL COMMENT 'id'
  , member_id int NOT NULL COMMENT 'member_id'
  , note longtext NOT NULL COMMENT 'note'
  , adm_member_id int NOT NULL COMMENT 'adm_member_id'
  , visitedat datetime NOT NULL COMMENT 'visitedat'
  , type varchar(45) NOT NULL COMMENT 'type'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , CONSTRAINT member_session_PKC PRIMARY KEY (id)
) COMMENT 'member_session' ;

-- position
DROP TABLE if exists position CASCADE;

CREATE TABLE position (
  position_name varchar(123) NOT NULL COMMENT 'position_name'
  , id int auto_increment NOT NULL COMMENT 'id'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , CONSTRAINT position_PKC PRIMARY KEY (id)
) COMMENT 'position' ;

ALTER TABLE position ADD UNIQUE position_UNIQUE (position_name) ;

-- role
DROP TABLE if exists role CASCADE;


CREATE TABLE role (
  id int NOT NULL COMMENT 'id'
  , role_name varchar(45) NOT NULL COMMENT 'role_name'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , CONSTRAINT role_PKC PRIMARY KEY (id)
) COMMENT 'role' ;

ALTER TABLE role ADD UNIQUE name_UNIQUE (role_name) ;

-- school
DROP TABLE if exists school CASCADE;


CREATE TABLE school (
  id int auto_increment NOT NULL COMMENT 'id'
  , school_name varchar(123) COMMENT 'school_name'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , CONSTRAINT school_PKC PRIMARY KEY (id)
) COMMENT 'school' ;

ALTER TABLE school ADD UNIQUE name_UNIQUE (school_name) ;

-- timeline
DROP TABLE if exists timeline CASCADE;


CREATE TABLE timeline (
  id int NOT NULL COMMENT 'id'
  , comment varchar(4000) NOT NULL COMMENT 'comment'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat timestamp NOT NULL COMMENT 'createdat'
  , updatedat timestamp NOT NULL COMMENT 'updatedat'
  , member_id int NOT NULL COMMENT 'member_id'
  , district_id int NOT NULL COMMENT 'district_id'
  , branch_id int NOT NULL COMMENT 'branch_id'
  , headquarter_id int NOT NULL COMMENT 'headquarter_id'
  , ward_id int NOT NULL COMMENT 'ward_id'
  , zone_id int NOT NULL COMMENT 'zone_id'
  , img varchar(2083) COMMENT 'img'
  , CONSTRAINT timeline_PKC PRIMARY KEY (id,member_id,district_id,branch_id,headquarter_id,ward_id,zone_id)
) COMMENT 'timeline' ;

CREATE INDEX fk_timeline_member1_idx
  ON timeline(member_id,district_id,branch_id,headquarter_id,ward_id,zone_id);

-- ward
DROP TABLE if exists ward CASCADE;


CREATE TABLE ward (
  id int auto_increment NOT NULL COMMENT 'id'
  , ward_name varchar(45) NOT NULL COMMENT 'ward_name'
  , name_bystudent varchar(45) NOT NULL COMMENT 'name_bystudent'
  , zone_id int NOT NULL COMMENT 'zone_id'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , CONSTRAINT ward_PKC PRIMARY KEY (id,zone_id)
) COMMENT 'ward' ;

CREATE INDEX fk_ward_zone1_idx
  ON ward(zone_id);

-- zone
DROP TABLE if exists zone CASCADE;


CREATE TABLE zone (
  id int auto_increment NOT NULL COMMENT 'id'
  , zone_name varchar(20) NOT NULL COMMENT 'zone_name'
  , updatedby varchar(123) NOT NULL COMMENT 'updatedby'
  , createdby varchar(123) NOT NULL COMMENT 'createdby'
  , updatedat datetime NOT NULL COMMENT 'updatedat'
  , createdat datetime NOT NULL COMMENT 'createdat'
  , CONSTRAINT zone_PKC PRIMARY KEY (id)
) COMMENT 'zone' ;

ALTER TABLE branch
  ADD CONSTRAINT branch_FK1 FOREIGN KEY (headquarter_id,ward_id,zone_id) REFERENCES headquarter(id,ward_id,zone_id);

ALTER TABLE district
  ADD CONSTRAINT district_FK1 FOREIGN KEY (branch_id,headquarter_id,ward_id,zone_id) REFERENCES branch(id,headquarter_id,ward_id,zone_id);

ALTER TABLE member_session
  ADD CONSTRAINT member_session_FK1 FOREIGN KEY (member_id) REFERENCES member(id);
  
ALTER TABLE member_session
  ADD CONSTRAINT adm_member_session_FK1 FOREIGN KEY (adm_member_id) REFERENCES member(id);


ALTER TABLE headquarter
  ADD CONSTRAINT headquarter_FK1 FOREIGN KEY (ward_id,zone_id) REFERENCES ward(id,zone_id);

ALTER TABLE member
  ADD CONSTRAINT member_FK1 FOREIGN KEY (citizen_id) REFERENCES citizen(id);

ALTER TABLE member
  ADD CONSTRAINT member_FK2 FOREIGN KEY (district_id,branch_id,headquarter_id,ward_id,zone_id) REFERENCES district(id,branch_id,headquarter_id,ward_id,zone_id);

ALTER TABLE member
  ADD CONSTRAINT member_FK3 FOREIGN KEY (examination_id) REFERENCES examination(id);

ALTER TABLE `member`
  ADD CONSTRAINT `member_FK4` FOREIGN KEY (`position_id`) REFERENCES `position`(`id`);

ALTER TABLE member
  ADD CONSTRAINT member_FK5 FOREIGN KEY (school_id) REFERENCES school(id);

ALTER TABLE timeline
  ADD CONSTRAINT timeline_FK1 FOREIGN KEY (member_id,district_id,branch_id,headquarter_id,ward_id,zone_id) REFERENCES member(id,district_id,branch_id,headquarter_id,ward_id,zone_id);

ALTER TABLE ward
  ADD CONSTRAINT ward_FK1 FOREIGN KEY (zone_id) REFERENCES zone(id);

