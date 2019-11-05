package de.telran;

import java.util.List;

public class Person {
    String name;
    List<String> bankAccounts;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, List<String> bankAccounts) {
        this.name = name;
        this.bankAccounts = bankAccounts;
    }

    public String getName() {
        return name;
    }

    public List<String> getBankAccounts() {
        return bankAccounts;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
