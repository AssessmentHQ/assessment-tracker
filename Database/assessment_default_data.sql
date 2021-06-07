

/*default data for notes*/
insert into notes (batch_id, "content", associate_id, week) values (1, 'Cool note', 1, 1);
insert into notes (batch_id, "content", associate_id, week) values (1, 'Cool note 2', 2, 1);
insert into notes (batch_id, "content", associate_id, week) values (1, 'Cool note 3', 2, 1);
insert into notes (batch_id, "content", associate_id, week) values (1, 'Cool note 4', 2, 1);
insert into notes (batch_id, "content", associate_id, week) values (2, 'Cooler note', 10, 1);
insert into notes (batch_id, "content", associate_id, week) values (2, 'Coolest note', 10, 1);
insert into notes (batch_id, "content", associate_id, week) values (2, 'Meh note', 11, 1);


/*default data for types*/
insert into types ("name", default_weight) values ('QC', 100);
insert into types ("name", default_weight) values ('Quiz', 50);
insert into types ("name", default_weight) values ('One-on-Ones', 75);
insert into types ("name", default_weight) values ('Project', 40);

/*default data for categories*/
insert into categories ("name") values ('Python');
insert into categories ("name") values ('SQL');
insert into categories ("name") values ('DevOps');
insert into categories ("name") values ('AWS');
insert into categories ("name") values ('Java');
insert into categories ("name") values ('HTTP');
insert into categories ("name") values ('REST');

/*default data for assessments*/
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (1, 2, 'Python intro quiz', 75, 1, 2);
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (1, 2, 'Python advanced quiz', 100, 1, 3);
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (2, 1, 'SQL QC', 75, 1, 3);
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (3, 1, 'DevOps QC', 75, 1, 4);
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (4, 1, 'AWS QC', 75, 1, 5);
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (5, 3, 'HTTP 1-1', 75, 1, 3);
insert into assessments (category_id, type_id, title, weight, batch_id, week) values (5, 4, 'Project 0', 75, 1, 3);

/*default data for grades*/
insert into grades (assessment_id, score, associate_id, date_submitted) values (1, 99, 1, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (2, 1, 1, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (3, 11, 1, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (4, 24, 1, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (1, 100, 2, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (2, 100, 2, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (3, 100, 2, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (4, 100, 2, '2020-9-20');
insert into grades (assessment_id, score, associate_id, date_submitted) values (1, 100, 3, '2020-9-20');
