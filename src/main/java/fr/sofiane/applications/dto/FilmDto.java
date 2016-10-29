package fr.sofiane.applications.dto;

import fr.sofiane.applications.enums.CategorieFilmEnum;

import java.util.Date;
import java.util.List;

/**
 * Created by Sofiane on 25/10/2016.
 */
public class FilmDto {

    private Long id;
    private String titre;
    private Double duree;
    private Date dateDeSortie;
    private Integer anneeDeProduction;

    private List<ActeurDto> acteurDtos;
    private List<RealisateurDto> realisateurDtos;
    private List<CategorieFilmEnum> categoriesFilm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public Date getDateDeSortie() {
        return dateDeSortie;
    }

    public void setDateDeSortie(Date dateDeSortie) {
        this.dateDeSortie = dateDeSortie;
    }

    public Integer getAnneeDeProduction() {
        return anneeDeProduction;
    }

    public void setAnneeDeProduction(Integer anneeDeProduction) {
        this.anneeDeProduction = anneeDeProduction;
    }

    public List<ActeurDto> getActeurDtos() {
        return acteurDtos;
    }

    public void setActeurDtos(List<ActeurDto> acteurDtos) {
        this.acteurDtos = acteurDtos;
    }

    public List<RealisateurDto> getRealisateurDtos() {
        return realisateurDtos;
    }

    public void setRealisateurDtos(List<RealisateurDto> realisateurDtos) {
        this.realisateurDtos = realisateurDtos;
    }

    public List<CategorieFilmEnum> getCategoriesFilm() {
        return categoriesFilm;
    }

    public void setCategoriesFilm(List<CategorieFilmEnum> categoriesFilm) {
        this.categoriesFilm = categoriesFilm;
    }
}
