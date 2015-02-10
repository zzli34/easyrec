ALTER TABLE action DROP COLUMN searchSucceeded;
ALTER TABLE action DROP COLUMN numberOfFoundItems;
ALTER TABLE action CHANGE COLUMN description actionInfo VARCHAR(500) CHARACTER SET utf8;