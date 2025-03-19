package ru.andrey.NauJava.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.andrey.NauJava.model.Artefact;
import ru.andrey.NauJava.service.ArtefactService;

import java.util.Scanner;

@Component
public class CommandProcessor {
    private final ArtefactService artefactService;

    @Autowired
    public CommandProcessor(ArtefactService artefactService) {
        this.artefactService = artefactService;
    }

    public void processCommand(String input) {
        String[] cmd = input.split(" ");
        switch (cmd[0]) {
            case "create" -> {
                try {
                    artefactService.createArtefact(Long.valueOf(cmd[1]), cmd[2], cmd[3]);
                } catch (Exception e) {
                    System.out.println("incorrect type of id");
                }
            }
            case "find" -> {
                try {
                    artefactService.findById(Long.valueOf(cmd[1]));
                } catch (Exception e) {
                    System.out.println("incorrect type of id");
                }
            }
            case "updateQuality" -> {
                try {
                    artefactService.updateArtefactQuality(Long.valueOf(cmd[1]), cmd[2]);
                } catch (Exception e) {
                    System.out.println("incorrect type of id");
                }
            }
            case "delete" -> {
                try {
                    artefactService.deleteById(Long.valueOf(cmd[1]));
                } catch (Exception e) {
                    System.out.println("incorrect type of id");
                }
            }
            default -> System.out.println("Unknown command");
        }
    }

    @Bean
    public CommandLineRunner commandScanner() {
        return args -> {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter command exit for exit!" +
                        "\nList of commands:" +
                        "\n1) create [id] [name] [quality]" +
                        "\n2) find [id]" +
                        "\n3) updateQuality [id] [quality]" +
                        "\n4) delete [id]");
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine();

                    if ("exit".equalsIgnoreCase(input.trim())) {
                        System.out.println("Exiting...");
                        break;
                    }
                    processCommand(input);
                }
            }
        };
    }
}