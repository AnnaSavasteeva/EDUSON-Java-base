package override_object_class_methods.clone_demonstration;

/**
 * @author annasavasteeva
 * @date 23.04.2026
 */
public class ShallowAndDeepCopyExample {

    public void processCloningDemonstration() {
        System.out.println("----------");
        System.out.println("SHALLOW COPY");
        System.out.println("---");
        processShallowCopyDemonstration();
        System.out.println("----------");
        System.out.println("DEEP COPY");
        System.out.println("---");
        processDeepCopyDemonstration();
        System.out.println("----------");
    }

    private void processDeepCopyDemonstration() {
        try {
            AddressForDeepCopy address = new AddressForDeepCopy("Wonderland");
            PersonForDeepCopy original = new PersonForDeepCopy("White Rabbit", 3, address);
            PersonForDeepCopy cloned = (PersonForDeepCopy) original.clone();
            System.out.println("Original for deep copy: " + original);
            System.out.println("Cloned for deep copy: " + cloned);

//            Modify the address in the cloned object
            cloned.getAddress().setCity("Sea of Tears");

            System.out.println("--- The address in the cloned object was modified to 'Sea of Tears':");
            System.out.println("Original for deep copy: " + original);
            System.out.println("Cloned for deep copy: " + cloned);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void processShallowCopyDemonstration() {
        try {
            AddressForShallowCopy address = new AddressForShallowCopy("New York");
            PersonForShallowCopy original = new PersonForShallowCopy("Alice", 10, address);
            PersonForShallowCopy cloned = (PersonForShallowCopy) original.clone();
            System.out.println("Original for shallow copy: " + original);
            System.out.println("Cloned for shallow copy: " + cloned);

//            Modify the address in the cloned object
            cloned.getAddress().setCity("Los Angeles");

            System.out.println("--- The address in the cloned object was modified to Los Angeles:");
            System.out.println("Original for shallow copy: " + original);
            System.out.println("Cloned for shallow copy: " + cloned);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
