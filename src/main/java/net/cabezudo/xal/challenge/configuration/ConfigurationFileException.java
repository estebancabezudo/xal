package net.cabezudo.xal.challenge.configuration;

/**
 * @author <a href="http://cabezudo.net">Esteban Cabezudo</a>
 * @version 0.01.00, 2022.04.30
 */
public class ConfigurationFileException extends RuntimeException {

  ConfigurationFileException(String message, Throwable cause) {
    super(message, cause);
  }

  ConfigurationFileException(String message) {
    super(message);
  }
}
