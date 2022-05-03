package net.cabezudo.xal.challenge.database.repositories;

import net.cabezudo.xal.challenge.database.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}
