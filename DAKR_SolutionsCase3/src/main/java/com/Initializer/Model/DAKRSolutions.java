package com.Initializer.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DAKRSolutions {

    @Id
    private Long id;

    private String name;
    private String goal;
    private String fiveYearRoadmap;

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

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getFiveYearRoadmap() {
        return fiveYearRoadmap;
    }

    public void setFiveYearRoadmap(String fiveYearRoadmap) {
        this.fiveYearRoadmap = fiveYearRoadmap;
    }

	@Override
	public String toString() {
		return "DAKRSolutions [id=" + id + ", name=" + name + ", goal=" + goal + ", fiveYearRoadmap=" + fiveYearRoadmap
				+ "]";
	}

	public DAKRSolutions(Long id, String name, String goal, String fiveYearRoadmap) {
		super();
		this.id = id;
		this.name = name;
		this.goal = goal;
		this.fiveYearRoadmap = fiveYearRoadmap;
	}

	public DAKRSolutions() {
		super();
	}
    
}
