CREATE TABLE portaluser(id SERIAL PRIMARY KEY, email CHAR(255), first_name  CHAR(255), last_name CHAR(255));
insert into portaluser  ( email, first_name, last_name ) values ( 'jd@jaydihenkar.com', 'jay', 'dihenkar' );
select * from portaluser;
