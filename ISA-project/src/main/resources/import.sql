insert into company (name, address, description,average_grade) values ('HealthPro', 'Cirpanova', 'medicine', 3.6);
insert into company (name, address, description,average_grade) values ('Medical', 'Takovska', 'oprema', 2.6);
insert into company (name, address, description,average_grade) values ('Supplies', 'Futoska', 'oprema', 5.0);
insert into company (name, address, description,average_grade) values ('Medicine', 'Bulevar', 'medical supplies', 2.2);
insert into company (name, address, description,average_grade) values ('MediCare', 'Jevrejska', 'description', 3.4);
insert into company (name, address, description,average_grade) values ('New Med', 'Danila Kisa', 'new description', 4.1);


insert into users (name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Marko', 'Markovic', 'email@gmail.com', 'pass1', '2017-10-01 21:58:58.508-07' ,'BG', 'Srbija', '12576543', 'profession1', 'info1', false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Filip', 'Filipovic', 'email2@gmail.com', 'pass2', '2017-10-01 21:58:58.508-07','NS', 'Srbija', '12576543', 'profession2', 'info2', false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Jovana', 'Jovanovic', 'email3@gmail.com', 'pass3', '2017-10-01 21:58:58.508-07','KG', 'Srbija', '1253254', 'profession3', 'info3', false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Iva', 'Ivanovic', 'email4@gmail.com', 'pass4', '2017-10-01 21:58:58.508-07' ,'SO', 'Srbija', '12576543', 'profession4', 'info4',false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Nina', 'Ba', 'projekatisa2023@gmail.com', '$2a$10$lhYgvOwC1Q.fxzQBkwVNI.xqwKaoQiY6Gum5fzeN9jsuYStzORNGi', '2017-10-01 21:58:58.508-07' ,'NS', 'Srbija', '1234', 'pulmolog', 'info5',true);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Mila', 'Milic', 'nina.batranovic3@gmail.com', '$2a$10$lhYgvOwC1Q.fxzQBkwVNI.xqwKaoQiY6Gum5fzeN9jsuYStzORNGi', '2016-10-02 01:58:57.508-07' ,'NS', 'Srbija', '42156', 'zubar', 'info',true);

insert into equipments(name, equipment_type, description, quantity, reserved_quantity, version, price) values ('X-Ray Machine', 'Medical Imaging', 'Advanced X-ray equipment', 3, 0, 0, 100);
insert into equipments(name, equipment_type, description, quantity,reserved_quantity, version, price) values ('Hospital Bed', 'Furniture', 'Specialized bed for patients', 4, 0, 0, 200);
insert into equipments(name, equipment_type, description, quantity,reserved_quantity, version, price) values ('Surgical Instruments', 'Medical Tools', 'Various surgical instruments', 25, 0, 0, 300);
insert into equipments(name, equipment_type, description, quantity,reserved_quantity, version, price) values ('MRI Scanner', 'Medical Imaging', 'Magnetic Resonance Imaging machine', 3, 0, 0,100);
insert into equipments(name, equipment_type, description, quantity,reserved_quantity, version, price) values ('IV Pumps', 'Equipment', 'Infusion pumps', 30, 0, 0, 800);

insert into company_admins(company_id, user_id) values (1, 1);
insert into company_admins(company_id, user_id) values (1, 2);

INSERT INTO appointments(start_date, duration, status, admin_id, version) VALUES ('2024-04-04 10:00:00', 100, 0, 2, 0);
INSERT INTO appointments(start_date, duration, status, admin_id, version) VALUES ('2024-05-05 11:00:00', 90, 0, 1, 0);
INSERT INTO appointments(start_date, duration, status, admin_id, version) VALUES ('2024-02-02 11:00:00', 60, 0, 1, 0);
INSERT INTO appointments(start_date, duration, status, admin_id, version) VALUES ('2024-02-02 11:30:00', 100, 0, 2, 0);
INSERT INTO appointments(start_date, duration, status, admin_id, version) VALUES ('2024-03-03 15:10:00', 90, 0, 1, 0);
INSERT INTO appointments(start_date, duration, status, admin_id, version) VALUES ('2024-03-03 15:20:00', 60, 0, 2, 0);

insert into company_appointment(company_id, appointment_id) values (2,1);
insert into company_appointment(company_id, appointment_id) values (1,2);
insert into company_appointment(company_id, appointment_id) values (1,3);
insert into company_appointment(company_id, appointment_id) values (2,4);
insert into company_appointment(company_id, appointment_id) values (1,5);
insert into company_appointment(company_id, appointment_id) values (1,6);

insert into company_equipment(company_id, equipment_id) values (1, 1);
insert into company_equipment(company_id, equipment_id) values (1, 2);
insert into company_equipment(company_id, equipment_id) values (1, 3);
insert into company_equipment(company_id, equipment_id) values (2, 4);
insert into company_equipment(company_id, equipment_id) values (2, 5);
	
INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_COMPANY_ADMIN'); 
INSERT INTO ROLE (name) VALUES ('ROLE_SYSTEM_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 2); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (5, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (6, 1);

INSERT INTO registered_user(penal_points, user_id, user_category) values (0, 1, 0)
INSERT INTO registered_user(penal_points, user_id, user_category) values (5, 2, 0)
INSERT INTO registered_user(penal_points, user_id, user_category) values (1, 3, 0)
INSERT INTO registered_user(penal_points, user_id, user_category) values (2, 4, 0)
INSERT INTO registered_user(penal_points, user_id, user_category) values (1, 5, 0)
INSERT INTO registered_user(penal_points, user_id, user_category) values (1, 6, 0)