package hr.lknezevic.homemediaorchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class HomeMediaOrchestratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeMediaOrchestratorApplication.class, args);
    }

}
