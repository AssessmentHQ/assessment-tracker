alter table if exists trainer_batches
drop constraint if exists fk_trainer_batch;

alter table if exists associate_batches
drop constraint if exists fk_associate_batch;

alter table if exists trainer_batches
drop constraint if exists fk_trainer;

alter table if exists associate_batches
drop constraint if exists fk_associate;

drop table if exists trainers;
drop table if exists trainer_batches;
drop table if exists batches;
drop table if exists associate_batches;
drop table if exists associates;


create table trainers ( id serial primary key,
					   email varchar(50) not null,
					   first_name varchar(50) not null,
					   last_name varchar(50) not null);
					
								
create table trainer_batches (trainer_id int not null,
					        batch_id int not null,
					        "start_date" date not null,
					        end_date date, 
					        "role" varchar(50) not null);					
					       
create table "batches" (id serial primary key,
				    "start_date" date not null,
					end_date date not null,
				    "name" varchar (50) not null,
				    training_track varchar(50));
				   
				   
create table associate_batches (associate_id int not null,
 							  batch_id int not null,
				   			  "start_date" date not null,
					          end_date date,
				              training_status varchar(50));
				             
				             
create table associates (id serial primary key,
					     email varchar(50) not null,
					     first_name varchar(50) not null,
					     last_name varchar(50) not null);
					


alter table associate_batches
add constraint fk_associate_batch
foreign key (batch_id)
references batches(id)
on delete cascade;

alter table trainer_batches
add constraint fk_trainer_batch
foreign key (batch_id)
references batches(id)
on delete cascade;

alter table trainer_batches
add constraint fk_trainer
foreign key (trainer_id)
references trainers(id)
on delete cascade;

alter table associate_batches
add constraint fk_associate
foreign key (associate_id)
references associates(id)
on delete cascade;