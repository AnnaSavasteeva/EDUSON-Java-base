package generics;

import java.time.LocalDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

/**
 * @author annasavasteeva
 * @date 16.04.2026
 */
public class ServiceAvailable implements ServiceInfo {

    private final String code;
    private final String name;
    private final Long cost;
    private final Long durationInDays;

    public ServiceAvailable(String name, Long cost, Long durationInDays) {
        this.code = this.generateCode();
        this.name = name;
        this.cost = cost;
        this.durationInDays = durationInDays;
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

    public Long getDurationInDays() {
        return durationInDays;
    }

    @Override
    public String toString() {
        return String.format("ServiceAvailable{code: %s; name: %s; cost: %d}", this.code, this.name, this.cost);
    }

    private String generateCode() {
        String dateTimePart = LocalDateTime.now().format(ofPattern("yyMMddhhmmss"));
        var randSixDigitNumber = (long) Math.floor(Math.random() * 900_000L) + 100_000L;
        return dateTimePart + randSixDigitNumber;
    }
}
