package com.quoteExpress.quoteExpress.repository;


import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface DevisRepository extends JpaRepository<Devis,Long> {

    Devis findDevisById(Long devisId);

    @Query("SELECT COUNT(d) FROM Devis d WHERE d.users.id = :utilisateurId AND d.dateDevis = :date")
    long countDevisToday(@Param("utilisateurId") Long utilisateurId, @Param("date") LocalDate date);

    @Query("SELECT COUNT(d) FROM Devis d WHERE d.users.id = :utilisateurId AND d.dateDevis BETWEEN :monthStart AND :monthEnd")
    long countDevisMonth(@Param("utilisateurId")Long userId, @Param("monthStart") LocalDate monthStart, @Param("monthEnd") LocalDate monthEnd);
}
