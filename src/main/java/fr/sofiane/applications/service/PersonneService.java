package fr.sofiane.applications.service;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.model.Personne;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 21/10/2016.
 */
public interface PersonneService {

    List<ActeurDto> getPersonnes();

    ActeurDto getOne(Long id);

    List<ActeurDto> add(Map<String, Object> personne) throws ParseException;

    void update(Long id, Map<String, Object> personne) throws ParseException;

    void delete(Personne p);

    void delete(Long id);

}
