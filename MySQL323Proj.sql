set echo on

DROP TABLE DEMO_ACCOUNT_TRANSACTION CASCADE CONSTRAINTS;
DROP TABLE DEMO_ACCOUNT_TYPE CASCADE CONSTRAINTS;
DROP SEQUENCE VIT_RSA_GENERIC_SEQ;

create table DEMO_ACCOUNT_TYPE (
    ACCOUNT_TYPE_ID number(15) not null,
    MNEMONIC varchar2(50) not null,
    ACCOUNT_TYPE_NAME varchar2(50) not null,
    CREATION_DATE DATE not null,
    constraint PK_TYPE primary key (ACCOUNT_TYPE_ID)
);

CREATE SEQUENCE VIT_RSA_GENERIC_SEQ
start with 1
increment by 1
minvalue 1
maxvalue 1000
cycle;

create table DEMO_ACCOUNT_TRANSACTION (
    TX_ID number(15) not null,
    ACCOUNT_TYPE_ID number(15) not null,
    MEMBER_ID number(15) not null,
    AMOUNT number(4) not null,
    TX_DATE DATE not null,
    constraint PK_TRAN primary key (TX_ID),
    constraint fk_ACCOUNT_TYPE_ID foreign key (ACCOUNT_TYPE_ID)
    references DEMO_ACCOUNT_TYPE (ACCOUNT_TYPE_ID) on delete set NULL
);

COMMIT;

set echo off