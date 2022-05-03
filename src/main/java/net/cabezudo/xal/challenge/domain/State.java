package net.cabezudo.xal.challenge.domain;

import lombok.Getter;
import net.cabezudo.xal.challenge.database.entities.StateEntity;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Getter
public class State {

  private final Integer id;
  private final String code;

  public State(StateEntity entity) {
    this.id = entity.getId();
    this.code = entity.getCode();
  }

  public State(String code) {
    this.id = null;
    this.code = code;
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", code=" + code + " ]";
  }
}
