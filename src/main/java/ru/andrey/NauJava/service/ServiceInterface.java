package ru.andrey.NauJava.service;

import ru.andrey.NauJava.model.Artefact;

public interface ServiceInterface {
    void createArtefact(Long id, String artefactName, String artefactQuality);

    Artefact findById(Long id);

    void deleteById(Long id);

    void updateArtefactQuality(Long id, String newArtefactQuality);
}
