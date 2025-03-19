package ru.andrey.NauJava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.andrey.NauJava.model.Artefact;
import ru.andrey.NauJava.repository.ArtefactRepo;

@Service
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class ArtefactService implements ServiceInterface {

    private final ArtefactRepo artefactRepo;

    @Autowired
    public ArtefactService(ArtefactRepo artefactRepo) {
        this.artefactRepo = artefactRepo;
    }

    @Override
    public void createArtefact(Long id, String artefactName, String artefactQuality) {
        Artefact artefact = new Artefact();
        artefact.setId(id);
        artefact.setArtefactName(artefactName);
        artefact.setArtefactQuality(artefactQuality);
        artefactRepo.create(artefact);
    }

    @Override
    public Artefact findById(Long id) {
        return artefactRepo.read(id);
    }

    @Override
    public void deleteById(Long id) {
        artefactRepo.delete(id);
    }

    @Override
    public void updateArtefactQuality(Long id, String newArtefactQuality) {
        Artefact artefact = artefactRepo.read(id);
        artefact.setArtefactQuality(newArtefactQuality);
        artefactRepo.update(artefact);
    }
}
