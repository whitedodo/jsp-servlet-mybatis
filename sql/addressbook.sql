  CREATE TABLE "C##RABBIT2"."ADDRESSBOOK" 
   (	"NUM" NUMBER(*,0) NOT NULL ENABLE, 
	"NAME" NVARCHAR2(20), 
	"ADDRESS" NVARCHAR2(100), 
	"BIRTHDATE" DATE, 
	 CONSTRAINT "ADDRESSBOOK_PK" PRIMARY KEY ("NUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  CREATE OR REPLACE EDITIONABLE TRIGGER "C##RABBIT2"."ADDRESSBOOK_TRG" 
BEFORE INSERT ON ADDRESSBOOK 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.NUM IS NULL THEN
      SELECT ADDRESSBOOK_SEQ.NEXTVAL INTO :NEW.NUM FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "C##RABBIT2"."ADDRESSBOOK_TRG" ENABLE;
