package fr.sofiane.applications.service;

import fr.sofiane.applications.dto.RealisateurDto;
import fr.sofiane.applications.model.Realisateur;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 29/10/2016.
 */
public interface RealisateurService {

    List<RealisateurDto> getRealisateurs();

    RealisateurDto getRealisateur(Long id);

    List<RealisateurDto> addRealisateur(Map<String, Object> realisateur) throws ParseException;

    void updateRealisateur(Long id, Map<String, Object> realisateur) throws ParseException;

    void deleteRealisateur(Realisateur r);

    void deleteRealisateur(Long id);
}
