CREATE DATABASE IF NOT EXISTS crm;
USE crm;
CREATE TABLE role (
	id int auto_increment,
    name varchar(100),
    description varchar(255),
    primary key(id)
);
CREATE TABLE user(
	id int auto_increment,
    email varchar(100) unique,
    password varchar(255),
    name varchar(255),
    address varchar(255),
    phone varchar(50),
    role_id int,
    primary key(id)
);

CREATE TABLE project(
	id int auto_increment,
    name varchar(255),
    description varchar(255),
    start_date date,
    end_date date ,
    owner integer(10),
    primary key(id)
);

CREATE TABLE project_user(
	project_id integer(10),
    user_id integer(10),
    join_date date,
    role_description varchar(255),
    primary key(project_id,  user_id)
);
CREATE TABLE task(
	id int auto_increment,
    name varchar(255),
    description varchar(255),
    start_date date,
    end_date date,
    project_id integer(10),
    user_id integer(10),
    status_id integer(10),
    primary key(id)
);
CREATE TABLE status(
	id int auto_increment,
    name varchar(255),
    description varchar(255),
    primary key(id)
);
ALTER TABLE user 
	ADD constraint FK_USER_ROLE
		FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE project
	ADD CONSTRAINT FK_PROJECT_USER_OWNER
		FOREIGN KEY (owner) REFERENCES user(id);
ALTER TABLE project_user
	ADD CONSTRAINT FK_PROJECT_USER_PROJECT_USER_LIST
		FOREIGN KEY (project_id) REFERENCES project(id),
	ADD CONSTRAINT FK_PROJECT_USER_USER_JOIN_LIST
		FOREIGN KEY (user_id) REFERENCES user(id);
	
	
ALTER TABLE task
	ADD CONSTRAINT FK_TASK_USER
		FOREIGN KEY (user_id) REFERENCES user(id),
	ADD CONSTRAINT FK_TASK_PROJECT
		FOREIGN KEY (project_id) REFERENCES project(id),
	ADD CONSTRAINT FK_TASK_STATUS
		FOREIGN KEY (status_id) REFERENCES status(id);