package model;

public class Pillar {

    private String name;
    private Project[] projects;
    private int projectCount;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50];
        projectCount = 0;
    }

    public boolean registerProject(Project newProject) {
        if (projectCount < projects.length) {
            projects[projectCount] = newProject;
            projectCount++;
            return true;
        }
        return false; // No hay espacio para más proyectos
    }

    public String getProjectList() {
        String list = "Pilar: " + name + "\nProyectos:\n";
        for (int i = 0; i < projectCount; i++) {
            list += (i + 1) + ". ID: " + projects[i].getId() + ", Nombre: " + projects[i].getName() + ", Estado: " + (projects[i].isActive() ? "Activo" : "Inactivo") + "\n";
        }
        return list;
    }
}

