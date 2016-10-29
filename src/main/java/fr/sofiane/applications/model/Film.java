package fr.sofiane.applications.model;

import fr.sofiane.applications.enums.CategorieFilmEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Sofiane on 24/10/2016.
 */

@Entity(name = "film")
@Table(name = "film")
public class Film extends CommonEntity{

    @NotNull
    private String titre;

    @NotNull
    @Min(0)
    private Double duree;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_de_sortie")
    private Date dateDeSortie;

    @Temporal(TemporalType.DATE)
    @Column(name = "annee_de_production")
    private Date anneeDeProduction;

    @NotNull
    @Column(name = "acteur")
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private List<Acteur> acteurs;

    @NotNull
    @Column(name = "realisateur")
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private List<Realisateur> realisateurs;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie_film")
    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
    private List<CategorieFilm> categorieFilms;

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

    public Date getAnneeDeProduction() {
        return anneeDeProduction;
    }

    public void setAnneeDeProduction(Date anneeDeProduction) {
        this.anneeDeProduction = anneeDeProduction;
    }

    public List<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }

    public List<CategorieFilm> getCategorieFilms() {
        return categorieFilms;
    }

    public void setCategorieFilms(List<CategorieFilm> categorieFilms) {
        this.categorieFilms = categorieFilms;
    }
}
