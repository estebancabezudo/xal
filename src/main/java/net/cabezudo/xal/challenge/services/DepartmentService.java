package net.cabezudo.xal.challenge.services;

import java.util.Optional;
import net.cabezudo.xal.challenge.database.entities.DepartmentEntity;
import net.cabezudo.xal.challenge.database.repositories.DepartmentRepository;
import net.cabezudo.xal.challenge.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Service
class DepartmentService {

  @Autowired
  DepartmentRepository departmentRepository;

  @Transactional
  Department get(String name) {
    Optional<DepartmentEntity> optionalDepartmentEntity = departmentRepository.findByName(name);
    DepartmentEntity departmentEntity = optionalDepartmentEntity.orElseGet(() -> departmentRepository.save(new DepartmentEntity(name)));
    return new Department(departmentEntity);
  }
}
