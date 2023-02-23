CREATE DATABASE crud_user;

create table user (
  id  BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  surnames varchar (150),
  email varchar (100),
  document_type varchar(20),
  document_number varchar(25),
  birthday date,
  active boolean
)


INSERT INTO crud_user.user (name, surnames, email, document_type, document_number, birthday, active)
VALUES ('wendy', 'villazana astucuri', 'wendyvillazana@gmail.com', 'dni', '46757406', '1991-01-17', 1);


