package org.example.service;

public class PrintProjectPrices {
    private int id;
    private int project_cost;

    public PrintProjectPrices(int id, int project_cost) {
        this.id = id;
        this.project_cost = project_cost;
    }

    @Override
    public String toString() {
        return "PrintProjectPrices{" +
                "id=" + id +
                ", project_cost=" + project_cost +
                '}';
    }
}
