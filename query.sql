create table users(
      username varchar(50) not null primary key,
      password varchar(50) not null,
      enabled Number(1) not null
	  );

create table authorities (
  username varchar(50) not null,
      authority varchar(50) not null
      );
	  
ALTER TABLE authorities
ADD constraint fk_authorities_users foreign key(username) references users(username);

create unique index ix_auth_username on authorities (username,authority);
