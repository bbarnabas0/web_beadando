insert into CATEGORY_MASTER values(1001,'zöldség/gyümölcs');
insert into CATEGORY_MASTER values(1002,'hús');
insert into CATEGORY_MASTER values(1003,'pékáru');
insert into CATEGORY_MASTER values(1004,'tartós élelmiszerek');

insert into ITM_INFO(itm_Id, ITM_NAME, ITM_CODE, ITM_PRICE, EMAIL_ID, CATEG_ID ) values(101,'krumpli',12345678,1350,'gazdalkodo@citromail.com',1001);
insert into ITM_INFO(itm_Id, ITM_NAME, ITM_CODE, ITM_PRICE, EMAIL_ID, CATEG_ID ) values(103,'fahéjas csiga',27654321,600,'pek@gmail.com',1002);
insert into ITM_INFO(itm_Id, ITM_NAME, ITM_CODE, ITM_PRICE, EMAIL_ID, CATEG_ID ) values(102,'babkonzerv',43572468,133,'konzerv@email.com',1003);
insert into ITM_INFO(itm_Id, ITM_NAME, ITM_CODE, ITM_PRICE, EMAIL_ID, CATEG_ID ) values(104,'csirkemell',23681357,540,'vagohid@hus.com',1004);