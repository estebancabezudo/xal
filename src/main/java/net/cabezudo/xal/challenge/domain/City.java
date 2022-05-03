package net.cabezudo.xal.challenge.domain;

import java.io.Serializable;
import lombok.Getter;
import net.cabezudo.xal.challenge.database.entities.*;

@Getter
public class City implements Serializable, Comparable<City> {

  private final Integer id;
  private final String name;

  public City(CityEntity entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }

  public City(String name) {
    this.id = null;
    this.name = name;
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", name=" + name + " ]";
  }

  @Override
  public int compareTo(City o) {
    return name.compareTo(o.name);
  }
}
