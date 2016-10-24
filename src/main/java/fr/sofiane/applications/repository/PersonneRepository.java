package fr.sofiane.applications.repository;

import fr.sofiane.applications.model.Personne;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by Sofiane on 21/10/2016.
 */
public interface PersonneRepository extends PagingAndSortingRepository<Personne, Long> {

}
