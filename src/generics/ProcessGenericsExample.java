package generics;

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
        List<String> servicesCodesList = getServicesCodesList(connectedServicesList);
    }

    private <T extends ServiceInfo> T findServiceByCode(List<T> servicesList, String serviceCode) {
        for (T service : servicesList) {
            if (service.getCode().equals(serviceCode)) return service;
        }
        return null;
    }

    private ServiceConnected findConnectedServiceByCode(List<ServiceConnected> connectedServicesList, String serviceCode) {
        for (ServiceConnected service : connectedServicesList) {
            if (service.getCode().equals(serviceCode)) return service;
        }
        return null;
    }

    private ServiceAvailable findAvailableServiceByCode(List<ServiceAvailable> availableServicesList, String serviceCode) {
        for (ServiceAvailable service : availableServicesList) {
            if (service.getCode().equals(serviceCode)) return service;
        }
        return null;
    }

    private List<String> getServicesCodesList(List<ServiceConnected> connectedServicesList) {
        String actualCode = connectedServicesList.get(0).getCode();
        String archivedCode = connectedServicesList.get(connectedServicesList.size() - 1).getCode();
        String unknownCode = "123456789";
        return new ArrayList<>(List.of(actualCode, archivedCode, unknownCode));
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
