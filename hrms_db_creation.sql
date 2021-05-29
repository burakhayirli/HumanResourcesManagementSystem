--SELECT datname FROM pg_database;
--DROP DATABASE IF EXISTS hrms;
--CREATE DATABASE hrms;
/*
BEGIN;
SELECT pg_terminate_backend(pg_stat_activity.pid)
FROM pg_stat_activity
WHERE pg_stat_activity.datname = 'hrms'
  AND pid <> pg_backend_pid();
 COMMIT;

DROP DATABASE IF EXISTS hrms;
*/
CREATE DATABASE hrms;
SET search_path TO hrms;

CREATE TABLE users
(
	id SERIAL PRIMARY KEY NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(500) NOT NULL,
	restricted BOOLEAN NOT NULL DEFAULT FALSE,  
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	created_by INTEGER,
	updated_at TIMESTAMP NULL,
	updated_by INTEGER NULL,
	status BOOLEAN NOT NULL DEFAULT TRUE
);
--employees
INSERT INTO users(email,password) VALUES('burak@burak.com','12345');
INSERT INTO users(email,password) VALUES('engin@engin.com','12345');

--candidates
INSERT INTO users(email,password) VALUES('burak2@burak.com','12345');
INSERT INTO users(email,password) VALUES('engin2@engin.com','12345');

--employeers
INSERT INTO users(email,password) VALUES('abcfirmasi@burak.com','12345');
INSERT INTO users(email,password) VALUES('bcdfirmasi@engin.com','12345');

CREATE TABLE job_positions
(
	id SERIAL PRIMARY KEY NOT NULL,
	job_name VARCHAR(120) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	created_by INTEGER,
	updated_at TIMESTAMP NULL,
	updated_by INTEGER NULL,
	status BOOLEAN DEFAULT TRUE,
	CONSTRAINT fk_job_positions_created_by FOREIGN KEY (created_by) REFERENCES users (id),
	CONSTRAINT fk_job_positions_updated_by FOREIGN KEY (updated_by) REFERENCES users (id)
);

INSERT INTO job_positions(job_name,created_by) VALUES('Software Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Software Architect',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Frontend Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Backend Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Full Stack Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Java Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('C# Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Php Developer',1);
INSERT INTO job_positions(job_name,created_by) VALUES('Asp.Net Developer',1);

CREATE TABLE employees
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_id INTEGER NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	year_of_birth SMALLINT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	created_by INTEGER,
	updated_at TIMESTAMP NULL,
	updated_by INTEGER NULL,
	CONSTRAINT fk_employees_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO employees(user_id,first_name,last_name,year_of_birth) VALUES(1,'Burak','HAYIRLI',1984);
INSERT INTO employees(user_id,first_name,last_name,year_of_birth,created_by) VALUES(2,'Engin','DEMİROĞ',1986,1);

CREATE TABLE candidates
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_id INTEGER NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	identity_number VARCHAR(11) NOT NULL,  
	year_of_birth SMALLINT NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	created_by INTEGER,
	updated_at TIMESTAMP NULL,
	updated_by INTEGER NULL,
	CONSTRAINT fk_candidates_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);
INSERT INTO candidates(user_id,first_name,last_name,identity_number,year_of_birth) VALUES(3,'Burak','HAYIRLI','12123123',1984);
INSERT INTO candidates(user_id,first_name,last_name,identity_number,year_of_birth,created_by) VALUES(4,'Engin','DEMİROĞ','2132332',1986,1);

CREATE TABLE employers
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_id INTEGER NOT NULL,
	company_name VARCHAR(200) NOT NULL,
	website VARCHAR(200) NOT NULL,
	phone VARCHAR(11) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	created_by INTEGER,
	updated_at TIMESTAMP NULL,
	updated_by INTEGER NULL,
	CONSTRAINT fk_employers_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);
INSERT INTO employers(user_id,company_name,website,phone,created_by) VALUES(5,'ABC FİRMASI','abcfirmasi.com','5000000',1);
INSERT INTO employers(user_id,company_name,website,phone,created_by) VALUES(6,'DEF FİRMASI','deffirmasi.com','5000000',2);

CREATE TABLE user_verifications
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_id INTEGER NOT NULL,
	verification_code  VARCHAR(10) NOT NULL,
	is_verified_email BOOLEAN DEFAULT FALSE,
	email_verified_date TIMESTAMP NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	created_by INTEGER,
	updated_at TIMESTAMP NULL,
	updated_by INTEGER NULL,
	CONSTRAINT fk_users_verifications_user_id FOREIGN KEY (user_id) REFERENCES users (id)
);

CREATE TABLE candidates_verifications
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_verification_id INTEGER NOT NULL,
	CONSTRAINT fk_candidates_verifications_user_verification_id FOREIGN KEY (user_verification_id) REFERENCES user_verifications (id)
);

CREATE TABLE employers_verifications
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_verification_id INTEGER NOT NULL,
	is_verified_by_employee BOOLEAN DEFAULT FALSE,
	verified_by_employee_id INTEGER NULL,
	employee_verified_date TIMESTAMP NULL,
	CONSTRAINT fk_employers_verifications_user_verification_id FOREIGN KEY (user_verification_id) REFERENCES user_verifications (id)
);