package com.zeta.spring.ioc.bean;

import java.time.LocalDate;

public class Movie {
    private String language;
    private String name;
    private String cast;
    private String director;
    private String release;

    public void setLanguage(String language) { this.language = language; }
    public void setName(String name) { this.name = name; }
    public void setCast(String cast) { this.cast = cast; }
    public void setDirector(String director) { this.director = director; }
    public void setRelease(String release) { this.release = release; }

    @Override public String toString() {
        return "Movie{" +
                "language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", cast='" + cast + '\'' +
                ", director='" + director + '\'' +
                ", release=" + release +
                '}';
    }

    public void setup() { System.out.println("Initializing the Instance"); }
    public void teardown() { System.out.println("Destroying the Instance"); }
}