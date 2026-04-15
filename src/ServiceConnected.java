import java.time.LocalDateTime;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 */
public class ServiceConnected {

    private String code;
    private String name;
    private Long cost;
    private LocalDateTime connectionDate;
    private LocalDateTime endDate;

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
