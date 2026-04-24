package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 24.04.2026
 */
public class PersonForDeepCopy implements Cloneable {

    private String name;
    private int age;
    private AddressForDeepCopy address;

    public PersonForDeepCopy(String name, int age, AddressForDeepCopy address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //    GETTERS AND SETTERS

    public AddressForDeepCopy getAddress() {
        return address;
    }

    public void setAddress(AddressForDeepCopy address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        PersonForDeepCopy cloned = (PersonForDeepCopy) super.clone();
//        Deep copy of address:
        cloned.setAddress((AddressForDeepCopy) address.clone());
        return cloned;
    }

    @Override
    public String toString() {
        return "PersonForDeepCopy{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address.getCity() +
                '}';
    }
}
