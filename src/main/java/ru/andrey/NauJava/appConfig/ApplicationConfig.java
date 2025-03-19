package ru.andrey.NauJava.appConfig;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.andrey.NauJava.model.Artefact;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    @Bean
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public List<Artefact> artefactContainer() {
        return new ArrayList<>();
    }

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.version}")
    private String appVersion;

    @PostConstruct
    public void init() {
        System.out.println("Application Name: " + appName +
                "\nApp Version: " + appVersion);
    }
}
