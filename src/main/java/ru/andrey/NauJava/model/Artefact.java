package ru.andrey.NauJava.model;

public class Artefact {
    private Long id;
    private String artefactName;
    private String artefactQuality;

    @Override
    public String toString() {
        return  "id: " + id +
                "\nartefactName: " + artefactName +
                "\nartefactQuality: " + artefactQuality;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtefactName() {
        return artefactName;
    }

    public void setArtefactName(String artefactName) {
        this.artefactName = artefactName;
    }

    public String getArtefactQuality() {
        return artefactQuality;
    }

    public void setArtefactQuality(String artefactQuality) {
        this.artefactQuality = artefactQuality;
    }
}
