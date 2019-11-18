import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private Address address;
    private List<Phones> phones;

    public Person(String firstName, String lastName, Address address, List<Phones> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phones = phones;
    }

    public Person() {

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhones(List<Phones> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phones=" + phones +
                '}';
    }
}
