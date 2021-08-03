-- USER
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin', 'tinngo@gmail.com', 'tinngo', '275-320-8435', '39827 Kinsman Parkway', 1);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin1', 'tinngo1@gmail.com', 'tinngo1', '139-232-7918', '6 Kennedy Parkway', 3);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin2', 'tinngo2@gmail.com', 'tinngo2', '578-895-6747', '4143 Orin Avenue', 2);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin3', 'tinngo3@gmail.com', 'tinngo3', '219-961-4307', '448 Barby Road', 1);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin4', 'tinngo4@gmail.com', 'tinngo4', '976-825-1648', '434 Mallard Junction', 2);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin5', 'tinngo5@gmail.com', 'tinngo5', '901-688-2293', '678 Badeau Center', 1);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin6', 'tinngo6@gmail.com', 'tinngo6', '190-147-3690', '08 Pawling Way', 2);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin7', 'tinngo7@gmail.com', 'tinngo7', '186-327-4250', '1718 Barnett Drive', 2);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin8', 'tinngo8@gmail.com', 'tinngo8', '593-932-3294', '2278 Fulton Terrace', 3);
insert into crm.user (name, email, password, phone, address, role_id) values ('Tin9', 'tinngo9@gmail.com', 'tinngo9', '618-214-6092', '692 Annamark Hill', 2);
-- TASK
insert into crm.task (name, description, start_date, end_date, project_id, user_id, status_id) values ('Create New Function', 'Phân tích 1', '2021-7-24', '2021-8-8', 1, 1, 1);
insert into crm.task (name, description, start_date, end_date, project_id, user_id, status_id) values ('Update Work', 'Phân tích 2 ', '2021-7-25', '2021-8-7', 2, 3, 2);
insert into crm.task (name, description, start_date, end_date, project_id, user_id, status_id) values ('Test Product', 'Phân tích 3 ', '2021-7-26', '2021-8-9', 3, 6, 3);

-- PROJECT
insert into crm.project(name, description, start_date, end_date, owner) values("Dự án CRM", "Phân tích dự án","2021-7-25", "2021-8-25",1);
insert into crm.project(name, description, start_date, end_date, owner) values("Dự án Jira", "Phân tích alone","2021-7-26", "2021-8-26",3);
insert into crm.project(name, description, start_date, end_date, owner) values("Dự án CRM", "Phân tích teamwork","2021-7-27", "2021-8-27",2);

-- STATUS
 insert into crm.status(name, description) values("Complete", "Done");
 insert into crm.status(name, description) values("Uncomplete", "Undone");
 insert into crm.status(name, description) values("Still Working", "Keep trying");
 
 -- ROLE 
 insert into crm.role(name, description) values("ADMIN", "tin");
 insert into crm.role(name, description) values("LEADER", "hai");
 insert into crm.role(name, description) values("STAFF", "tung");
 
 -- PROJECT_USER
 insert into crm.project_user(project_id, user_id, join_date, role_description) values(1,1,"2021-7-28" ,"tin");
 insert into crm.project_user(project_id, user_id, join_date, role_description) values(3,4,"2021-7-28" ,"tin");
 insert into crm.project_user(project_id, user_id, join_date, role_description) values(2,6,"2021-7-28" ,"tin");