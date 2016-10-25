package fr.sofiane.applications.repository;

import fr.sofiane.applications.model.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Sofiane on 24/10/2016.
 */
public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
}
