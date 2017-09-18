PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE [m_user] (
[index_no] INTEGER  NOT NULL PRIMARY KEY,
[name] TEXT  NULL,
[username] TEXT  NULL,
[password] TEXT  NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_user" VALUES(1,'Mohan','mac','123',1);
CREATE TABLE [m_department] (
[index_no] INTEGER  PRIMARY KEY NOT NULL,
[name] TEXT  NOT NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_department" VALUES(1,'Sample Department',1);
CREATE TABLE [m_main_category] (
[index_no] INTEGER  PRIMARY KEY NOT NULL,
[name] TEXT  NULL,
[department] INTEGER  NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_main_category" VALUES(1,'Sample Main Category',1,1);
CREATE TABLE [m_route] (
[index_no] INTEGER  PRIMARY KEY NOT NULL,
[name] TEXT  NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_route" VALUES(1,'Panadura',1);
CREATE TABLE [m_sub_category] (
[index_no] INTEGER  PRIMARY KEY NOT NULL,
[name] TEXT  NULL,
[main_category] INTEGER  NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_sub_category" VALUES(1,'Sample Sub Category',1,1);
CREATE TABLE [t_order_detail] (
[index_no] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,
[server_id] INTEGER  NULL,
[order_summary] INTEGER  NULL,
[item] INTEGER  NULL,
[cost_price] REAL DEFAULT '''''''0.0''''''' NULL,
[retail_price] REAL DEFAULT '''''''0.0''''''' NULL,
[max_discount_percent] REAL DEFAULT '''''''0.0''''''' NULL,
[quantity] REAL DEFAULT '''''''0.0''''''' NULL,
[discount_percent] REAL DEFAULT '''''''0.0''''''' NULL,
[item_value] REAL DEFAULT '''0.0''' NULL,
[discount_value] REAL DEFAULT '''''''0.0''''''' NULL,
[net_value] REAL DEFAULT '''''''0.0''''''' NULL,
[version] INTEGER  NULL
);
CREATE TABLE [m_item] (
[index_no] INTEGER  PRIMARY KEY NOT NULL,
[code] TEXT  NULL,
[name] TEXT  NULL,
[print_description] TEXT  NULL,
[department] INTEGER  NULL,
[main_category] INTEGER  NULL,
[sub_category] INTEGER  NULL,
[cost_price] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[retail_price] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[max_discount_percent] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_item" VALUES(1,NULL,'Sample Item','Sample Print Description',1,1,1,1000.0,1500.0,'''''''0.0''''''',1);
CREATE TABLE [t_order_summary] (
[index_no] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,
[server_id] INTEGER  NULL,
[order_date] TEXT  NULL,
[client] INTEGER  NULL,
[total_item_value] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[item_discount_value] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[special_discount_percent] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[special_discount_value] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[net_value] REAL DEFAULT '''''''''''''''0.0''''''''''''''' NULL,
[payment_method] TEXT  NULL,
[order_by_user] INTEGER  NULL,
[approved_by_user] INTEGER  NULL,
[approved_date] TEXT  NULL,
[status] TEXT  NULL,
[version] INTEGER  NULL
);
CREATE TABLE [m_transactor] (
[index_no] INTEGER  PRIMARY KEY AUTOINCREMENT NOT NULL,
[server_id] INTEGER  NULL,
[name] TEXT  NULL,
[contact_person] TEXT  NULL,
[address_line1] TEXT  NULL,
[address_line2] TEXT  NULL,
[address_line3] TEXT  NULL,
[mobile] TEXT  NULL,
[telephone1] TEXT  NULL,
[telephone2] TEXT  NULL,
[fax] TEXT  NULL,
[route] INTEGER  NULL,
[credit_amount] REAL DEFAULT '''''''''''''''''''''''''''''''0.0''''''''''''''''''''''''''''''' NULL,
[credit_limit] REAL DEFAULT '''''''''''''''''''''''''''''''0.0''''''''''''''''''''''''''''''' NULL,
[client] INTEGER  NULL,
[supplier] INTEGER  NULL,
[last_visited_date] TEXT  NULL,
[version] INTEGER  NULL
);
INSERT INTO "m_transactor" VALUES(1,1,'Channa Jayamuni','Roshan Perera','Add L1',NULL,NULL,NULL,NULL,NULL,NULL,1,500.0,1000.0,1,1,NULL,1);
DELETE FROM sqlite_sequence;
INSERT INTO "sqlite_sequence" VALUES('t_order_detail',NULL);
INSERT INTO "sqlite_sequence" VALUES('t_order_summary',NULL);
INSERT INTO "sqlite_sequence" VALUES('m_transactor',1);
COMMIT;
