package fr.sofiane.applications.model;

import fr.sofiane.applications.enums.TypePersonneEnum;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Sofiane on 21/10/2016.
 */

@Entity(name = "personne")
@Table(name = "personne")
public abstract class Personne extends CommonEntity {

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_personne")
    private TypePersonneEnum typePersonne;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public TypePersonneEnum getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(TypePersonneEnum typePersonne) {
        this.typePersonne = typePersonne;
    }
}
