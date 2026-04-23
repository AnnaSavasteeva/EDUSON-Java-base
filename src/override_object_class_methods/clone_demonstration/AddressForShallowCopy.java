package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 23.04.2026
 */
public class AddressForShallowCopy {

    private String city;

    public AddressForShallowCopy(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
