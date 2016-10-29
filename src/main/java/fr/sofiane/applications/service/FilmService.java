package fr.sofiane.applications.service;

import fr.sofiane.applications.dto.FilmDto;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 29/10/2016.
 */
public interface FilmService {

    List<FilmDto> getFilms();
    FilmDto getFilm(Long id);
    List<FilmDto> add(Map<String, Object> film) throws ParseException;
    void updateFilm(Map<String, Object> film);
    void delete(Long id);
}
