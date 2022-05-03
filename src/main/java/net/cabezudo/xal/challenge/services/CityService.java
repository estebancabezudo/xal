package net.cabezudo.xal.challenge.services;

import java.util.Optional;
import net.cabezudo.xal.challenge.database.entities.CityEntity;
import net.cabezudo.xal.challenge.database.repositories.CityRepository;
import net.cabezudo.xal.challenge.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Service
class CityService {

  @Autowired
  CityRepository cityRepository;

  @Transactional
  City get(String name) {
    Optional<CityEntity> optionalCityEntity = cityRepository.findByName(name);
    CityEntity cityEntity = optionalCityEntity.orElseGet(() -> cityRepository.save(new CityEntity(name)));
    return new City(cityEntity);
  }
}
