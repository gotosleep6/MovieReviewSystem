create database movie_review;
use movie_review;
create table movie(
movie_id INT NOT NULL auto_increment primary key,
movie_name varchar(100) Not Null,
summary varchar(500),
cast varchar(200),
genre varchar(200)
);




create table User(
user_id int auto_increment Not null primary key,
user_name varchar(100) not null,
email_id varchar(100) not null unique
);

create table reviews(
review_id int NOT NULL auto_increment primary key,
review varchar(500),
movie_id int not null,
user_id int not null,
Constraint FK_movieid FOREIGN KEY (movie_id) References movie(movie_id),
Constraint FK_userid FOREIGN KEY (user_id) References User(user_id)
);

create table rating(
rating_id int NOT NULL auto_increment primary key,
rating int not null,
movie_id int,
user_id int,
Constraint FK_rating_movieid FOREIGN KEY (movie_id) References movie(movie_id),
Constraint FK_rating_userid FOREIGN KEY (user_id) References User(user_id)
)

select * from movie;
select * from User;
select * from reviews;
select * from rating;




