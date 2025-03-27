CREATE TABLE Offer
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    currentState VARCHAR(255) NOT NULL,
    startDate    DATE         NOT NULL,
    endDate      DATE         NOT NULL,
    active       BOOLEAN      NOT NULL
);

INSERT INTO Offer (currentState, startDate, endDate, active)
VALUES ('DRAFT', '2025-03-25', '2025-04-25', true);
INSERT INTO Offer (currentState, startDate, endDate, active)
VALUES ('ACTIVE', '2025-04-01', '2025-05-01', false);
INSERT INTO Offer (currentState, startDate, endDate, active)
VALUES ('EXPIRED', '2025-02-01', '2025-03-01', false);