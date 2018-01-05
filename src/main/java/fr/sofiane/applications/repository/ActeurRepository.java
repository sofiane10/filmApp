package fr.sofiane.applications.repository;

import fr.sofiane.applications.model.Acteur;
import fr.sofiane.applications.model.Film;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Sofiane on 24/10/2016.
 */
public interface ActeurRepository extends PagingAndSortingRepository<Acteur, Long> {
/*
    @Query(nativeQuery = true, value = "select f.* from film f where id IN (select film from film_acteurs where acteurs = 1)")
    Iterable<Film> findFilmsByActeurId(Long id);
    */
	
	@Query(nativeQuery = true, value = "SELECT f.* FROM film f inner join film_acteurs a on f.id = a.film where acteurs=:idActeur")
    List<Film> findFilmsByActeurId(@Param("idActeur") long id);
	
	@Query(nativeQuery = true, value = "SELECT f.films FROM film_acteurs f where acteurs=:idActeur")
    List<Long> getAllFilmIdFromActeurId(@Param("idActeur") long id);
	
}
