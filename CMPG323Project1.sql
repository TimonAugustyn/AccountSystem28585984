set echo on

DROP TABLE ACCOUNT CASCADE CONSTRAINTS;
DROP SEQUENCE VIT_RSA_GENERIC_SEQ;

CREATE SEQUENCE VIT_RSA_GENERIC_SEQ
start with 1
increment by 1
minvalue 1
maxvalue 1000
cycle;


create table ACCOUNT(
    MEMBER_ID number(15),
    FNAME varchar2(15),
    LNAME varchar2(15),
    MILES number(15),
    constraint PK_ACCOUNT primary key (MEMBER_ID)
);

COMMIT;

set echo off