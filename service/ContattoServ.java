package com.example.Rubrica.service;

import com.example.Rubrica.dto.ContattoDto;
import com.example.Rubrica.dto.IndirizzoDto;
import com.example.Rubrica.models.Contatto;
import com.example.Rubrica.models.Indirizzo;
import com.example.Rubrica.repository.ContattoRepo;
import com.example.Rubrica.repository.IndirizzoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.apache.tomcat.jni.Buffer.address;

@Service
public class ContattoServ {
    @Autowired
    private ContattoRepo contattoRepo;

    @Autowired
    private IndirizzoRepo indirizzoRepo;

    public void addContact (ContattoDto cDto){ // sto cercando di mettere l'id dell'indirizzo uguale a quello del contatto. il problema si pone perchè il valore dell'id contatto si genera dopo
                                                // il metodo save quindi l'id dell'indirizzo mi risulta sempre null e di conseguenza non salva nulla. doveri fare il metodo save prima di
                                                // inizializzare l'indirizzo. non so se funziona. un'altra ipotesi sarebbe unificare le classi (non l'avevo fatto per fare una prova). ovviamente
                                                // avrei un'unica tabella e tutto sarebbe più semplice.
        Contatto c1 = new Contatto();
        c1.setName(cDto.getName());
        c1.setSurname(cDto.getSurname());
        c1.setCell(cDto.getCell());
        c1.setEmail(cDto.getEmail());
        c1.setCompany(cDto.getCompany());

        IndirizzoDto iDto = cDto.getAddress();
        Indirizzo i = new Indirizzo();

        if (iDto != null){
//            i.setId(iDto.getId());
            i.setVia(iDto.getVia());
            i.setNumeroCivico(iDto.getNumeroCivico());
            i.setCap(iDto.getCap());
            i.setCitta(iDto.getCitta());
            i.setProvincia(iDto.getProvincia());
            indirizzoRepo.save(i);
            c1.setAddress(i);

        } else {
            c1.setAddress(null);
        }
        contattoRepo.save(c1);
    }

    public ContattoDto getContattoById (Long id) {
        Optional<Contatto> cOpt = contattoRepo.findById(id);
        if (cOpt.isPresent()) {
            ContattoDto cDto = new ContattoDto();
            Contatto c = cOpt.get();
            cDto.setId(c.getId());
            cDto.setName(c.getName());
            cDto.setSurname(c.getSurname());
            cDto.setCell(c.getCell());
            cDto.setEmail(c.getEmail());
            cDto.setCompany(c.getCompany());

            IndirizzoDto iDto = new IndirizzoDto();
            Indirizzo i = cOpt.get().getAddress();

            if (i != null){ // sostituire con c.getAddress != null
                iDto.setVia(i.getVia());
                iDto.setNumeroCivico(i.getNumeroCivico());
                iDto.setCap(i.getCap());
                iDto.setCitta(i.getCitta());
                iDto.setProvincia(i.getProvincia());
                cDto.setAddress(iDto);
            } else {
                cDto.setAddress(null);
            }

            return cDto;
        }
        return null;
    }

    public List<ContattoDto> getContattoByString (String research) {
        List<Contatto> contatti = contattoRepo.findAll();
        List<ContattoDto> contattoFound = new ArrayList<>();

        for (Contatto c : contatti) {
            ContattoDto cDto = new ContattoDto();
            Indirizzo i = c.getAddress();
            if (!contatti.isEmpty()) {
                if (c.getName().toLowerCase().contains(research) || c.getSurname().toLowerCase().contains(research) ||
                        c.getEmail().toLowerCase().contains(research) || c.getCompany().toLowerCase().contains(research)) {

                    cDto.setId(c.getId());
                    cDto.setName(c.getName());
                    cDto.setSurname(c.getSurname());
                    cDto.setCell(c.getCell());
                    cDto.setEmail(c.getEmail());
                    cDto.setCompany(c.getCompany());

                    IndirizzoDto iDto = new IndirizzoDto();
                     // sostituire l'indirizzo con c.getAddress

                    if (i != null) {
                        iDto.setVia(i.getVia());
                        iDto.setNumeroCivico(i.getNumeroCivico());
                        iDto.setCap(i.getCap());
                        iDto.setCitta(i.getCitta());
                        iDto.setProvincia(i.getProvincia());
                        cDto.setAddress(iDto);

                    } else {
                        cDto.setAddress(null);
                    }

                    contattoFound.add(cDto);
                }
            } else {
                return null;
            }
        }
        return contattoFound;
    }

