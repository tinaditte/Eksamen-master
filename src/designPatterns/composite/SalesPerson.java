package designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class SalesPerson {
    private String name;
    private int salary;
    private List<SalesPerson> networkers = new ArrayList<SalesPerson>();

    public SalesPerson(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void add(SalesPerson s) {
        networkers.add(s);
    }

    @Override
    public String toString() {
        return this.name + " " + this.getSalary();
    }

    public int getSalary() {

        int commission = 0;
        for (SalesPerson networker : networkers) {
            //20% af hvad netværket tjener.
            commission += networker.getSalary() / 5;
        }

        return this.salary + commission;
    }
}
