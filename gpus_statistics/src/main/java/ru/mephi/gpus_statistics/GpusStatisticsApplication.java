package ru.mephi.gpus_statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GpusStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpusStatisticsApplication.class, args);
    }

}
