--------------------------------------------------------
--  File created - Tuesday-March-03-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence PRODUCTS_ID
--------------------------------------------------------

   CREATE SEQUENCE  "ADMIN"."PRODUCTS_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."ORDERS" 
   (	"ID" NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"CUSTOMER_FIRST_NAME" VARCHAR2(30 BYTE), 
	"CUSTOMER_LAST_NAME" VARCHAR2(30 BYTE), 
	"TOTAL_PRICE" NUMBER, 
	"ORDER_STATUS" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ORDER_ITEMS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."ORDER_ITEMS" 
   (	"ID" NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"PRODUCT_ID" NUMBER, 
	"QUANTITY" NUMBER, 
	"ORDER_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PRODUCTS
--------------------------------------------------------

  CREATE TABLE "ADMIN"."PRODUCTS" 
   (	"ID" NUMBER GENERATED BY DEFAULT ON NULL AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE , 
	"TITLE" VARCHAR2(100 BYTE), 
	"DESCRIPTION" VARCHAR2(400 BYTE), 
	"PRICE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"   NO INMEMORY ;
REM INSERTING into ADMIN.ORDERS
SET DEFINE OFF;
REM INSERTING into ADMIN.ORDER_ITEMS
SET DEFINE OFF;
REM INSERTING into ADMIN.PRODUCTS
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index ORDER_ITEMS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."ORDER_ITEMS_PK" ON "ADMIN"."ORDER_ITEMS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index ORSERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."ORSERS_PK" ON "ADMIN"."ORDERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PRODUCTS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ADMIN"."PRODUCTS_PK" ON "ADMIN"."PRODUCTS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ORDERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERS" MODIFY ("CUSTOMER_FIRST_NAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERS" MODIFY ("CUSTOMER_LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERS" MODIFY ("TOTAL_PRICE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERS" MODIFY ("ORDER_STATUS" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDERS" ADD CONSTRAINT "ORSERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."PRODUCTS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PRODUCTS" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PRODUCTS" MODIFY ("DESCRIPTION" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PRODUCTS" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."PRODUCTS" ADD CONSTRAINT "PRODUCTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ORDER_ITEMS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ORDER_ITEMS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDER_ITEMS" MODIFY ("PRODUCT_ID" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDER_ITEMS" MODIFY ("QUANTITY" NOT NULL ENABLE);
  ALTER TABLE "ADMIN"."ORDER_ITEMS" ADD CONSTRAINT "ORDER_ITEMS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "ADMIN"."ORDER_ITEMS" MODIFY ("ORDER_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ORDER_ITEMS
--------------------------------------------------------

  ALTER TABLE "ADMIN"."ORDER_ITEMS" ADD CONSTRAINT "ORDER_ITEMS_FK1" FOREIGN KEY ("PRODUCT_ID")
	  REFERENCES "ADMIN"."PRODUCTS" ("ID") ENABLE;
  ALTER TABLE "ADMIN"."ORDER_ITEMS" ADD CONSTRAINT "ORDER_ITEMS_FK2" FOREIGN KEY ("ORDER_ID")
	  REFERENCES "ADMIN"."ORDERS" ("ID") ENABLE;
