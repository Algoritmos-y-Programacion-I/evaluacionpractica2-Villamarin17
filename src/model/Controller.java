package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {
        pillars = new Pillar[4];
        pillars[0] = new Pillar("Biodiversidad");
        pillars[1] = new Pillar("Agua");
        pillars[2] = new Pillar("Tratamiento de Basuras");
        pillars[3] = new Pillar("Energía");
    }

    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {
        if (pillarType >= 0 && pillarType < 4) {
            Project newProject = new Project(id, name, description, status);
            return pillars[pillarType].registerProject(newProject);
        }
        return false;
    }

    public String queryProjectsByPillar(int pillarType) {
        if (pillarType >= 0 && pillarType < 4) {
            return pillars[pillarType].getProjectList();
        }
        return "Pilar no válido.";
    }
}
