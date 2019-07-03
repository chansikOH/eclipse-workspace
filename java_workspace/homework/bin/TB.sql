
/* Drop Tables */

DROP TABLE TB_ORDER_ITEMS CASCADE CONSTRAINTS;
DROP TABLE TB_GOODS CASCADE CONSTRAINTS;
DROP TABLE TB_CATEGORIES CASCADE CONSTRAINTS;
DROP TABLE TB_COMPANIES CASCADE CONSTRAINTS;
DROP TABLE TB_ORDERS CASCADE CONSTRAINTS;
DROP TABLE TB_CUSTOMER CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE TB_CATEGORIES
(
	CATEGORY_NO number(3,0) NOT NULL,
	CATEGORY_NAME varchar2(100) NOT NULL,
	PARENT_CATEGORY_NO number(3,0) NOT NULL,
	PRIMARY KEY (CATEGORY_NO)
);


CREATE TABLE TB_COMPANIES
(
	COMPANY_NO number(3,0) NOT NULL,
	COMPANY_NAME varchar2(100),
	COMPANY_TEL varchar2(20),
	COMPANY_CREATE_DATE date,
	PRIMARY KEY (COMPANY_NO)
);


CREATE TABLE TB_CUSTOMER
(
	CUSTOMER_NO number(5,0) NOT NULL,
	CUSTOMER_NAME varchar2(50) NOT NULL,
	CUSTOMER_ID varchar2(20) UNIQUE,
	CUSTOMER_PASSWORD varchar2(20) NOT NULL,
	CUSTOMER_GENDER char(1),
	CUSTOMER_EMAIL varchar2(256) UNIQUE,
	CUSTOMER_PHONE varchar2(20),
	CUSTOMER_ZIPCODE char(5),
	CUSTOMER_ADDRESS varchar2(200),
	CUSTOMER_CREATE_DATE date DEFAULT SYSDATE,
	PRIMARY KEY (CUSTOMER_NO)
);


CREATE TABLE TB_GOODS
(
	PRODUCT_NO number(5,0) NOT NULL,
	PRODUCT_NAME varchar2(200) NOT NULL,
	COMPANY_NO number(3,0) NOT NULL,
	PRODUCT_PRICE number(7,0),
	PRODUCT_STOCK number(4,0),
	PRODUCT_IMAGE_NAME varchar2(100),
	PRODUCT_SELL_YN char(1),
	PRODUCT_LIKES number(5,0) DEFAULT 0,
	PRODUCT_CREATE_DATE date DEFAULT SYSDATE,
	CATEGORY_NO number(3,0) NOT NULL,
	PRIMARY KEY (PRODUCT_NO)
);


CREATE TABLE TB_ORDERS
(
	ORDER_NO number(5,0) NOT NULL,
	CUSTOMER_NO number(5,0) NOT NULL,
	ORDER_STATE varchar2(50),
	ORDER_CREATE_DATE date,
	PRIMARY KEY (ORDER_NO)
);


CREATE TABLE TB_ORDER_ITEMS
(
	ORDER_ITEM_NO number(7,0) NOT NULL,
	PRODUCT_NO number(5,0) NOT NULL,
	ORDER_ITEM_AMOUNT number(3,0),
	ORDER_NO number(5,0) NOT NULL,
	PRIMARY KEY (ORDER_ITEM_NO)
);



/* Create Foreign Keys */

ALTER TABLE TB_CATEGORIES
	ADD FOREIGN KEY (PARENT_CATEGORY_NO)
	REFERENCES TB_CATEGORIES (CATEGORY_NO)
;


ALTER TABLE TB_GOODS
	ADD FOREIGN KEY (CATEGORY_NO)
	REFERENCES TB_CATEGORIES (CATEGORY_NO)
;


ALTER TABLE TB_GOODS
	ADD FOREIGN KEY (COMPANY_NO)
	REFERENCES TB_COMPANIES (COMPANY_NO)
;


ALTER TABLE TB_ORDERS
	ADD FOREIGN KEY (CUSTOMER_NO)
	REFERENCES TB_CUSTOMER (CUSTOMER_NO)
;


ALTER TABLE TB_ORDER_ITEMS
	ADD FOREIGN KEY (PRODUCT_NO)
	REFERENCES TB_GOODS (PRODUCT_NO)
;


ALTER TABLE TB_ORDER_ITEMS
	ADD FOREIGN KEY (ORDER_NO)
	REFERENCES TB_ORDERS (ORDER_NO)
;


