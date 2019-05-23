DROP TABLE IF EXISTS printer;
DROP TABLE IF EXISTS stage;
DROP TABLE IF EXISTS printertype;
DROP TABLE IF EXISTS printertypevariant;
/*
-- Script for MySQL --
create table stage
(
  stageid   int auto_increment
    primary key,
  stagename varchar(45) not null
);

create table printertype
(
  printer_typeid int auto_increment
    primary key,
  printer_name   varchar(255) null
);

create table printer
(
  rmaid           int          not null
    primary key,
  approved        bit          null,
  bulkink         bit          null,
  closed          varchar(255) null,
  company_name    varchar(255) null,
  diagnosis       varchar(255) null,
  faulty_sn       varchar(255) null,
  issue_category  varchar(255) null,
  issue_date      date         null,
  notes           varchar(255) null,
  replacement_sn  varchar(255) null,
  result          varchar(255) null,
  returned_date   date         null,
  printertid      int              ,
  printer_stageid int              ,

  FOREIGN KEY (printertid) REFERENCES printertype(printer_typeid) ON DELETE CASCADE,
  FOREIGN KEY (printer_stageid) REFERENCES stage(stageid) ON DELETE CASCADE
);*/

-- Script for Postgres --
CREATE TABLE stage
(
    stageid serial,
    stagename varchar(45) not null,
    PRIMARY KEY (stageid)
);


CREATE TABLE printertypevariant
(
    printertypevariantid serial,
    printertypevariant VARCHAR(255) NOT NULL,
    PRIMARY KEY (printertypevariantid)
);

CREATE TABLE printertype
(
    printertypeid serial,
    printername varchar(255) NOT NULL,
    printervariant INT NULL,
    PRIMARY KEY (printertypeid),
    FOREIGN KEY (printervariant) REFERENCES printertypevariant(printertypevariantid)
);

CREATE TABLE printer
(
  rmaid           int          not null,
  company_name    varchar(255) null,
  closed          varchar(255) null,
  issue_date      date         null,
  faulty_sn       varchar(255) null,
  replacement_sn  varchar(255) null,
  returned_date   date         null,
  notes           varchar(255) null,
  diagnosis       varchar(255) null,
  bulkink         Boolean      null,
  issue_category  varchar(255) null,
  result          varchar(255) null,
  approved        Boolean      null,
  printertid      int          not null,
  printer_stageid int          not null,
  PRIMARY KEY (rmaid),
  FOREIGN KEY (printertid) REFERENCES printertype(PrinterTypeID) ON DELETE CASCADE,
  FOREIGN KEY (printer_stageid) REFERENCES stage(stageid) ON DELETE CASCADE
)
