package com.example.Rubrica.controller;

import com.example.Rubrica.dto.ContattoDto;
import com.example.Rubrica.dto.IndirizzoDto;
import com.example.Rubrica.models.Contatto;
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

//    @PostMapping("/nuovo-contatto")
//    public ResponseEntity<?> addContact (@RequestBody ContattoDto cDto, IndirizzoDto iDto) {
//        contattoServ.addContact(cDto, iDto);
//        return ResponseEntity.ok().body("Utente inserito correttamente");
//    }

    @GetMapping("/cerca-contatto/{id}")
    public ResponseEntity<?> findContact (@PathVariable Long id) {
        return ResponseEntity.ok().body(contattoServ.getContattoById(id));
    }

    @GetMapping("/cerca-contatto/stringa/{research}")
    public ResponseEntity<?> findContactByString (@PathVariable String research) {
        return ResponseEntity.ok().body(contattoServ.getContattoByString(research));
    }

    @GetMapping("/cerca-contatti")
    public ResponseEntity<?> findContact () {
        return ResponseEntity.ok().body(contattoServ.getContatti());
    }

    @PutMapping("/modifica-contatto/{id}")
    public ResponseEntity<?> updateContact (@PathVariable Long id, @RequestBody ContattoDto cDto) {
        contattoServ.updateContact(cDto);
        return ResponseEntity.ok().body("Contatto modificato correttamente");
    }

    @DeleteMapping("/cancella-contatto/{id}")
    public ResponseEntity<?> deletContact(@PathVariable Long id){
        contattoServ.deleteContactById(id);
        return ResponseEntity.ok().body("Utente cancellato");
    }
}
