--SELECT datname FROM pg_database;
--DROP DATABASE IF EXISTS hrms;
--CREATE DATABASE hrms;

CREATE TABLE job_positions
(
	id SERIAL PRIMARY KEY NOT NULL,
	job_name VARCHAR(120) NOT NULL
);

INSERT INTO job_positions(job_name) VALUES('Software Developer');
INSERT INTO job_positions(job_name) VALUES('Software Architect');
INSERT INTO job_positions(job_name) VALUES('Frontend Developer');
INSERT INTO job_positions(job_name) VALUES('Backend Developer');
INSERT INTO job_positions(job_name) VALUES('Full Stack Developer');
INSERT INTO job_positions(job_name) VALUES('Java Developer');
INSERT INTO job_positions(job_name) VALUES('C# Developer');
INSERT INTO job_positions(job_name) VALUES('Php Developer');
INSERT INTO job_positions(job_name) VALUES('Asp.Net Developer');

CREATE TABLE users
(
	id SERIAL PRIMARY KEY NOT NULL,
	email VARCHAR(50) NOT NULL,
	password VARCHAR(500) NOT NULL,
	created_date TIMESTAMP DEFAULT CURRENT_DATE
);

CREATE TABLE employees
(
	id SERIAL PRIMARY KEY NOT NULL,
	employee_id INTEGER NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	year_of_birth SMALLINT NOT NULL,
	CONSTRAINT fk_employees_employee_id FOREIGN KEY (employee_id) REFERENCES users (id)
);

CREATE TABLE candidates
(
	id SERIAL PRIMARY KEY NOT NULL,
	candidate_id INTEGER NOT NULL,
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	identity_number VARCHAR(11) NOT NULL,  
	year_of_birth SMALLINT NOT NULL,
	CONSTRAINT fk_candidates_candidate_id FOREIGN KEY (candidate_id) REFERENCES users (id)
);

CREATE TABLE employers
(
	id SERIAL PRIMARY KEY NOT NULL,
	employer_id INTEGER NOT NULL,
	company_name VARCHAR(200) NOT NULL,
	website VARCHAR(200) NOT NULL,
	phone VARCHAR(11) NOT NULL,
	CONSTRAINT fk_employers_employer_id FOREIGN KEY (employer_id) REFERENCES users (id)
);

CREATE TABLE user_verifications
(
	id SERIAL PRIMARY KEY NOT NULL,
	user_id INTEGER NOT NULL,
	verification_code  VARCHAR(10) NOT NULL,
	is_verified_email BOOLEAN DEFAULT FALSE,
	email_verified_date TIMESTAMP NULL,
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
	--CONSTRAINT fk_employers_verifications_employer_id FOREIGN KEY (employer_id) REFERENCES employers (employer_id)
	CONSTRAINT fk_employers_verifications_user_verification_id FOREIGN KEY (user_verification_id) REFERENCES user_verifications (id)
);