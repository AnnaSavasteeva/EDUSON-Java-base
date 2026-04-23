package override_object_class_methods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 * Бизнес-смысл: нужно понять, есть ли услуги среди доступных и среди подключенных — например, чтобы найти
 * архивные услуги и проверить, какие из них пока активны
 */
public class ProcessGenericsExample {

    private static final long DURATION = 30L;

    public void processGenericExample() {
        List<ServiceAvailable> availableServicesList = getAvailableServicesList();
        List<ServiceConnected> connectedServicesList = getConnectedServicesList(availableServicesList);
        List<String> servicesCodesList = getServicesCodesList(availableServicesList, connectedServicesList);

        List<ServiceAvailable> availableServicesFound = findServicesByCodeList(availableServicesList, servicesCodesList);
        List<ServiceConnected> connectedServicesFound = findServicesByCodeList(connectedServicesList, servicesCodesList);

        if (availableServicesFound.isEmpty() && connectedServicesFound.isEmpty()) {
            System.out.printf("Следующие услуги в архиве и более никем не используются: %s", servicesCodesList);
        } else {
            List<ServiceInfo> servicesNotInDemand = new ArrayList<>(availableServicesFound);
            servicesNotInDemand.removeAll(connectedServicesFound);
            System.out.printf("Следующие услуги не востребованы никем: %s%n", servicesNotInDemand);
            List<ServiceInfo> archivedServices = new ArrayList<>(connectedServicesFound);
            archivedServices.removeAll(availableServicesFound);
            System.out.printf("Следующие услуги в архиве, но еще остаются потребители: %s%n", archivedServices);
            List<ServiceInfo> popularServices = new ArrayList<>(availableServicesFound);
            popularServices.retainAll(connectedServicesFound);
            System.out.printf("Следующие услуги активны и пользуются спросом: %s%n", popularServices);
        }
    }

    private <T extends ServiceInfo> List<T> findServicesByCodeList(List<T> servicesList, List<String> codes) {
        List<T> foundServices = new ArrayList<>();
        for (String code : codes) {
            T service = findServiceByCode(servicesList, code);
            if (service != null) foundServices.add(service);
        }
        return foundServices;
    }

    private <T extends ServiceInfo> T findServiceByCode(List<T> servicesList, String serviceCode) {
        for (T service : servicesList) {
            if (service.getCode().equals(serviceCode)) return service;
        }
        return null;
    }

    private List<String> getServicesCodesList(List<ServiceAvailable> availableServicesList, List<ServiceConnected> connectedServicesList) {
        String serviceNotInDemand = availableServicesList.get(3).getCode();
        String actualCode = connectedServicesList.get(0).getCode();
        String archivedCode = connectedServicesList.get(connectedServicesList.size() - 1).getCode();
        String unknownCode = "123456789";
        return new ArrayList<>(List.of(serviceNotInDemand, actualCode, archivedCode, unknownCode));
    }

    private List<ServiceConnected> getConnectedServicesList(List<ServiceAvailable> availableServices) {
        List<ServiceConnected> connectedServicesList = new ArrayList<>();
        for (int i = 0; i < availableServices.size(); i+=2) {
            connectedServicesList.add(new ServiceConnected(availableServices.get(i)));
        }
        connectedServicesList.add(new ServiceConnected(new ServiceAvailable("АРХИВ", 1000L, DURATION)));
        return connectedServicesList;
    }

    private List<ServiceAvailable> getAvailableServicesList() {
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
