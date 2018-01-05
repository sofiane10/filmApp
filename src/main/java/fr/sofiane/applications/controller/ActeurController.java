package fr.sofiane.applications.controller;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 21/10/2016.
 */

@RestController
@RequestMapping("/acteur")
public class ActeurController {

    @Autowired
    ActeurService acteurService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ActeurDto> getActeurs() {
        return acteurService.getActeurs();
    }

    @RequestMapping(value = "/{idActeur}" ,method = RequestMethod.GET)
    public ActeurDto getActeur(@PathVariable("idActeur") Long id) throws Exception {
        return acteurService.getActeur(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public List<ActeurDto> addActeur(@RequestBody Map<String, Object> acteur) throws Exception {
        return acteurService.addActeur(acteur);
    }

    @RequestMapping(value = "/delete/{idActeur}", method = RequestMethod.DELETE)
    public void deletePersonne(@PathVariable("idActeur") Long id){
        acteurService.deleteActeur(id);
    }

    @RequestMapping(value = "/update/{idActeur}", method = RequestMethod.PUT)
    public void updatePersonne(@PathVariable("idActeur") Long id, @RequestBody Map<String, Object> acteur) throws java.text.ParseException {
        acteurService.updateActeur(id, acteur);
    }
}
