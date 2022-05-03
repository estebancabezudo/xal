package net.cabezudo.xal.challenge.database.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.cabezudo.xal.challenge.domain.City;
import net.cabezudo.xal.challenge.domain.Company;
import net.cabezudo.xal.challenge.domain.State;

@Entity
@Table(name = "company")
@Getter
@NoArgsConstructor
public class CompanyEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String address;

  @OneToOne
  @JoinColumn(name = "state_id", nullable = false)
  StateEntity state;

  @ManyToOne
  @JoinColumn(name = "city_id", nullable = false)
  CityEntity city;

  @Column(name = "zip_code")
  private Integer zipCode;

  CompanyEntity(Company company) {
    this.id = company.getId();
    this.name = company.getName();
    this.address = company.getAddress();
    this.state = new StateEntity(company.getState());
    this.city = new CityEntity(company.getCity());
    this.zipCode = company.getZipCode();
  }

  public CompanyEntity(String name, String address, State state, City city, Integer zipCode) {
    this.name = name;
    this.address = address;
    this.state = new StateEntity(state);
    this.city = new CityEntity(city);
    this.zipCode = zipCode;
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", name=" + name + ", address=" + address + ", state=" + state + ", city=" + city + ", zip=" + zipCode + " ]";
  }

}
