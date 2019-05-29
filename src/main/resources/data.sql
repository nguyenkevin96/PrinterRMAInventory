INSERT INTO stage (stagename) VALUES ('Outstanding RMA');
INSERT INTO stage (stagename) VALUES ('Closed/Received RMA');
INSERT INTO stage (stagename) VALUES ('Loaner');
INSERT INTO stage (stagename) VALUES ('Upgrade');
INSERT INTO stage (stagename) VALUES ('Possible Sale');
INSERT INTO stage (stagename) VALUES ('Swap');
INSERT INTO stage (stagename) VALUES ('Sale');
INSERT INTO stage (stagename) VALUES ('Demo Unit');

INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLabel', 'Standard', 'Replacement');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLabel', 'Straight-Through', 'Replacement');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLabel', 'C-Path', 'Replacement');

INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLabel', 'Standard', 'RMA');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLabel', 'Straight-Through', 'RMA');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLabel', 'C-Path', 'RMA');

INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLog', 'Standard', 'Replacement');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLog', 'Straight-Through', 'Replacement');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLog', 'C-Path', 'Replacement');

INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLog', 'Standard', 'RMA');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLog', 'Straight-Through', 'RMA');
INSERT INTO printertype (printername, printervariant, printerrmatype) VALUES ('NeuraLog', 'C-Path', 'RMA');