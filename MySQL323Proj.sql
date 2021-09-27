create table Member (
  member_ID int(8) not null,
  member_fname varchar(50) not null,
  member_lname varchar(50) not null,
    constraint pk_Member primary key (member_ID)
);

create table Active_Rewards (
  member_ID int(8) not null,
  plays int(8) not null,
  driving_progress int(3) not null,
  spending_progress int(3) not null,
  fitness_progress int(3) not null,
    constraint pk_AR primary key (member_ID, plays),
    constraint fk_AR foreign key (member_ID)
    references Member (member_ID) on delete set NULL
);

create table Gameboard (
  member_ID int(8) not null,
  plays int(8) not null,
  Tile_Amounts varchar(50) not null,
  Miles_Recieved int(8) not null,
    constraint pk_Gameboard primary key (member_ID, Miles_Recieved),
    constraint fk_Gameboard foreign key (member_ID)
    references Member (member_ID) on delete set NULL
);

create table Vouchers (
  voucher_ID int(8) not null,
  voucher_Cat varchar(50) not null,
  voucher_Price varchar(50) not null,
  voucher_Partner varchar(50) not null,
  voucher_Name varchar(50) not null,
    constraint pk_Vouchers primary key (voucher_ID)
);

create table Account (
  account_ID int(8) not null,
  member_ID int(8) not null,
  miles int(8) not null,
  Miles_Recieved int(8) not null,
  plays int(8) not null,
  voucher_ID int(8) not null,
    constraint pk_Account primary key (account_ID, member_ID, plays),
    constraint fk_Account_member foreign key (member_ID)
    references Member (member_ID) on delete set NULL,
    constraint fk_Account_plays foreign key (member_ID, plays)
    references Active_Rewards (member_ID, plays) on delete set NULL,
    constraint fk_Account_miles foreign key (member_ID, Miles_Recieved)
    references Gameboard (member_ID, Miles_Recieved) on delete set NULL,
    constraint fk_Account_voucher foreign key (voucher_ID)
    references Vouchers (voucher_ID) on delete set NULL
);