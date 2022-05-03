package net.cabezudo.xal.challenge.domain;

import lombok.Getter;
import net.cabezudo.xal.challenge.database.entities.CompanyEntity;

@Getter
public class Company {

  private final Integer id;
  private final String name;
  private final String address;
  private final State state;
  private final City city;
  private final Integer zipCode;

  public Company(String name, String address, State state, City city, Integer zipCode) {
    this.id = null;
    this.name = name;
    this.address = address;
    this.state = state;
    this.city = city;
    this.zipCode = zipCode;
  }

  public Company(CompanyEntity entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.address = entity.getAddress();
    this.state = new State(entity.getState());
    this.city = new City(entity.getCity());
    this.zipCode = entity.getZipCode();
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", name=" + name + ", address=" + address + ", state=" + state + ", city=" + city + ", zip=" + zipCode + " ]";
  }

}
