package com.quoteExpress.quoteExpress.controler;

import com.quoteExpress.quoteExpress.DTO.LoginRequest;
import com.quoteExpress.quoteExpress.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public interface UserControler {

    @PostMapping("/utilisateur")
    ResponseEntity addUser(@RequestBody User user) throws Exception;

    @PostMapping("/utilisateur/{userId}")
    ResponseEntity getUser(@PathVariable("userId") Long userID) throws Exception;

    @PostMapping("/utilisateur/delete/{userId}")
    ResponseEntity deletUser(@PathVariable("userId") Long userID) throws Exception;

    @PostMapping("/utilisateur/connexion")
    ResponseEntity connexionUser(@RequestBody LoginRequest loginRequest);

    @PatchMapping("/utilisateur/update/pdw/{userId}")
    ResponseEntity updatePassword(@PathVariable("userId") Long userid, @RequestBody Map<String, String> newPwd) throws Exception;

    @PatchMapping("/utilisateur/update/{userId}")
    ResponseEntity updateUser(@PathVariable("userId") Long userid, @RequestBody User user) throws RuntimeException;
}
