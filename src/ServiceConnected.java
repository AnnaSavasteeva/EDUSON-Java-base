import java.time.LocalDateTime;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 */
public class ServiceConnected {

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

    private LocalDateTime getEndDate(Long duration) {
        return connectionDate.plusDays(duration);
    }
}
