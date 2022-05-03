package net.cabezudo.xal.challenge.services;

import java.util.Optional;
import net.cabezudo.xal.challenge.database.entities.StateEntity;
import net.cabezudo.xal.challenge.database.repositories.StateRepository;
import net.cabezudo.xal.challenge.domain.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Service
class StateService {

  @Autowired
  StateRepository stateRepository;

  @Transactional
  State save(State state) {
    StateEntity stateEntity = new StateEntity(state);
    stateEntity = stateRepository.save(stateEntity);
    return new State(stateEntity);
  }

  @Transactional
  State getByCode(String code) {
    Optional<StateEntity> optionalStateEntity = stateRepository.findByCode(code);
    StateEntity stateEntity = optionalStateEntity.orElseGet(() -> stateRepository.save(new StateEntity(code)));
    return new State(stateEntity);
  }
}
