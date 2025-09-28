package com.quoteExpress.quoteExpress.controler;


import com.quoteExpress.quoteExpress.DTO.Product;
import com.quoteExpress.quoteExpress.model.Devis;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/devis")
public interface DevisControler {

    @PostMapping("/user/{userId}")
    ResponseEntity addDevis(@PathVariable("userId") Long userId,@RequestBody Devis devis) throws Exception;

    @GetMapping("/{devisId}")
    ResponseEntity getDevis(@PathVariable Long devisId) throws Exception;

    @DeleteMapping("/{devisId}")
    ResponseEntity deleteDevis(@PathVariable Long devisId) throws Exception;

    @PatchMapping("/{devisId}/client")
    ResponseEntity updateDevis(@PathVariable("devisId") Long devisId,@RequestBody Devis devis) throws Exception;

    @PatchMapping("/{devisId}/date")
    ResponseEntity updateDate(@PathVariable("devisId") Long devisId,@RequestBody Map<String, String> date) throws Exception;

    @PatchMapping("/{devisId}/products")
    ResponseEntity addProduct(@PathVariable("devisId") Long devisId, @RequestBody Product product) throws Exception;

    @DeleteMapping("/{devisId}/products/{index}")
    ResponseEntity deleteProduct(@PathVariable("devisId") Long devisId, @PathVariable("index") int  indexProduct) throws Exception;

}
