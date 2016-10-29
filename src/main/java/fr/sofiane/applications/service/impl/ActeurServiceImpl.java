package fr.sofiane.applications.service.impl;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.enums.TypePersonneEnum;
import fr.sofiane.applications.helper.PersonneHelper;
import fr.sofiane.applications.model.Acteur;
import fr.sofiane.applications.model.Film;
import fr.sofiane.applications.model.Personne;
import fr.sofiane.applications.repository.ActeurRepository;
import fr.sofiane.applications.service.ActeurService;
import fr.sofiane.applications.transformer.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static fr.sofiane.applications.enums.TypePersonneEnum.ACTEUR;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Service
public class ActeurServiceImpl implements ActeurService {

    @Autowired
    ActeurRepository acteurRepository;

    @Autowired
    Transformers transformers;

    @Override
    public List<ActeurDto> getActeurs() {
        List<ActeurDto> acteurDtos = transformers.convertActeursToActeurDtoList((List<Acteur>)acteurRepository.findAll());
        setAgeFromActeurListDto(acteurDtos);
        return acteurDtos;
    }

    @Override
    public ActeurDto getActeur(Long id) {
        ActeurDto acteurDto = transformers.convertActeurToActeurDto(acteurRepository.findOne(id));
        if (acteurDto.getDateOfBirth() != null) {
            acteurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(acteurDto.getDateOfBirth()));
        }
        return acteurDto;
    }

    @Override
    public List<ActeurDto> addActeur(Map<String, Object> a) throws ParseException {

        List<ActeurDto> acteurs = getActeurs();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse((String) a.get("dateOfBirth"));

        Acteur acteur = new Acteur();
        acteur.setNom((String) a.get("nom"));
        acteur.setPrenom((String) a.get("prenom"));
        acteur.setDateOfBirth(date);
        acteur.setTypePersonne(ACTEUR);
        //acteur.setFilms((List<Film>)a.get("films"));
        ActeurDto acteurDto = transformers.convertActeurToActeurDto(acteurRepository.save(acteur));
        acteurDto.setDateOfBirth(date);
        acteurs.add(acteurDto);
        setAgeFromActeurListDto(acteurs);

        return acteurs;
    }

    @Override
    public void updateActeur(Long id, Map<String, Object> p) throws ParseException {
        Acteur acteur = acteurRepository.findOne(id);

        if (!p.get("nom").equals("")) {
            acteur.setNom((String) p.get("nom"));
        }
        if (!p.get("prenom").equals("")) {
            acteur.setPrenom((String) p.get("prenom"));
        }
        if (!p.get("dateOfBirth").equals("")) {
            String datetext = (String) p.get("dateOfBirth");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(datetext);
            acteur.setDateOfBirth(date);
        }
        acteurRepository.save(acteur);
    }

    @Override
    public void deleteActeur(Acteur p) {
        acteurRepository.delete(p);
    }

    @Override
    public void deleteActeur(Long id) {
        acteurRepository.delete(id);
    }

    private void setAgeFromActeurListDto(List<ActeurDto> acteurs) {
        acteurs.forEach(acteurDto -> {
            if (acteurDto.getDateOfBirth() != null) {
                acteurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(acteurDto.getDateOfBirth()));
            }
        });
    }
}
