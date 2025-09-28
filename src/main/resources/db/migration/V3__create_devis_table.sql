CREATE TABLE devis (
    id BIGSERIAL PRIMARY KEY,
    utilisateur_id BIGINT NOT NULL,
    clientname VARCHAR(255),
    clientAdress VARCHAR(255),
    clientZip VARCHAR(20),
    clientCity VARCHAR(100),
    clientSiret VARCHAR(50),
    clientTel VARCHAR(50),
    dateDevis TIMESTAMP,
    listProduct JSONB,
    info TEXT,
    totalHt VARCHAR(50),
    totalTva VARCHAR(50),
    totalTtc VARCHAR(50),

  CONSTRAINT fk_user
        FOREIGN KEY(utilisateur_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
