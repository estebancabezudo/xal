package net.cabezudo.xal.challenge.services;

import java.util.Optional;
import net.cabezudo.xal.challenge.database.entities.CompanyEntity;
import net.cabezudo.xal.challenge.database.repositories.CompanyRepository;
import net.cabezudo.xal.challenge.domain.City;
import net.cabezudo.xal.challenge.domain.Company;
import net.cabezudo.xal.challenge.domain.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Service
class CompanyService {

  @Autowired
  CompanyRepository companyRepository;

  @Transactional
  Company get(String name, String address, State state, City city, Integer zipCode) {
    Optional<CompanyEntity> optionalCompanyEntity = companyRepository.findByName(name);
    CompanyEntity companyEntity = optionalCompanyEntity.orElseGet(() -> companyRepository.save(new CompanyEntity(name, address, state, city, zipCode)));
    return new Company(companyEntity);
  }
}
