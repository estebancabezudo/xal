package net.cabezudo.xal.challenge.controllers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import net.cabezudo.xal.challenge.domain.Person;
import net.cabezudo.xal.challenge.services.CSVManager;
import net.cabezudo.xal.challenge.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PersonController {

  Logger logger = LoggerFactory.getLogger(PersonController.class);

  @Value("${xal.data.filename}")
  private String dataFilename;

  @Autowired
  private CSVManager csvManager;

  @Autowired(required = true)
  private PersonService personService;

  @GetMapping("/people")
  public ResponseEntity<List<Person>> list() {
    List<Person> list = personService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(list);
  }

  @PostMapping("/people/ingest")
  public ResponseEntity<String> ingest() {

    if (dataFilename == null) {
      logger.error("Invalid data file: null");
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    Path dataFilePath = Paths.get(dataFilename);
    if (!Files.exists(dataFilePath)) {
      logger.error("xal.data.filename don't have a valid configuration: " + dataFilename);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    try (CSVReader reader = new CSVReader(new FileReader(dataFilePath.toFile()))) {
      List<String[]> fileData = reader.readAll();
      fileData.stream().skip(1).forEach(csvManager::store);
    } catch (CsvException | IOException e) {
      logger.error("Can't read file: " + dataFilename);
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return ResponseEntity.status(HttpStatus.OK).body("Data loaded");
  }

  @GetMapping("/people/{personId}")
  public ResponseEntity<Person> get(@PathVariable("personId") Optional<Integer> optionalPersonId) {
    if (optionalPersonId.isPresent()) {
      Person person = personService.get(optionalPersonId.get());
      if (person != null) {
        return ResponseEntity.status(HttpStatus.OK).body(person);
      }
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "People not found");
  }
}
