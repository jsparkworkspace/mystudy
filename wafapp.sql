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

---------------------------------------------------------------------------------------------------------------------

drop table if exists x_member;
drop table if exists x_study;
drop table if exists x_study_member;
drop table if exists x_curriculum;

create table x_member(
  mno int primary key,

);

create table x_study (

);

create table x_study_member(

);

alter table x_study_member
  add constraint primary key (mno, sno),
  add constraint x_study_member_mno_fk foreign key (mno) references x_member(mno),
  add constraint x_study_member_sno_fk foreign key (sno) references x_study(sno);

-- 커리큘럼 테이블
create table x_curriculum (
  cno int primary key,
  title varchar(255) not null,
  sno int,
  mno int
);

-- 커리큘럼 외부키 설정
alter table x_curriculum
  add constraint x_curriculum_sno_fk foreign key (sno) references x_study (sno),
  add constraint x_curriculum_mno_fk foreign key (sno, mno) references x_study_member (sno, mno);
 
-- 회원, 과목, 스터디 데이터 insert
insert into x_curriculum(cno, title, sno) values (11, '변수', 101);
insert into x_curriculum(cno, title, sno) values (12, '조건문', 101);
insert into x_curriculum(cno, title, sno) values (13, '반복문', 101);
insert into x_curriculum(cno, title, sno) values (14, '연산자', 101);

-- 스터디에 속하지 않는 회원은 파트 할당 불가
update x_curriculum set
  mno = 4
where cno = 11;