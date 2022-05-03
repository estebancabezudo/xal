package net.cabezudo.xal.challenge.database.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.cabezudo.xal.challenge.domain.State;

@Entity
@Table(name = "states", uniqueConstraints = @UniqueConstraint(name = "code_uk", columnNames = "code"))

@Getter
@NoArgsConstructor
public class StateEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true)
  private String code;

  public StateEntity(String code) {
    this.code = code;
  }

  public StateEntity(State state) {
    this.id = state.getId();
    this.code = state.getCode();
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", code=" + code + " ]";
  }
}
