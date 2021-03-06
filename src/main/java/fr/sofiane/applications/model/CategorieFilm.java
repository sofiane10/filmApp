package fr.sofiane.applications.model;

import fr.sofiane.applications.enums.CategorieFilmEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sofiane on 24/10/2016.
 */

@Entity(name = "categorie_film")
@Table(name = "categorie_film")
public class CategorieFilm{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "categorie", nullable = false)
    private CategorieFilmEnum categorieFilm;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public CategorieFilmEnum getCategorieFilm() {
        return categorieFilm;
    }

    public void setCategorieFilm(CategorieFilmEnum categorieFilm) {
        this.categorieFilm = categorieFilm;
    }
    
    
}
