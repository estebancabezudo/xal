package net.cabezudo.xal.challenge.domain;

import lombok.Getter;
import net.cabezudo.xal.challenge.database.entities.DepartmentEntity;

@Getter
public class Department {

  private final Integer id;
  private final String name;

  public Department(String name) {
    this.id = null;
    this.name = name;
  }

  public Department(DepartmentEntity entity) {
    this.id = entity.getId();
    this.name = entity.getName();
  }

  @Override
  public String toString() {
    return "[ id=" + id + ", name=" + name + " ]";
  }
}
