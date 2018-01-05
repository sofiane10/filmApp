package fr.sofiane.applications.controller;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.dto.FilmDto;
import fr.sofiane.applications.repository.FilmRepository;
import fr.sofiane.applications.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by Sofiane on 29/10/2016.
 */

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    FilmService filmService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<FilmDto> getFilms(){
        return filmService.getFilms();
    }

    @RequestMapping(value = "/{idFilm}", method = RequestMethod.GET)
    public FilmDto getFilm(@PathVariable("idFilm") Long id ){
        return filmService.getFilm(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public List<FilmDto> addFilm(@RequestBody Map<String, Object> filmDto) throws ParseException {
        return filmService.add(filmDto);
    }

}
