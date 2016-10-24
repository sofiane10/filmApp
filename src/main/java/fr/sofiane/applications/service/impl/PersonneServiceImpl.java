package fr.sofiane.applications.service.impl;

import fr.sofiane.applications.dto.PersonneDto;
import fr.sofiane.applications.helper.PersonneHelper;
import fr.sofiane.applications.model.Personne;
import fr.sofiane.applications.repository.PersonneRepository;
import fr.sofiane.applications.service.PersonneService;
import fr.sofiane.applications.transformer.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
    public List<PersonneDto> getPersonnes() {
        List<PersonneDto> personneDtos = transformers.convertToListDto(personneRepository.findAll(), PersonneDto.class);
        personneDtos.forEach(personneDto -> {
            if (personneDto.getDateOfBirth() != null) {
                personneDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(personneDto.getDateOfBirth()));
            }
        });
        return personneDtos;
    }

    @Override
    public PersonneDto getOne(Long id) {
        PersonneDto personneDto = (PersonneDto) transformers.convertToDto(personneRepository.findOne(id), PersonneDto.class);
        if (personneDto.getDateOfBirth() != null) {
            personneDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(personneDto.getDateOfBirth()));
        }
        return personneDto;
    }

    @Override
    public List<PersonneDto> add(Map<String, Object> p) throws ParseException {
        List<Personne> personnes = (List) personneRepository.findAll();
        DateFormat dateFormat = new SimpleDateFormat();
        Date date = dateFormat.parse((String) p.get("dateOfBirth"));

        Personne personne = new Personne();
        personne.setNom((String) p.get("nom"));
        personne.setPrenom((String) p.get("prenom"));
        personne.setDateOfBirth(date);
        List<PersonneDto> personneDtos = transformers.convertToListDto(personneRepository.save(personnes), PersonneDto.class);
        personneDtos.forEach(personneDto ->{
            if(personneDto.getDateOfBirth() != null) {
                personneDto.setAge(PersonneHelper.getInstance().calculateAgeFromDateOfBirth(date));
            }
        });
        return personneDtos;
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
