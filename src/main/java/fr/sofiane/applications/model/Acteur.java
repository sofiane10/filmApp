package fr.sofiane.applications.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sofiane on 24/10/2016.
 */
@Entity(name = "acteur")
@Table(name = "acteur")
public class Acteur extends Personne {

    @Column(name = "film")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
