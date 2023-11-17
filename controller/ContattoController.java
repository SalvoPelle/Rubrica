package com.example.Rubrica.controller;

import com.example.Rubrica.dto.ContattoDto;
import com.example.Rubrica.service.ContattoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rubrica")
public class ContattoController {

    @Autowired
    public ContattoServ contattoServ;

    @PostMapping("/nuovo-contatto")
    public ResponseEntity<?> addContact (@RequestBody ContattoDto cDto) {
        contattoServ.addContact(cDto);
        return ResponseEntity.ok().body("Utente inserito correttamente");
    }

    @GetMapping("/cerca-contatto/{id}")
    public ResponseEntity<?> findContact (@PathVariable Long id) {
        return ResponseEntity.ok().body(contattoServ.getContattoById(id));
    }
}
