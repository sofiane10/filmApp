package fr.sofiane.applications.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by Sofiane on 25/10/2016.
 */
public class RealisateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private Integer age;
    private Date dateOfBirth;
    private List<FilmDto> filmDtos;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<FilmDto> getFilmDtos() {
        return filmDtos;
    }

    public void setFilmDtos(List<FilmDto> filmDtos) {
        this.filmDtos = filmDtos;
    }
}
