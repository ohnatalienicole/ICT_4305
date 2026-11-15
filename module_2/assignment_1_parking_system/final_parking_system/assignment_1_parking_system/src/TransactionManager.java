
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionManager {
    private List<ParkingTransaction> transactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    public ParkingTransaction park(
            Date date,
            ParkingPermit permit,
            ParkingLot lot,
            Money charge) {

        if (date == null || permit == null ||
                lot == null || charge == null) {
            throw new IllegalArgumentException(
                "Parking transaction information is required."
            );
        }

        ParkingTransaction transaction =
            new ParkingTransaction(
                date, permit, lot, charge
            );

        transactions.add(transaction);
        return transaction;
    }

    public List<ParkingTransaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public List<ParkingTransaction> getTransactions(
            ParkingPermit permit) {

        List<ParkingTransaction> results =
            new ArrayList<>();

        for (ParkingTransaction transaction : transactions) {
            if (transaction.getPermit().equals(permit)) {
                results.add(transaction);
            }
        }

        return results;
    }

    public long getTotalChargeCents(ParkingPermit permit) {
        long total = 0;

        for (ParkingTransaction transaction :
                getTransactions(permit)) {
            total += transaction.getCharge().getCents();
        }

        return total;
    }
}

