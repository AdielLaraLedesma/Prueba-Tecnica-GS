-- ########################################################
-- Branch
-- ########################################################

INSERT INTO Branch (Name, Address) VALUES ('Sucursal Centro', 'Calle olivos 409, Culiacán');
INSERT INTO Branch (Name, Address) VALUES ('Sucursal Norte', 'Avenida girasoles 650, Culiacán');
INSERT INTO Branch (Name, Address) VALUES ('Sucursal Sur', 'Calle pedregal 283, Culiacán');

-- ########################################################
-- Client
-- ########################################################

INSERT INTO Client (FirstName, LastName, Email, BranchId) VALUES ('Adiel', 'Lara', 'adiel.lara@hotmail.com', 1);
INSERT INTO Client (FirstName, LastName, Email, BranchId) VALUES ('Mauricio', 'Perez', 'mauricio.perez@hotmail.com', 2);
INSERT INTO Client (FirstName, LastName, Email, BranchId) VALUES ('Carlos', 'García', 'carlos.garcia@hotmail.com', 3);
