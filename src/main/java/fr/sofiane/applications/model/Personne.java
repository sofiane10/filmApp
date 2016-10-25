package fr.sofiane.applications.model;

import fr.sofiane.applications.enums.TypePersonneEnum;
import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Sofiane on 21/10/2016.
 */

@MappedSuperclass
public abstract class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version" )
    private Integer version= 0;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_personne")
    @NotNull
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
