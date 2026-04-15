import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final long DURATION = 30L;

    /* Нужно понять, есть ли услуги среди доступных и среди подключенных:
    например, чтобы определить архивные услуги и проверить, у кого еще они активны */
    public static void main(String[] args) {
        List<ServiceAvailable> availableServicesList = getAvailableServicesList();
        List<ServiceConnected> connectedServicesList = getConnectedServicesList(availableServicesList);
        List<String> servicesCodesList = getServicesCodesList(connectedServicesList);
    }

    private static List<String> getServicesCodesList(List<ServiceConnected> connectedServicesList) {
        String actualCode = connectedServicesList.get(0).getCode();
        String archivedCode = connectedServicesList.get(connectedServicesList.size() - 1).getCode();
        String unknownCode = "123456789";
        return new ArrayList<>(List.of(actualCode, archivedCode, unknownCode));
    }

    private static List<ServiceConnected> getConnectedServicesList(List<ServiceAvailable> availableServices) {
        List<ServiceConnected> connectedServicesList = new ArrayList<>();
        for (int i = 0; i < availableServices.size(); i+=2) {
            connectedServicesList.add(new ServiceConnected(availableServices.get(i)));
        }
        connectedServicesList.add(new ServiceConnected(new ServiceAvailable("АРХИВ", 1000L, DURATION)));
        return connectedServicesList;
    }

    private static List<ServiceAvailable> getAvailableServicesList() {
        List<ServiceAvailable> availableServicesList = new ArrayList<>();
        long baseCost = 1000L;
        for (int i = 0; i < 10; i++) {
            String name = "Service " + i;
            baseCost *= 2;
            availableServicesList.add(new ServiceAvailable(name, baseCost, DURATION));
        }
        return availableServicesList;
    }
}