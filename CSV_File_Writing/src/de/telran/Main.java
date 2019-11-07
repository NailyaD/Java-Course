package de.telran;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Customer ivan = new Customer("Ivan", "Ivanov", 22);
        Customer mikhail = new Customer("Mikhail", "Mikhailov", 35);
        Customer andrey = new Customer("Andrey", "Andreyev", 48);
        Customer dmitry = new Customer("Dmitry", "Dmitriyev", 15);

        List<Customer> customers = Arrays.asList(ivan, mikhail, andrey, dmitry);
        writingAListToACSVFile(customers);
    }

    public static void writingAListToACSVFile(List<Customer> customers) {
        try (FileWriter fileWriter = new FileWriter("ListOfCustomers.csv")) {

            for (Customer customer : customers) {
                fileWriter.append(customer.getFirstName());
                fileWriter.append(",");
                fileWriter.append(customer.getLastName());
                fileWriter.append(",");
                fileWriter.append(String.valueOf(customer.getAge()));
                fileWriter.append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }
    }
}
