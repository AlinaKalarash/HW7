package org.example.service;

public class YoungestEldestWorkers {
    private String type;
    private String name;
    private int birthday;

    public YoungestEldestWorkers(String type, String name, int birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkers{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
