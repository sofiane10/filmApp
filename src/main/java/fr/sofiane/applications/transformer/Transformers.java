package fr.sofiane.applications.transformer;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.dto.FilmDto;
import fr.sofiane.applications.model.Acteur;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Component
public class Transformers {

    ModelMapper modelMapper = new ModelMapper();

    public Object convertToDto(Object o, Class classe) {
        Object oDto = modelMapper.map(o, classe);
        return oDto;
    }

    public Object convertToEntity(Object oDto, Class classe) {
        Object o = modelMapper.map(oDto, classe);
        return o;
    }

    public List convertToListDto(Iterable iterable, Class classe) {
        ArrayList list = new ArrayList<>();
        if (iterable != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                list.add(convertToDto(it.next(), classe));
            }
        }
        return list;
    }

    public List<ActeurDto> convertActeurToActeurDtoList(List<Acteur> acteurs){
        List<ActeurDto> acteurDtos = new ArrayList<>();
        acteurs.forEach(acteur -> {
            ActeurDto acteurDto = new ActeurDto();
            acteurDto.setId(acteur.getId());
            acteurDto.setNom(acteur.getNom());
            acteurDto.setPrenom(acteur.getPrenom());
            acteurDto.setDateOfBirth(acteur.getDateOfBirth());
            List<FilmDto> filmDtos = new ArrayList<>();
            acteur.getFilms().forEach(film -> {
                FilmDto filmDto = new FilmDto();
                filmDto.setId(film.getId());
                filmDto.setTitre(film.getTitre());
                filmDto.setDuree(film.getDuree());
                filmDto.setDateDeSortie(film.getDateDeSortie());
                filmDtos.add(filmDto);
            });
            acteurDto.setFilmDtos(filmDtos);
            acteurDtos.add(acteurDto);
        });
        return acteurDtos;
    }
}
