package com.quoteExpress.quoteExpress.sevice;

import com.quoteExpress.quoteExpress.controler.StatistiqueControler;
import com.quoteExpress.quoteExpress.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Map;

@Service
public class StatistiqueService implements StatistiqueControler {

    private final DevisRepository devisRepository;

    @Autowired
    public StatistiqueService(DevisRepository devisRepository) {
        this.devisRepository = devisRepository;
    }

    private static Integer getMonthInteger(String month) {
        Map<String, Integer> monthMap = Map.ofEntries(
                Map.entry("janvier", 1),
                Map.entry("février", 2),
                Map.entry("mars", 3),
                Map.entry("avril", 4),
                Map.entry("mai", 5),
                Map.entry("juin", 6),
                Map.entry("juillet", 7),
                Map.entry("août", 8),
                Map.entry("septembre", 9),
                Map.entry("octobre", 10),
                Map.entry("novembre", 11),
                Map.entry("décembre", 12)
        );

        Integer newMonth = monthMap.get(month);
        return newMonth;
    }
    
    @Override
    public ResponseEntity totalDevisDay(Long userId) throws Exception {
        try {
            LocalDate date = LocalDate.now();
            return ResponseEntity.ok(devisRepository.countDevisToday(userId, date));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity totalDevisMonth(Long userId, String month) throws Exception {
        try {
            if (month == null || month.isEmpty()) {
                return ResponseEntity.badRequest().body("Le mois est obligatoire");
            }

            month = month.toLowerCase().trim();

            Integer newMonth = getMonthInteger(month);

            if (newMonth == null) {
                return ResponseEntity.badRequest().body("Mois inconnu : " + month);
            }

            int year = LocalDate.now().getYear();

            YearMonth yearMonth = YearMonth.of(year, newMonth);
            LocalDate monthStart = yearMonth.atDay(1);
            LocalDate monthEnd = yearMonth.atEndOfMonth();

            return ResponseEntity.ok(devisRepository.countDevisMonth(userId, monthStart, monthEnd));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity totalDevisYear(Long userId, Integer year) throws Exception {
       try {
           if (year == null) {
               return ResponseEntity.badRequest().body("L'annee est obligatoire");
           }
           LocalDate yearStart = LocalDate.of(year, 1, 1);
           LocalDate yearEnd = LocalDate.of(year, 12, 31);

           return ResponseEntity.ok(devisRepository.countDevisMonth(userId, yearStart, yearEnd));

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    @Override
    public ResponseEntity totalPrixDevisDay(Long userId) throws Exception {
        try {
            LocalDate date = LocalDate.now();
            return ResponseEntity.ok(devisRepository.sumTotalDevisToday(userId, date));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity totalPrixDevisMonth(Long userId, String month) throws Exception {
        try {
            if (month == null || month.isEmpty()) {
                return ResponseEntity.badRequest().body("Le mois est obligatoire");
            }

            month = month.toLowerCase().trim();

            Integer newMonth = getMonthInteger(month);

            if (newMonth == null) {
                return ResponseEntity.badRequest().body("Mois inconnu : " + month);
            }

            int year = LocalDate.now().getYear();

            YearMonth yearMonth = YearMonth.of(year, newMonth);
            LocalDate monthStart = yearMonth.atDay(1);
            LocalDate monthEnd = yearMonth.atEndOfMonth();

            return ResponseEntity.ok(devisRepository.sumDevisMonth(userId, monthStart, monthEnd));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity totalPrixDevisYear(Long userId, Integer year) throws Exception {
        try {
            if (year == null) {
                return ResponseEntity.badRequest().body("L'annee est obligatoire");
            }
            LocalDate yearStart = LocalDate.of(year, 1, 1);
            LocalDate yearEnd = LocalDate.of(year, 12, 31);

            return ResponseEntity.ok(devisRepository.sumDevisMonth(userId, yearStart, yearEnd));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
