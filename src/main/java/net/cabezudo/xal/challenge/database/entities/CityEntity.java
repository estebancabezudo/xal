package net.cabezudo.xal.challenge.database.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.cabezudo.xal.challenge.domain.City;

@Entity
@Table(name = "city")
@Getter
@NoArgsConstructor
public class CityEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  CityEntity(City city) {
    this.id = city.getId();
    this.name = city.getName();
  }

  public CityEntity(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", name=" + name + " ]";
  }

}
