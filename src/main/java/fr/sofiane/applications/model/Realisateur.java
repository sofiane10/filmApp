package fr.sofiane.applications.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import fr.sofiane.applications.enums.TypePersonneEnum;

import java.util.Date;
import java.util.List;

/**
 * Created by Sofiane on 24/10/2016.
 */
@Entity(name = "realisateur")
@Table(name = "realisateur")
public class Realisateur{
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "id")
	    private Long id;

	    @Version
	    @Column(name = "version")
	    private Integer version;

	    @NotNull
	    private String nom;

	    @NotNull
	    private String prenom;

	    @NotNull
	    @Temporal(TemporalType.DATE)
	    private Date dateOfBirth;
	    
//	    @Column(name = "film")
//	    @OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
//	    private List<Film> films;

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
//
//		public List<Film> getFilms() {
//			return films;
//		}
//	    
	    

}
