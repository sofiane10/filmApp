package fr.sofiane.applications.service.impl;

import fr.sofiane.applications.dto.RealisateurDto;
import fr.sofiane.applications.enums.TypePersonneEnum;
import fr.sofiane.applications.helper.PersonneHelper;
import fr.sofiane.applications.model.Realisateur;
import fr.sofiane.applications.repository.RealisateurRepository;
import fr.sofiane.applications.service.RealisateurService;
import fr.sofiane.applications.transformer.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static fr.sofiane.applications.enums.TypePersonneEnum.REALISATEUR;

/**
 * Created by Sofiane on 29/10/2016.
 */

@Service
public class RealisateurServiceImpl implements RealisateurService {

    @Autowired
    RealisateurRepository realisateurRepository;

    @Autowired
    Transformers transformers;

    @Override
    public List<RealisateurDto> getRealisateurs() {
        List<RealisateurDto> realisateurDtos = transformers.convertRealisateursToRealisateurDtoList((List<Realisateur>)realisateurRepository.findAll());
        setAgeFromRealisateurListDto(realisateurDtos);
        return realisateurDtos;
    }

    @Override
    public RealisateurDto getRealisateur(Long id) {
        RealisateurDto realisateurDto = transformers.convertRealisateurToRealisateurDto(realisateurRepository.findOne(id));
        if (realisateurDto.getDateOfBirth() != null) {
            realisateurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(realisateurDto.getDateOfBirth()));
        }
        return realisateurDto;
    }

    @Override
    public List<RealisateurDto> addRealisateur(Map<String, Object> r) throws ParseException {
        List<RealisateurDto> realisateurs = getRealisateurs();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse((String) r.get("dateOfBirth"));

        Realisateur realisateur = new Realisateur();
        realisateur.setNom((String) r.get("nom"));
        realisateur.setPrenom((String) r.get("prenom"));
        realisateur.setDateOfBirth(date);
        realisateur.setTypePersonne(REALISATEUR);
        //acteur.setFilms((List<Film>)a.get("films"));
        RealisateurDto realisateurDto = transformers.convertRealisateurToRealisateurDto(realisateurRepository.save(realisateur));
        realisateurDto.setDateOfBirth(date);
        realisateurs.add(realisateurDto);
        setAgeFromRealisateurListDto(realisateurs);

        return realisateurs;
    }

    @Override
    public void updateRealisateur(Long id, Map<String, Object> r) throws ParseException {
        Realisateur realisateur = realisateurRepository.findOne(id);

        if (!r.get("nom").equals("")) {
            realisateur.setNom((String) r.get("nom"));
        }
        if (!r.get("prenom").equals("")) {
            realisateur.setPrenom((String) r.get("prenom"));
        }
        if (!r.get("dateOfBirth").equals("")) {
            String datetext = (String) r.get("dateOfBirth");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(datetext);
            realisateur.setDateOfBirth(date);
        }
        realisateurRepository.save(realisateur);
    }

    @Override
    public void deleteRealisateur(Realisateur r) {
        realisateurRepository.delete(r);
    }

    @Override
    public void deleteRealisateur(Long id) {
        realisateurRepository.delete(id);
    }
    private void setAgeFromRealisateurListDto(List<RealisateurDto> realisateurs) {
        realisateurs.forEach(realisateurDto -> {
            if (realisateurDto.getDateOfBirth() != null) {
                realisateurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(realisateurDto.getDateOfBirth()));
            }
        });
    }

}
