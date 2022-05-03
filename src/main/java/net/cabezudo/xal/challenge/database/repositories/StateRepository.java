package net.cabezudo.xal.challenge.database.repositories;

import java.util.Optional;
import net.cabezudo.xal.challenge.database.entities.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Transactional(readOnly = true)
public interface StateRepository extends JpaRepository<StateEntity, Integer> {

  Optional<StateEntity> findByCode(String code);

  StateEntity save(String code);
}
