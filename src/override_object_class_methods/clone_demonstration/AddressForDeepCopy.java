package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 24.04.2026
 */
public class AddressForDeepCopy implements Cloneable {

    private String city;

    public AddressForDeepCopy(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
