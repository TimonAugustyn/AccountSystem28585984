set echo on

DROP TABLE DEMO_ACCOUNT_TRANSACTION CASCADE CONSTRAINTS;
DROP TABLE DEMO_ACCOUNT_TYPE CASCADE CONSTRAINTS;
DROP TABLE ACCOUNT CASCADE CONSTRAINTS;
DROP SEQUENCE VIT_RSA_GENERIC_SEQ;

create table DEMO_ACCOUNT_TYPE (
    ACCOUNT_TYPE_ID number(15),
    MNEMONIC varchar2(50),
    ACCOUNT_TYPE_NAME varchar2(50),
    CREATION_DATE DATE,
    constraint PK_TYPE primary key (ACCOUNT_TYPE_ID)
);

CREATE SEQUENCE VIT_RSA_GENERIC_SEQ
start with 1
increment by 1
minvalue 1
maxvalue 1000
cycle;

create table DEMO_ACCOUNT_TRANSACTION (
    TX_ID number(15),
    ACCOUNT_TYPE_ID number(15),
    MEMBER_ID number(15),
    AMOUNT number(4),
    TX_DATE DATE,
    constraint PK_TRAN primary key (TX_ID),
    constraint fk_ACCOUNT_TYPE_ID foreign key (ACCOUNT_TYPE_ID)
    references DEMO_ACCOUNT_TYPE (ACCOUNT_TYPE_ID) on delete set NULL
);

create table ACCOUNT(
    MEMBER_ID number(15),
    FNAME varchar2(15),
    LNAME varchar2(15),
    MILES number(15),
    constraint PK_ACCOUNT primary key (MEMBER_ID)
);


COMMIT;

set echo off