package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 23.04.2026
 */
public class CloningProcess {

    public void processCloningDemonstration() {
        System.out.println("----------");
        System.out.println("SHALLOW COPY");
        processShallowCopyDemonstration();
        System.out.println("----------");
    }

    private void processShallowCopyDemonstration() {
        try {
            AddressForShallowCopy addressForShallowCopy = new AddressForShallowCopy("New York");
            PersonForShallowCopy original = new PersonForShallowCopy("Alice", 30, addressForShallowCopy);
            PersonForShallowCopy cloned = (PersonForShallowCopy) original.clone();
            System.out.println("Original: " + original);
            System.out.println("Cloned: " + cloned);

//            Modify the address in the cloned object
            cloned.getAddress().setCity("Los Angeles");

            System.out.println("--- The address in the cloned object was modified to Los Angeles:");
            System.out.println("Original: " + original);
            System.out.println("Cloned: " + cloned);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
