package com.example.demo;

import java.io.Serializable;

public class Movie {
    private String name;
    private int score;
    private String actors;

    public Movie(String name, int score, String actors) {
        this.name = name;
        this.score = score;
        this.actors = actors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
    
	@Override
	public String toString() {
		return "NewMovie: [name=" + name + ", score=" + score + ", actors=" + actors + "]";
	}
}
