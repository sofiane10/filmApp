package fr.sofiane.applications.service;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.model.Acteur;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 21/10/2016.
 */
public interface ActeurService {

    List<ActeurDto> getActeurs();

    ActeurDto getActeur(Long id) throws Exception;

    List<ActeurDto> addActeur(Map<String, Object> acteur) throws ParseException, Exception;

    void updateActeur(Long id, Map<String, Object> acteur) throws ParseException;

    void deleteActeur(Acteur p);

    void deleteActeur(Long id);

}
