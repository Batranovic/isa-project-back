insert into company (name, address, description,average_grade) values ('Company', 'Cirpanova', 'medicine', 3.6);
insert into company (name, address, description,average_grade) values ('Medical', 'Takovska', 'oprema', 2.6);
insert into company (name, address, description,average_grade) values ('Supplies', 'Futoska', 'oprema', 5.0);
insert into company (name, address, description,average_grade) values ('Medicine', 'Bulevar', 'medical supplies', 2.2);
insert into company (name, address, description,average_grade) values ('Company2', 'Jevrejska', 'description', 3.4);
insert into company (name, address, description,average_grade) values ('New Med', 'Danila Kisa', 'new description', 4.1);


insert into users (name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('ime1', 'prz1', 'email1', 'pass1', '2017-10-01 21:58:58.508-07' ,'city1', 'country1', 'phone1', 'profession1', 'info1', false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('ime2', 'prz2', 'email2', 'pass2', '2017-10-01 21:58:58.508-07','city2', 'country2', 'phone2', 'profession2', 'info2', false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('ime3', 'prz3', 'email3', 'pass3', '2017-10-01 21:58:58.508-07','city3', 'country3', 'phone3', 'profession3', 'info3', false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('ime4', 'prz4', 'email4', 'pass4', '2017-10-01 21:58:58.508-07' ,'city4', 'country4', 'phone4', 'profession4', 'info4',false);
insert into users(name, surname, email, password, last_password_reset_date, city, country, phone_number, profession, company_information, is_active) values ('Nina', 'Ba', 'projekatisa2023@gmail.com', '$2a$10$lhYgvOwC1Q.fxzQBkwVNI.xqwKaoQiY6Gum5fzeN9jsuYStzORNGi', '2017-10-01 21:58:58.508-07' ,'NS', 'Srbija', '1234', 'programer', 'info5',true);

insert into equipments(name, equipment_type, description, quantity) values ('X-Ray Machine', 'Medical Imaging', 'Advanced X-ray equipment', 5);
insert into equipments(name, equipment_type, description, quantity) values ('Hospital Bed', 'Furniture', 'Specialized bed for patients', 15);
insert into equipments(name, equipment_type, description, quantity) values ('Surgical Instruments', 'Medical Tools', 'Various surgical instruments', 25);
insert into equipments(name, equipment_type, description, quantity) values ('MRI Scanner', 'Medical Imaging', 'Magnetic Resonance Imaging machine', 3);


INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN'); --dodati ostale potrebne usere

INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 1); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 1);
INSERT INTO USER_ROLE (user_id, role_id) VALUES (5, 1);