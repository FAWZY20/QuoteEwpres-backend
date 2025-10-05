package com.quoteExpress.quoteExpress.sevice;


import com.quoteExpress.quoteExpress.DTO.Product;
import com.quoteExpress.quoteExpress.controler.DevisControler;
import com.quoteExpress.quoteExpress.model.Devis;
import com.quoteExpress.quoteExpress.model.User;
import com.quoteExpress.quoteExpress.repository.DevisRepository;
import com.quoteExpress.quoteExpress.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DevisService implements DevisControler {

    private final DevisRepository devisRepository;
    private final UserRepository userRepository;

    @Autowired
    public DevisService(DevisRepository devisRepository, UserRepository userRepository) {
        this.devisRepository = devisRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity addDevis(Long userId, Devis devis) throws Exception {
        try {
            User user = userRepository.findUserById(userId);
            devis.setUsers(user);
            devisRepository.save(devis);
            return ResponseEntity.ok(devis);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public ResponseEntity getDevis(Long devisId) throws Exception {
        try {
            return ResponseEntity.ok(devisRepository.findById(devisId));
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public ResponseEntity deleteDevis(Long devisId) throws Exception {
        try {
            devisRepository.deleteById(devisId);
            return ResponseEntity.ok("le devis a bien etait supprimer");
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public ResponseEntity updateDevis(Long userId, Devis devis) throws Exception {
        try {
            Devis lastdevis = devisRepository.findDevisById(userId);
            lastdevis.setClientName(devis.getClientName());
            lastdevis.setClientAdress(devis.getClientAdress());
            lastdevis.setClientZip(devis.getClientZip());
            lastdevis.setClientCity(devis.getClientCity());
            lastdevis.setClientSiret(devis.getClientSiret());
            lastdevis.setClientTel(devis.getClientTel());
            lastdevis.setInfo(devis.getInfo());

            devisRepository.save(lastdevis);

            return ResponseEntity.ok(lastdevis);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity updateDate(Long userId, Map<String, String> date) throws Exception {
        try {
            Devis lastdevis = devisRepository.findDevisById(userId);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateDevis = LocalDate.from(LocalDate.parse(date.get("dateDevis"), formatter).atStartOfDay());

            lastdevis.setDateDevis(dateDevis);
            devisRepository.save(lastdevis);

            return ResponseEntity.ok(lastdevis);

        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public ResponseEntity addProduct(Long devisId, Product product) throws Exception {
        try {
            Devis devis = devisRepository.findById(devisId)
                    .orElseThrow(() -> new RuntimeException("Devis introuvable"));

            List<Product> products = devis.getListProduct();

            if (products == null) {
                products = new ArrayList<>();
            }

            products.add(product);
            devis.setListProduct(products);
            devisRepository.save(devis);

            return ResponseEntity.ok(devis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity deleteProduct(Long devisId, int indexProduct) throws Exception {
        try {
            Devis devis = devisRepository.findDevisById(devisId);

            List<Product> products = devis.getListProduct();

            if (products == null) {
                products = new ArrayList<>();
            }

            products.remove(indexProduct);
            devis.setListProduct(products);
            devisRepository.save(devis);

            return ResponseEntity.ok(devis);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
