package com.gcu.carstoreapplication;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the CarStore Spring Boot application.
 * This class is responsible for bootstrapping the application and starting the Spring context.
 */
@SpringBootApplication
public class CarStoreApplication {

    /**
     * The main method that launches the CarStore application.
     *
     * @param args command-line arguments passed to the application (not used)
     */
    public static void main(String[] args) {
        SpringApplication.run(CarStoreApplication.class, args);
    }
}
