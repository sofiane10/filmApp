package fr.sofiane.applications.service.impl;

import fr.sofiane.applications.dto.FilmDto;
import fr.sofiane.applications.model.Acteur;
import fr.sofiane.applications.model.Film;
import fr.sofiane.applications.repository.FilmRepository;
import fr.sofiane.applications.service.FilmService;
import fr.sofiane.applications.transformer.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 29/10/2016.
 */

@Service(value = "filmService")
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    Transformers transformers;

    @Override
    public List<FilmDto> getFilms() {
        return transformers.convertFilmsToFilmDtoList((List<Film>)filmRepository.findAll());
    }

    @Override
    public FilmDto getFilm(Long id) {
        return transformers.convertFilmsToFilmDtoList(Arrays.asList(filmRepository.findOne(id))).get(0);
    }

    //TODO: Finir l'ajout d'un film avec : From Map TO LIST
    @Override
    public List<FilmDto> add(Map<String, Object> f) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Film film = new Film();

        film.setTitre((String)f.get("titre"));
        film.setDuree((Double) f.get("duree"));
        film.setDateDeSortie(dateFormat.parse((String) f.get("dateDeSortie")));
        film.setAnneeDeProduction(dateFormat.parse((String) f.get("anneeDeProduction")));


        return null;
    }

    @Override
    public void updateFilm(Map<String, Object> film) {

    }

    @Override
    public void delete(Long id) {

    }
}