    public List<ContattoDto> getContatti(){
        List<Contatto> contatti = contattoRepo.findAll();
        List<ContattoDto> contattiDto = new ArrayList<>();

        for (Contatto c : contatti){
            ContattoDto cDto = new ContattoDto();
            Indirizzo i = c.getAddress();
            if (!contatti.isEmpty()){
                cDto.setId(c.getId());
                cDto.setName(c.getName());
                cDto.setSurname(c.getSurname());
                cDto.setCell(c.getCell());
                cDto.setEmail(c.getEmail());
                cDto.setCompany(c.getCompany());

                IndirizzoDto iDto = new IndirizzoDto();


                if (i != null){
                    iDto.setVia(i.getVia());
                    iDto.setNumeroCivico(i.getNumeroCivico());
                    iDto.setCap(i.getCap());
                    iDto.setCitta(i.getCitta());
                    iDto.setProvincia(i.getProvincia());
                    cDto.setAddress(iDto);
                } else {
                    cDto.setAddress(null);
                }
                contattiDto.add(cDto);
            }
        }
        return contattiDto;
    }

    public void updateContact(ContattoDto cDto){

        if (cDto.getId()==null) {
            throw new RuntimeException("Contatto non trovato");
        }

        Contatto c = new Contatto();
        c.setId(cDto.getId());
        c.setName(cDto.getName());
        c.setSurname(cDto.getSurname());
        c.setCell(cDto.getCell());
        c.setEmail(cDto.getEmail());
        c.setCompany(cDto.getCompany());

        IndirizzoDto iDto = cDto.getAddress();
        Indirizzo i = new Indirizzo();

        if (iDto != null) {
            i.setVia(iDto.getVia());
            i.setNumeroCivico(iDto.getNumeroCivico());
            i.setCap(i.getCap());
            i.setCitta(iDto.getCitta());
            i.setProvincia(iDto.getProvincia());
            indirizzoRepo.save(i);
            c.setAddress(i);
        }
        else {
        c.setAddress(null);
        }
        contattoRepo.save(c);

//    Optional<Contatto> optionalContatto = contattoRepo.findById(cDto.getId());
//    if (optionalContatto.isPresent()){
//        Contatto c = optionalContatto.get();
//        c.setName(cDto.getName());
//        c.setSurname(cDto.getSurname());
//        c.setCell(cDto.getCell());
//        c.setEmail(cDto.getEmail());
//        c.setCompany(cDto.getCompany());
//
//        IndirizzoDto iDto = new IndirizzoDto();
//        Indirizzo i = new Indirizzo();
//
//        if (iDto != null) {
//            i.setVia(iDto.getVia());
//            i.setNumeroCivico(iDto.getNumeroCivico());
//            i.setCap(i.getCap());
//            i.setCitta(iDto.getCitta());
//            i.setProvincia(iDto.getProvincia());
//            indirizzoRepo.save(i);
//            c.setAddress(i);
//        }
//        else {
//        c.setAddress(null);
//        }
//        contattoRepo.save(c);
//    }

    }

    public void deleteContactById(Long id){
        contattoRepo.deleteById(id);

    }

//    public void addContact (ContattoDto cDto, IndirizzoDto iDto){ // sto cercando di mettere l'id dell'indirizzo uguale a quello del contatto. il problema si pone perchè il valore dell'id contatto si genera dopo
//        // il metodo save quindi l'id dell'indirizzo mi risulta sempre null e di conseguenza non salva nulla. doveri fare il metodo save prima di
//        // inizializzare l'indirizzo. non so se funziona. un'altra ipotesi sarebbe unificare le classi (non l'avevo fatto per fare una prova). ovviamente
//        // avrei un'unica tabella e tutto sarebbe più semplice.
//        Contatto c1 = new Contatto();
//        c1.setName(cDto.getName());
//        c1.setSurname(cDto.getSurname());
//        c1.setCell(cDto.getCell());
//        c1.setEmail(cDto.getEmail());
//        c1.setCompany(cDto.getCompany());
//
//
//        if (iDto != null){
//        Indirizzo i = new Indirizzo();
////            i.setId(iDto.getId());
//        i.setVia(iDto.getVia());
//        i.setNumeroCivico(iDto.getNumeroCivico());
//        i.setCap(iDto.getCap());
//        i.setCitta(iDto.getCitta());
//        i.setProvincia(iDto.getProvincia());
//        indirizzoRepo.save(i);
//        c1.setAddress(i);
//
//        } else {
//            c1.setAddress(null);
//        }
//        contattoRepo.save(c1);
//    }

}
