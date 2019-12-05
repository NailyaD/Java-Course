import com.fasterxml.jackson.annotation.JsonProperty;

public class Phones {
    private String countryCode;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public Phones(String countryCode, String phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public Phones() {

    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "countryCode='" + countryCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
