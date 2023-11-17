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

@Service
public class ContattoServ {
    @Autowired
    private ContattoRepo contattoRepo;

    @Autowired
    private IndirizzoRepo indirizzoRepo;

    public void addContact (ContattoDto cDto){
        Contatto c1 = new Contatto();
        c1.setName(cDto.getName());
        c1.setSurname(cDto.getSurname());
        c1.setCell(cDto.getCell());
        c1.setEmail(cDto.getEmail());
        c1.setCompany(cDto.getCompany());

        IndirizzoDto iDto = new IndirizzoDto();
        Indirizzo i = new Indirizzo();

        if (iDto != null){
            i.setId(iDto.getId());
            i.setVia(iDto.getVia());
            i.setNumeroCivico(iDto.getNumeroCivico());
            i.setCap(i.getCap());
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
            Indirizzo i = new Indirizzo();

            if (i != null){
                iDto.setVia(i.getVia());
                iDto.setNumeroCivico(i.getNumeroCivico());
                iDto.setCap(i.getCap());
                iDto.setCitta(i.getCitta());
                iDto.setProvincia(i.getProvincia());
                cDto.setAddress(i);
            } else {
                cDto.setAddress(null);
            }

            return cDto;
        }
        return null;
    }

    public List<ContattoDto> getContatti(){
        List<Contatto> contatti = contattoRepo.findAll();
        List<ContattoDto> contattiDto = new ArrayList<>();

        for (Contatto c : contatti){
            ContattoDto cDto = new ContattoDto();
            if (!contatti.isEmpty()){
                cDto.setId(c.getId());
                cDto.setName(c.getName());
                cDto.setSurname(c.getSurname());
                cDto.setCell(c.getCell());
                cDto.setEmail(c.getEmail());
                cDto.setCompany(c.getCompany());

                IndirizzoDto iDto = new IndirizzoDto();
                Indirizzo i = new Indirizzo();

                if (i != null){
                    iDto.setVia(i.getVia());
                    iDto.setNumeroCivico(i.getNumeroCivico());
                    iDto.setCap(i.getCap());
                    iDto.setCitta(i.getCitta());
                    iDto.setProvincia(i.getProvincia());
                    cDto.setAddress(i);
                } else {
                    cDto.setAddress(null);
                }
                contattiDto.add(cDto);
            }
        }
        return contattiDto;
    }

}
