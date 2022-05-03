package net.cabezudo.xal.challenge.database.entities;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.cabezudo.xal.challenge.domain.Department;

@Entity
@Table(name = "department")
@Getter
@NoArgsConstructor
public class DepartmentEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  DepartmentEntity(Department department) {
    this.id = department.getId();
    this.name = department.getName();
  }

  public DepartmentEntity(String name) {
    this.id = null;
    this.name = name;
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", name=" + name + " ]";
  }
}
