package org.example.service;

public class LongestProject {
    private int id;
    private int duration;

    public LongestProject(int id, int duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", duration=" + duration +
                '}';
    }
}
