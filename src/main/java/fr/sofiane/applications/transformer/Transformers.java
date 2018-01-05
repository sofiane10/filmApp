package fr.sofiane.applications.transformer;

import fr.sofiane.applications.dto.ActeurDto;
import fr.sofiane.applications.dto.FilmByActeurDto;
import fr.sofiane.applications.dto.FilmDto;
import fr.sofiane.applications.dto.RealisateurDto;
import fr.sofiane.applications.enums.CategorieFilmEnum;
import fr.sofiane.applications.helper.PersonneHelper;
import fr.sofiane.applications.model.Acteur;
import fr.sofiane.applications.model.CategorieFilm;
import fr.sofiane.applications.model.Film;
import fr.sofiane.applications.model.Realisateur;
import fr.sofiane.applications.repository.ActeurRepository;
import fr.sofiane.applications.repository.FilmRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static fr.sofiane.applications.enums.CategorieFilmEnum.*;
import static fr.sofiane.applications.enums.TypePersonneEnum.ACTEUR;
import static fr.sofiane.applications.enums.TypePersonneEnum.REALISATEUR;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Component(value = "transformers")
public class Transformers {

    private CategorieFilmEnum categorieFilmEnum;
    ModelMapper modelMapper = new ModelMapper();
    
    @Autowired
    FilmRepository filmRepository;


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
        	Iterable<Film> filmIt = filmRepository.findFilmsByActeurId(acteur.getId());
        	List<FilmByActeurDto> filmByActeurDtos = convertFilmToFilmByActeurDto(filmIt);
            ActeurDto acteurDto = new ActeurDto();
            acteurDto.setId(acteur.getId());
            acteurDto.setNom(acteur.getNom());
            acteurDto.setPrenom(acteur.getPrenom());
            acteurDto.setDateOfBirth(acteur.getDateOfBirth());
            acteurDto.setFilmDtos(filmByActeurDtos);
            acteurDtos.add(acteurDto);
        });
        return acteurDtos;
    }
    
    public List<FilmByActeurDto> convertFilmToFilmByActeurDto(Iterable<Film> filmIt){
    	List<FilmByActeurDto> filmByActeurDto = new ArrayList<>();
    	filmIt.forEach( film -> {
    		FilmByActeurDto f = new FilmByActeurDto();
    		f.setId(film.getId());
    		f.setTitre(film.getTitre());
    		f.setDuree(film.getDuree());
    		f.setDateDeSortie(film.getDateDeSortie());
    		f.setAnneeDeProduction(film.getAnneeDeProduction());  		
    		filmByActeurDto.add(f);
    	});
    	return filmByActeurDto;
    }

    public ActeurDto convertActeurToActeurDto(Acteur acteur) throws Exception {
    	ActeurDto acteurDto = new ActeurDto();
    	try {
            acteurDto.setId(acteur.getId());
            acteurDto.setNom(acteur.getNom());
            acteurDto.setPrenom(acteur.getPrenom());
            acteurDto.setDateOfBirth(acteur.getDateOfBirth());
            //acteurDto.setFilmDtos(this.convertFilmsToFilmDtoList(acteur.getFilms()));
		} catch (Exception e) {
			throw new Exception("rien");
		}
    	return acteurDto;
        


        
    }
    /*
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
*/

    //Pour les REALISATEURS
    public List<RealisateurDto> convertRealisateursToRealisateurDtoList(List<Realisateur> realisateurs) {
        List<RealisateurDto> realisateurDtos = new ArrayList<>();
        realisateurs.forEach(realisateur -> {
            RealisateurDto realisateurDto = new RealisateurDto();
            realisateurDto.setId(realisateur.getId());
            realisateurDto.setNom(realisateur.getNom());
            realisateurDto.setPrenom(realisateur.getPrenom());
            realisateurDto.setDateOfBirth(realisateur.getDateOfBirth());
            //realisateurDto.setFilmDtos(getFilmDtosFromRealisateur(realisateur));
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
        //realisateurDto.setFilmDtos(getFilmDtosFromRealisateur(realisateur));

        return realisateurDto;
    }
/*
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
*/

    //POUR LES FILMS

    public List<FilmDto> convertFilmsToFilmDtoList(Iterable<Film> iterable) {
        List<FilmDto> filmDtos = new ArrayList<>();
        iterable.forEach(film -> {
            FilmDto filmDto = new FilmDto();
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
    
    public List<FilmDto> convertFilmByActeurFilmsListToFilmDtoList(List<FilmByActeurDto> filmListByActeur){
    	List<FilmDto> films = new ArrayList<>();
    	
    	
    	
    	return films;
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


    public List<Acteur> convertActeurDtoListToEntityList(List<Map<String, Object>> list) throws ParseException {
        List<Acteur> acteurs = new ArrayList<>();


        list.forEach(element -> {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Acteur acteur = new Acteur();

            acteur.setNom((String) element.get("nom"));
            acteur.setPrenom((String) element.get("prenom"));
            try {
                acteur.setDateOfBirth(dateFormat.parse((String) element.get("dateOfBirth")));
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            acteurs.add(acteur);
        });
        return acteurs;
    }

    public List<Realisateur> convertRealisateurDtoListToEntityList(List<Map<String, Object>> list) throws ParseException {
        List<Realisateur> realisateurs = new ArrayList<>();

        list.forEach(element -> {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Realisateur realisateur = new Realisateur();

            realisateur.setNom((String) element.get("nom"));
            realisateur.setPrenom((String) element.get("prenom"));
            try {
                realisateur.setDateOfBirth(dateFormat.parse((String) element.get("dateOfBirth")));
            } catch (java.text.ParseException e) {
                e.printStackTrace();
            }
            realisateurs.add(realisateur);
        });
        return realisateurs;
    }

    public List<CategorieFilm> convertCategoriesFilmEnumToEntityList(List<String> listCategories){
        List<CategorieFilm> categoriesFilm = new ArrayList<>();
        listCategories.forEach(s -> {
            categoriesFilm.add(getCategorieFilmFromString(s));
        });

        return categoriesFilm;
    }

    private CategorieFilm getCategorieFilmFromString (String s){
        CategorieFilm categorieFilm = new CategorieFilm();
        switch (s) {
            case "ACTION":
                categorieFilm.setCategorieFilm(ACTION);
                break;
            case "HORREUR":
                categorieFilm.setCategorieFilm(HORREUR);
                break;
            case "THRILLER":
                categorieFilm.setCategorieFilm(THRILLER);
                break;
            case "COMEDIE":
                categorieFilm.setCategorieFilm(COMEDIE);
                break;
            case "DRAME":
                categorieFilm.setCategorieFilm(DRAME);
                break;
            case "ANIMATION":
                categorieFilm.setCategorieFilm(ANIMATION);
                break;
            case "POLICIER":
                categorieFilm.setCategorieFilm(POLICIER);
                break;
            case "ESPIONNAGE":
                categorieFilm.setCategorieFilm(ESPIONNAGE);
                break;
            case "FANTASTIQUE":
                categorieFilm.setCategorieFilm(FANTASTIQUE);
                break;
            case "SCIENCE_FICTION":
                categorieFilm.setCategorieFilm(SCIENCE_FICTION);
                break;
        }
        return categorieFilm;
    }
}
