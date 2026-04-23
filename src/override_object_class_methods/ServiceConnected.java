package override_object_class_methods;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 */
public class ServiceConnected implements ServiceInfo {

    private final String code;
    private final String name;
    private final Long cost;
    private final LocalDateTime connectionDate;
    private final LocalDateTime endDate;

    public ServiceConnected(ServiceAvailable service) {
        this.code = service.getCode();
        this.name = service.getName();
        this.cost = service.getCost();
        this.connectionDate = LocalDateTime.now();
        this.endDate = getEndDate(service.getDurationInDays());
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Long getCost() {
        return cost;
    }

    public LocalDateTime getConnectionDate() {
        return connectionDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return String.format("ServiceConnected{code: %s; name: %s; cost: %d}", this.code, this.name, this.cost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (!(obj instanceof ServiceInfo other)) return false;

        return this.code.equals(other.getCode())
                && this.name.equals(other.getName())
                && this.cost.compareTo(other.getCost()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, cost);
    }

    private LocalDateTime getEndDate(Long duration) {
        return connectionDate.plusDays(duration);
    }
}
