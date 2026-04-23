package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 23.04.2026
 */
public class PersonForShallowCopy implements Cloneable {

    private String name;
    private int age;
    private AddressForShallowCopy address;

    public PersonForShallowCopy(String name, int age, AddressForShallowCopy address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressForShallowCopy getAddress() {
        return address;
    }

    public void setAddress(AddressForShallowCopy addressForShallowCopy) {
        this.address = addressForShallowCopy;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
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
