package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 23.04.2026
 */
public class PersonForShallowCopy implements Cloneable {

    private String name;
    private int age;
    private Address address;

    public PersonForShallowCopy(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //    GETTERS AND SETTERS

    public Address getAddress() {
        return address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "PersonForShallowCopy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address.getCity() +
                '}';
    }
}
