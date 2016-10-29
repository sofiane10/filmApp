package fr.sofiane.applications.transformer;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.dto.FilmDto;
import fr.sofiane.applications.dto.RealisateurDto;
import fr.sofiane.applications.enums.CategorieFilmEnum;
import fr.sofiane.applications.helper.PersonneHelper;
import fr.sofiane.applications.model.Acteur;
import fr.sofiane.applications.model.CategorieFilm;
import fr.sofiane.applications.model.Film;
import fr.sofiane.applications.model.Realisateur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static fr.sofiane.applications.enums.CategorieFilmEnum.*;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Component(value = "transformers")
public class Transformers {

    private CategorieFilmEnum categorieFilmEnum;
    ModelMapper modelMapper = new ModelMapper();


    //Generic

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

    // POUR LES ACTEURS
    public List<ActeurDto> convertActeursToActeurDtoList(List<Acteur> acteurs) {
        List<ActeurDto> acteurDtos = new ArrayList<>();
        acteurs.forEach(acteur -> {
            ActeurDto acteurDto = new ActeurDto();
            acteurDto.setId(acteur.getId());
            acteurDto.setNom(acteur.getNom());
            acteurDto.setPrenom(acteur.getPrenom());
            acteurDto.setDateOfBirth(acteur.getDateOfBirth());
            acteurDto.setFilmDtos(getFilmDtosFromActeur(acteur));
            acteurDtos.add(acteurDto);
        });
        return acteurDtos;
    }

    public ActeurDto convertActeurToActeurDto(Acteur acteur) {
        ActeurDto acteurDto = new ActeurDto();
        acteurDto.setId(acteur.getId());
        acteurDto.setNom(acteur.getNom());
        acteurDto.setPrenom(acteur.getPrenom());
        acteurDto.setDateOfBirth(acteur.getDateOfBirth());
        acteurDto.setFilmDtos(getFilmDtosFromActeur(acteur));

        return acteurDto;
    }

    public List<FilmDto> getFilmDtosFromActeur(Acteur acteur) {
        List<FilmDto> filmDtos = new ArrayList<>();
        if (acteur.getFilms() != null) {
            acteur.getFilms().forEach(film -> {
                FilmDto filmDto = new FilmDto();
                filmDto.setId(film.getId());
                filmDto.setTitre(film.getTitre());
                filmDto.setDuree(film.getDuree());
                filmDto.setDateDeSortie(film.getDateDeSortie());
                filmDtos.add(filmDto);
            });
        }
        return filmDtos;
    }


    //Pour les REALISATEURS
    public List<RealisateurDto> convertRealisateursToRealisateurDtoList(List<Realisateur> realisateurs) {
        List<RealisateurDto> realisateurDtos = new ArrayList<>();
        realisateurs.forEach(realisateur -> {
            RealisateurDto realisateurDto = new RealisateurDto();
            realisateurDto.setId(realisateur.getId());
            realisateurDto.setNom(realisateur.getNom());
            realisateurDto.setPrenom(realisateur.getPrenom());
            realisateurDto.setDateOfBirth(realisateur.getDateOfBirth());
            realisateurDto.setFilmDtos(getFilmDtosFromRealisateur(realisateur));
            realisateurDtos.add(realisateurDto);
        });
        return realisateurDtos;
    }


    public RealisateurDto convertRealisateurToRealisateurDto(Realisateur realisateur) {
        RealisateurDto realisateurDto = new RealisateurDto();
        realisateurDto.setId(realisateur.getId());
        realisateurDto.setNom(realisateur.getNom());
        realisateurDto.setPrenom(realisateur.getPrenom());
        realisateurDto.setDateOfBirth(realisateur.getDateOfBirth());
        realisateurDto.setFilmDtos(getFilmDtosFromRealisateur(realisateur));

        return realisateurDto;
    }

    public List<FilmDto> getFilmDtosFromRealisateur(Realisateur realisateur) {
        List<FilmDto> filmDtos = new ArrayList<>();

        if (realisateur.getFilms() != null) {
            realisateur.getFilms().forEach(film -> {
                FilmDto filmDto = new FilmDto();
                filmDto.setId(film.getId());
                filmDto.setTitre(film.getTitre());
                filmDto.setDuree(film.getDuree());
                filmDto.setDateDeSortie(film.getDateDeSortie());
                filmDtos.add(filmDto);
            });
        }
        return filmDtos;
    }


    //POUR LES FILMS

    public List<FilmDto> convertFilmsToFilmDtoList(List<Film> f) {
        List<FilmDto> filmDtos = new ArrayList<>();
        FilmDto filmDto = new FilmDto();
        f.forEach(film -> {
            filmDto.setId(film.getId());
            filmDto.setTitre(film.getTitre());
            filmDto.setDuree(film.getDuree());
            filmDto.setDateDeSortie(film.getDateDeSortie());
            filmDto.setAnneeDeProduction(PersonneHelper.getInstance().dateToLocalDate(film.getAnneeDeProduction()).getYear());
            filmDto.setActeurDtos(convertActeursToActeurDtoList(film.getActeurs()));
            filmDto.setRealisateurDtos(convertRealisateursToRealisateurDtoList(film.getRealisateurs()));
            filmDto.setCategoriesFilm(setCategorieFilmEnumFromCategorieFilm(film.getCategorieFilms()));
            filmDtos.add(filmDto);
        });
        return filmDtos;
    }


    private List<CategorieFilmEnum> setCategorieFilmEnumFromCategorieFilm(List<CategorieFilm> categorieFilms) {
        List<CategorieFilmEnum> categorieFilmEna = new ArrayList<>();
        categorieFilms.forEach(categorieFilm -> {
            switch (categorieFilm.getCategorieFilm().name()) {
                case "ACTION":
                    this.categorieFilmEnum = ACTION;
                    break;
                case "HORREUR":
                    this.categorieFilmEnum = HORREUR;
                    break;
                case "THRILLER":
                    this.categorieFilmEnum = THRILLER;
                    break;
                case "COMEDIE":
                    this.categorieFilmEnum = COMEDIE;
                    break;
                case "DRAME":
                    this.categorieFilmEnum = DRAME;
                    break;
                case "ANIMATION":
                    this.categorieFilmEnum = ANIMATION;
                    break;
                case "POLICIER":
                    this.categorieFilmEnum = POLICIER;
                    break;
                case "ESPIONNAGE":
                    this.categorieFilmEnum = ESPIONNAGE;
                    break;
                case "FANTASTIQUE":
                    this.categorieFilmEnum = FANTASTIQUE;
                    break;
                case "SCIENCE_FICTION":
                    this.categorieFilmEnum = SCIENCE_FICTION;
                    break;
            }
            categorieFilmEna.add(this.categorieFilmEnum);
        });
        return categorieFilmEna;
    }
}
