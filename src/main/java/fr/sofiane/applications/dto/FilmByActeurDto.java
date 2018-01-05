package fr.sofiane.applications.dto;

import java.util.Date;

public class FilmByActeurDto {
	
	private Long id;
    private String titre;
    private Double duree;
    private Date dateDeSortie;
    private Date anneeDeProduction;
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
	public Date getAnneeDeProduction() {
		return anneeDeProduction;
	}
	public void setAnneeDeProduction(Date anneeDeProduction) {
		this.anneeDeProduction = anneeDeProduction;
	}
    
    

}
