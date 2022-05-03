package net.cabezudo.xal.challenge.services;

import net.cabezudo.xal.challenge.domain.City;
import net.cabezudo.xal.challenge.domain.Company;
import net.cabezudo.xal.challenge.domain.Department;
import net.cabezudo.xal.challenge.domain.Person;
import net.cabezudo.xal.challenge.domain.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
@Service
public class CSVManager {

  @Autowired
  StateService stateService;

  @Autowired
  CityService cityService;

  @Autowired
  CompanyService companyService;

  @Autowired
  DepartmentService departmentService;

  @Autowired
  PersonService personService;

  public void store(String[] data) {

    String firstName = data[0];
    String lastName = data[1];
    String companyName = data[2];
    String address = data[3];
    String cityName = data[4];
    String stateCode = data[5];
    Integer zipCode = Integer.parseInt(data[6]);
    Long phone1 = Long.parseLong(data[7].replace("-", ""));
    Long phone2 = Long.parseLong(data[8].replace("-", ""));
    String email = data[9];
    String departmentName = data[10];

    System.out.println("firstName: " + firstName);
    System.out.println("lastName: " + lastName);
    System.out.println("companyName: " + companyName);
    System.out.println("address: " + address);
    System.out.println("cityName: " + cityName);
    System.out.println("stateCode: " + stateCode);
    System.out.println("zipCode: " + zipCode);
    System.out.println("phone1: " + phone1);
    System.out.println("phone2: " + phone2);
    System.out.println("email: " + email);
    System.out.println("departmentName: " + departmentName);

    State state = stateService.getByCode(stateCode);
    City city = cityService.get(cityName);
    Company company = companyService.get(companyName, address, state, city, zipCode);
    Department department = departmentService.get(departmentName);
    Person person = new Person(firstName, lastName, company, phone1, phone2, email, department);
    System.out.println(person);
    personService.save(person);
  }

}
