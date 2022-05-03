package net.cabezudo.xal.challenge.domain;

import lombok.Getter;
import net.cabezudo.xal.challenge.database.entities.PersonEntity;

@Getter
public class Person {

  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final Company company;
  private final Long phone1;
  private final Long phone2;
  private final String email;
  private final Department department;

  public Person(String firstName, String lastName, Company company, Long phone1, Long phone2, String email, Department department) {
    this.id = null;
    this.firstName = firstName;
    this.lastName = lastName;
    this.company = company;
    this.phone1 = phone1;
    this.phone2 = phone2;
    this.email = email;
    this.department = department;
  }

  public Person(PersonEntity entity) {
    this.id = entity.getId();
    this.firstName = entity.getFirstName();
    this.lastName = entity.getLastName();
    this.company = new Company(entity.getCompany());
    this.phone1 = entity.getPhone1();
    this.phone2 = entity.getPhone2();
    this.email = entity.getEmail();
    this.department = new Department(entity.getDepartment());
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + ", phone1=" + phone1 + ", phone2=" + phone2 + ", email=" + email + ", department=" + department + " ]";
  }

}
