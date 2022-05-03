package net.cabezudo.xal.challenge.database.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.cabezudo.xal.challenge.domain.Person;

@Entity
@Table(name = "person")
@Getter
@NoArgsConstructor
public class PersonEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @OneToOne
  @JoinColumn(name = "company_id", nullable = false)
  private CompanyEntity company;

  private Long phone1;

  private Long phone2;

  private String email;

  @OneToOne
  @JoinColumn(name = "department_id", nullable = false)
  private DepartmentEntity department;

  public PersonEntity(Person person) {
    this.id = person.getId();
    this.firstName = person.getFirstName();
    this.lastName = person.getLastName();
    this.company = new CompanyEntity(person.getCompany());
    this.phone1 = person.getPhone1();
    this.phone2 = person.getPhone2();
    this.email = person.getEmail();
    this.department = new DepartmentEntity(person.getDepartment());

  }

  @Override
  public String toString() {
    return "[ id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", company=" + company + ", phone1=" + phone1 + ", phone2=" + phone2 + ", email=" + email + ", department=" + department + " ]";
  }

}
