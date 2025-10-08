CREATE TABLE devis (
    id BIGSERIAL PRIMARY KEY,
    utilisateurid BIGINT NOT NULL,
    clientname VARCHAR(255),
    clientAdress VARCHAR(255),
    clientZip VARCHAR(20),
    clientCity VARCHAR(100),
    clientSiret VARCHAR(50),
    clientTel VARCHAR(50),
    dateDevis DATE,
    listProduct JSONB,
    info TEXT,
    totalHt NUMERIC(15,2),
    totalTva NUMERIC(15,2),
    totalTtc NUMERIC(15,2),

  CONSTRAINT fk_user
        FOREIGN KEY(utilisateurid)
        REFERENCES users(id)
        ON DELETE CASCADE
);
