package ru.andrey.NauJava.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.andrey.NauJava.model.Artefact;

import java.util.List;

@Repository
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ArtefactRepo implements CrudRepository<Artefact, Long> {

    private final List<Artefact> artefactContainer;

    @Autowired
    public ArtefactRepo(List<Artefact> artefactContainer) {
        this.artefactContainer = artefactContainer;
    }

    //Метод для добавления артефакта
    @Override
    public void create(Artefact artefact) {
        for (Artefact art : artefactContainer) {
            if (art.getId().equals(artefact.getId())) {
                System.out.println("Artefact with that id already exists");
                break;
            }
        }
        artefactContainer.add(artefact);
        System.out.println("Artefact created");
    }

    //Метод для чтения артефакта
    @Override
    public Artefact read(Long id) {
//        System.out.println("Reading artefact with id: " + id);
        for (Artefact artefact : artefactContainer) {
            if (artefact.getId().equals(id)) {
                System.out.println("Artefact found!");
                return artefact;
            }
        }
        System.out.println("Artefact not found");
        return null;
    }

    //Метод для апдейта артефакта
    @Override
    public void update(Artefact artefact) {
        artefactContainer.remove(artefact);
        artefactContainer.add(artefact);
        System.out.println("Artefact updated:\n" + artefact);
    }

    //Метод для удаление артефакта по id
    @Override
    public void delete(Long id) {
        System.out.println("Deleting Artefact with id: " + id);
        artefactContainer.removeIf(artefact -> artefact.getId().equals(id));
        System.out.println("Artefact deleted!");
    }
}
