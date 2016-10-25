package fr.sofiane.applications.repository;

import fr.sofiane.applications.model.Acteur;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Sofiane on 24/10/2016.
 */
public interface ActeurRepository extends PagingAndSortingRepository<Acteur, Long> {
}
