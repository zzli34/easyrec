ALTER TABLE action DROP COLUMN searchSucceeded;
ALTER TABLE action DROP COLUMN numberOfFoundItems;
ALTER TABLE action CHANGE COLUMN description actionInfo VARCHAR(500) CHARACTER SET utf8;

ALTER TABLE backtracking ADD COLUMN itemFromTypeId int(11) NOT NULL AFTER itemFromId;
ALTER TABLE backtracking ADD COLUMN itemToTypeId int(11) NOT NULL AFTER itemToId;
ALTER TABLE backtracking CHANGE COLUMN TIMESTAMP actionTime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE backtracking CHANGE COLUMN assocType recType INT(11) UNSIGNED NOT NULL;
ALTER TABLE backtracking DROP INDEX assoc;
ALTER TABLE backtracking ADD INDEX assoc(tenantId, itemFromId, itemFromTypeId, recType, itemToId, itemToTypeId);

ALTER TABLE actiontype ADD COLUMN weight INT(11) NOT NULL DEFAULT 1;

-- update database version
TRUNCATE TABLE easyrec;
INSERT INTO easyrec (version) VALUES (1.00);