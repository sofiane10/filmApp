package fr.sofiane.applications.model;

import fr.sofiane.applications.enums.CategorieFilmEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sofiane on 24/10/2016.
 */

@Entity(name = "categorie_film")
@Table(name = "categorie_film")
public class CategorieFilm extends CommonEntity{

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "categorie_film", nullable = false)
    private CategorieFilmEnum categorieFilm;

    public CategorieFilmEnum getCategorieFilm() {
        return categorieFilm;
    }

    public void setCategorieFilm(CategorieFilmEnum categorieFilm) {
        this.categorieFilm = categorieFilm;
    }
}
