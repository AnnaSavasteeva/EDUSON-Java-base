package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 24.04.2026
 */
public class Address implements Cloneable {

    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address(Address address) {
        this.city = address.getCity();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
