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
            PersonForDeepCopy original = new PersonForDeepCopy("White Rabbit", 3, new Address("Wonderland"));
            PersonForDeepCopy cloned = (PersonForDeepCopy) original.clone();
            System.out.println("Original for deep copy: " + original);
            System.out.println("Cloned for deep copy: " + cloned);

//            Modify the address in the cloned object
            String newAddress = "Sea of Tears";
            cloned.getAddress().setCity(newAddress);

            System.out.printf("--- The address in the cloned object was modified to '%s':%n", newAddress);
            System.out.println("Original for deep copy: " + original);
            System.out.println("Cloned for deep copy: " + cloned);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void processShallowCopyDemonstration() {
        try {
            PersonForShallowCopy original = new PersonForShallowCopy("Alice", 10, new Address("New York"));
            PersonForShallowCopy cloned = (PersonForShallowCopy) original.clone();
            System.out.println("Original for shallow copy: " + original);
            System.out.println("Cloned for shallow copy: " + cloned);

//            Modify the address in the cloned object
            String newAddress = "Los Angeles";
            cloned.getAddress().setCity(newAddress);

            System.out.printf("--- The address in the cloned object was modified to '%s':%n", newAddress);
            System.out.println("Original for shallow copy: " + original);
            System.out.println("Cloned for shallow copy: " + cloned);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
