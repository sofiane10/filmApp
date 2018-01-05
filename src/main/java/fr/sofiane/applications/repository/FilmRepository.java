package fr.sofiane.applications.repository;

import fr.sofiane.applications.model.Film;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Sofiane on 24/10/2016.
 */
public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
	
	//@Query(nativeQuery = true, value = "select f.* from film f where id IN (select film from film_acteurs where acteurs = 1)")
    //Iterable<Film> findFilmsByActeurId(Long id);
	
	@Query(nativeQuery = true, value = "select f.* from film f where id in(select film FROM film_acteurs where acteurs=:idActeur)")
    Iterable<Film> findFilmsByActeurId(@Param("idActeur") Long id);
	
}
