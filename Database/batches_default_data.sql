/*Default Data for Associates*/

insert into associates (email, first_name, last_name) values ('zvv@revature.com', 'Zachary', 'Vander Velden');
insert into associates (email, first_name, last_name) values ('lh@revature.com', 'Lamar', 'Hinchen');
insert into associates (email, first_name, last_name) values ('ml@revature.com', 'Marc', 'Levine');
insert into associates (email, first_name, last_name) values ('jg@revature.com', 'Jessica', 'Gay');
insert into associates (email, first_name, last_name) values ('jl@revature.com', 'Jake', 'Lo');
insert into associates (email, first_name, last_name) values ('gh@revature.com', 'George', 'Hall');
insert into associates (email, first_name, last_name) values ('ad@revature.com', 'Andrew', 'Down');
insert into associates (email, first_name, last_name) values ('re@revature.com', 'Red', 'Elric');
insert into associates (email, first_name, last_name) values ('pl@revature.com', 'Paul', 'Long');
insert into associates (email, first_name, last_name) values ('pu@revature.com', 'Patrick', 'Underrock');
insert into associates (email, first_name, last_name) values ('ku@revature.com', 'Kerry', 'Ulrich');
insert into associates (email, first_name, last_name) values ('cc@revature.com', 'Cory', 'Cass');
insert into associates (email, first_name, last_name) values ('kn@revature.com', 'Kenny', 'Nuget');
insert into associates (email, first_name, last_name) values ('kr@revature.com', 'Karen', 'Richards');
insert into associates (email, first_name, last_name) values ('wr@revature.com', 'Walter', 'Rite');
insert into associates (email, first_name, last_name) values ('bh@revature.com', 'Banana', 'House');
insert into associates (email, first_name, last_name) values ('bl@revature.com', 'Banana', 'Leeds');

/*Default data for batches*/
insert into batches (start_date, end_date, "name", training_track) values ('2020-1-20', '2020-2-20', '20200120', 'Python');
insert into batches (start_date, end_date, "name", training_track) values ('2021-5-27', '2021-7-21', '20210527', 'Data Admin');
/*Currently Empty*/
insert into batches (start_date, end_date, "name", training_track) values ('2020-2-20', '2020-4-24', '20200220', 'Java');
insert into batches (start_date, end_date, "name", training_track) values ('2020-2-20', '2020-4-13', '202002220', 'C#');
insert into batches (start_date, end_date, "name", training_track) values ('2021-2-20', '2021-4-19', '20202222', 'C++');
insert into batches (start_date, end_date, "name", training_track) values ('2021-3-20', '2021-9-20', '20210320', 'iOS Development');
insert into batches (start_date, end_date, "name", training_track) values ('2021-6-20', '2021-8-20', '20210620', 'Android Development');

/*default data for trainers*/
insert into trainers (email, first_name, last_name) values ('rs@revature.com', 'Ryan', 'Schlientz');
insert into trainers (email, first_name, last_name) values ('df@revature.com', 'Dan', 'Felleman');
insert into trainers (email, first_name, last_name) values ('mm@revature.com', 'Mark', 'Mambo');
insert into trainers (email, first_name, last_name) values ('bg@revature.com', 'Bill', 'Gates');
insert into trainers (email, first_name, last_name) values ('cp@revature.com', 'Clippy', 'Paper');

/*add some associates to a batch*/
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (1, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (2, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (3, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (4, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (5, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (6, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (7, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (8, 1, '2020-01-20', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (9, 1, '2021-5-27', '2020-2-20', 'Passed');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (10, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (11, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (12, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (13, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (14, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (15, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (16, 2, '2021-5-27', null, 'Enrolled');
insert into associate_batches (associate_id, batch_id, start_date, end_date, training_status) values (17, 2, '2021-5-27', null, 'Enrolled');


/*Give batches a trainer*/
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (1, 1, '2020-01-20', '2020-2-20', 'Lead');
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (2, 1, '2020-01-20', '2020-2-10', 'Co-Lead');
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (3, 2, '2021-5-27', null, 'Lead');
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (4, 2, '2021-5-27', null, 'Co-Lead');

/*Adding more trainers to batches to try pulling multiple records*/
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (1, 3, '2020-02-20', '2020-4-24', 'Lead');
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (1, 4, '2020-02-20', '2020-4-13', 'Lead');
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (1, 5, '2020-02-20', '2020-4-19', 'Lead');
insert into trainer_batches (trainer_id, batch_id, start_date, end_date, "role") values (1, 6, '2020-03-20', '2020-9-20', 'Lead');
