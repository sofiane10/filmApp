package fr.sofiane.applications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import fr.sofiane.applications.dto.RealisateurDto;
import fr.sofiane.applications.service.RealisateurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 29/10/2016.
 */

@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

    @Autowired
    RealisateurService realisateurService;

    @RequestMapping(method = RequestMethod.GET)
    public List<RealisateurDto> getRealisateurs() {
        return realisateurService.getRealisateurs();
    }

    @RequestMapping(value = "/{idRealisateur}" ,method = RequestMethod.GET)
    public RealisateurDto getRealisateur(@PathVariable("idRealisateur") Long id) {
        return realisateurService.getRealisateur(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public List<RealisateurDto> addRealisateur(@RequestBody Map<String, Object> realisateur) throws java.text.ParseException {
        return realisateurService.addRealisateur(realisateur);
    }

    @RequestMapping(value = "/delete/{idRealisateur}", method = RequestMethod.DELETE)
    public void deleteRealisateur(@PathVariable("idRealisateur") Long id){
        realisateurService.deleteRealisateur(id);
    }

    @RequestMapping(value = "/update/{idRealisateur}", method = RequestMethod.PUT)
    public void updateRealisateur(@PathVariable("idRealisateur") Long id, @RequestBody Map<String, Object> realisateur) throws java.text.ParseException {
        realisateurService.updateRealisateur(id, realisateur);
    }
}
