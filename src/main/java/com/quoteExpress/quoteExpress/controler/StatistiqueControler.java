package com.quoteExpress.quoteExpress.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devis")
public interface StatistiqueControler {

    @GetMapping("/day/{userId}")
    ResponseEntity totalDevisDay(@PathVariable("userId") Long userId) throws Exception;

    @GetMapping("/month/{userId}")
    ResponseEntity totalDevisMonth(@PathVariable("userId") Long userId,@RequestParam("month") String month) throws Exception;

    @GetMapping("/year/{userId}")
    ResponseEntity totalDevisYear(@PathVariable("userId") Long userId,@RequestParam("year") Integer year) throws Exception;

}
