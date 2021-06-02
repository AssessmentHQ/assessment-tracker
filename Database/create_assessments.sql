
drop table if exists notes;
drop table if exists grades;
drop table if exists assessments;
drop table if exists categories;
drop table if exists "types";


create table notes (id serial primary key,
					batch_id int not null,
					"content" varchar(250),
					associate_id int not null,
					week_number varchar(3) not null);
				
create table categories(id serial primary key,
					  "name" varchar(50) not null);

create table "types"(id serial primary key,
				   "name" varchar(50) not null,
				   default_weight int not null);
				  
create table assessments(id serial primary key,
						category_id int not null references categories(id) ,
						type_id int not null references "types"(id),
						title varchar(50) not null,
						weight int not null,
						batch_id int not null,
						week_number varchar(3) not null);
					
create table grades (id serial primary key,
					 assessment_id int not null references assessments(id),
					 score int not null,
					 associate_id int not null);

