package fr.sofiane.applications.controller;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 21/10/2016.
 */

@RestController
@RequestMapping("/personne")
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ActeurDto> getPersonnes() {
        return personneService.getPersonnes();
    }

    @RequestMapping(value = "/{idPersonne}" ,method = RequestMethod.GET)
    public ActeurDto getPersonne(@PathVariable("idPersonne") Long id) {
        return personneService.getOne(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public List<ActeurDto> addPersonne(@RequestBody Map<String, Object> personne) throws java.text.ParseException {
        return personneService.add(personne);
    }

    @RequestMapping(value = "/delete/{idPersonne}", method = RequestMethod.DELETE)
    public void deletePersonne(@PathVariable("idPersonne") Long id){
        personneService.delete(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updatePersonne(@PathVariable("id") Long id, @RequestBody Map<String, Object> personne) throws java.text.ParseException {
        personneService.update(id, personne);
    }
}
