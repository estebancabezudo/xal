package net.cabezudo.xal.challenge.database.repositories;

import java.util.Optional;
import net.cabezudo.xal.challenge.database.entities.CompanyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {

  public Optional<CompanyEntity> findByName(String name);
}
