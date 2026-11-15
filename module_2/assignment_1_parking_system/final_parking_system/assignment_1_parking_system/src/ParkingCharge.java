import java.util.Objects;
import java.time.Instant;

public class ParkingCharge {
    private String permitId;
    private String lotId;
    private Instant incurred;
    private Money amount;

    public ParkingCharge(String permitId, String lotId,
                         Instant incurred, Money amount) {
        this.permitId = permitId;
        this.lotId = lotId;
        this.incurred = incurred;
        this.amount = amount;
    }

    public Money getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Permit: " + permitId
            + ", Lot: " + lotId
            + ", Date: " + incurred
            + ", Amount: " + amount;
    }


@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof ParkingCharge)) return false;

    ParkingCharge other = (ParkingCharge) obj;

    return Objects.equals(permitId, other.permitId)
        && Objects.equals(lotId, other.lotId)
        && Objects.equals(incurred, other.incurred)
        && Objects.equals(amount, other.amount);
}

@Override
public int hashCode() {
    return Objects.hash(permitId, lotId, incurred, amount);
}
}
