package fr.sofiane.applications.service.impl;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.helper.PersonneHelper;
import fr.sofiane.applications.model.Acteur;
import fr.sofiane.applications.model.Personne;
import fr.sofiane.applications.repository.PersonneRepository;
import fr.sofiane.applications.service.PersonneService;
import fr.sofiane.applications.transformer.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Service
public class PersonneServiceImpl implements PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    Transformers transformers;

    @Override
    public List<ActeurDto> getPersonnes() {
        List<ActeurDto> acteurDtos = transformers.convertToListDto(personneRepository.findAll(), ActeurDto.class);
        acteurDtos.forEach(acteurDto -> {
            if (acteurDto.getDateOfBirth() != null) {
                acteurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(acteurDto.getDateOfBirth()));
            }
        });
        return acteurDtos;
    }

    @Override
    public ActeurDto getOne(Long id) {
        ActeurDto acteurDto = (ActeurDto) transformers.convertToDto(personneRepository.findOne(id), ActeurDto.class);
        if (acteurDto.getDateOfBirth() != null) {
            acteurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(acteurDto.getDateOfBirth()));
        }
        return acteurDto;
    }

    @Override
    public List<ActeurDto> add(Map<String, Object> p) throws ParseException {

        List<Personne> personnes = (List) personneRepository.findAll();
        DateFormat dateFormat = new SimpleDateFormat();
        Date date = dateFormat.parse((String) p.get("dateOfBirth"));

        Personne personne = new Acteur();
        personne.setNom((String) p.get("nom"));
        personne.setPrenom((String) p.get("prenom"));
        personne.setDateOfBirth(date);
        List<ActeurDto> acteurDtos = transformers.convertToListDto(personneRepository.save(personnes), ActeurDto.class);
        acteurDtos.forEach(acteurDto ->{
            if(acteurDto.getDateOfBirth() != null) {
                acteurDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(date));
            }
        });
        return acteurDtos;
    }

    @Override
    public void update(Long id, Map<String, Object> p) throws ParseException {
        Personne personne = personneRepository.findOne(id);

        if (!p.get("nom").equals("")) {
            personne.setNom((String) p.get("nom"));
        }
        if (!p.get("prenom").equals("")) {
            personne.setPrenom((String) p.get("prenom"));
        }
        if (!p.get("dateOfBirth").equals("")) {
            String datetext = (String) p.get("dateOfBirth");
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse(datetext);
            personne.setDateOfBirth(date);
        }
        personneRepository.save(personne);
    }

    @Override
    public void delete(Personne p) {
        personneRepository.delete(p);
    }

    @Override
    public void delete(Long id) {
        personneRepository.delete(id);
    }
}
