
import java.util.Date;

public class ParkingTransaction {
    private Date date;
    private ParkingPermit permit;
    private ParkingLot parkingLot;
    private Money charge;

    public ParkingTransaction(
            Date date,
            ParkingPermit permit,
            ParkingLot parkingLot,
            Money charge) {

        this.date = new Date(date.getTime());
        this.permit = permit;
        this.parkingLot = parkingLot;
        this.charge = charge;
    }

    public Date getDate() {
        return new Date(date.getTime());
    }

    public ParkingPermit getPermit() {
        return permit;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Money getCharge() {
        return charge;
    }
}
