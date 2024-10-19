package com.Initializer.Model;

import javax.persistence.*;

@Entity
public class OwnEnterprises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // This should map to the name in DAKRSolutions

    private int employeeCount;
    private String clientTargets;
    private String projectQuality;
    private String clientSatisfaction;

    @OneToOne
    @JoinColumn(name = "dakrs_id", referencedColumnName = "id")
    private DAKRSolutions dakrSolutions;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getClientTargets() {
        return clientTargets;
    }

    public void setClientTargets(String clientTargets) {
        this.clientTargets = clientTargets;
    }

    public String getProjectQuality() {
        return projectQuality;
    }

    public void setProjectQuality(String projectQuality) {
        this.projectQuality = projectQuality;
    }

    public String getClientSatisfaction() {
        return clientSatisfaction;
    }

    public void setClientSatisfaction(String clientSatisfaction) {
        this.clientSatisfaction = clientSatisfaction;
    }

    public DAKRSolutions getDakrSolutions() {
        return dakrSolutions;
    }

    public void setDakrSolutions(DAKRSolutions dakrSolutions) {
        this.dakrSolutions = dakrSolutions;
    }
}
