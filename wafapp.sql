create table cidr_block_pol(
  cidr_pol_no int primary key auto_increment,
  risk_level varchar(20) not null,
  block_cidr varchar(20) not null,
  expiration_date datetime default null,
  note text null
);

create table web_server(
  web_no int primary key auto_increment,
  web_ip varchar(20) not null,
  hostname varchar(20) not null,
  constraint web_uk unique (web_ip)
);

create table fqdn_block_pol(
  fqdn_pol_no int primary key auto_increment,
  risk_level varchar(20) not null,
  block_url varchar(50) not null,
  sub_dir varchar(100) null,
  expiration_date datetime default null,
  note text null
);