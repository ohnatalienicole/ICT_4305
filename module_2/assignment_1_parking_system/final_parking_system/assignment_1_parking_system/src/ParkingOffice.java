import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ParkingOffice {
    private PermitManager permitManager;
    private TransactionManager transactionManager;
    private String name;
    private Address address;
    private List<Customer> customers = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<ParkingLot> lots = new ArrayList<>();
    private List<ParkingCharge> charges = new ArrayList<>();

    public ParkingOffice(String name, Address address) {
        this.permitManager = new PermitManager();
        this.transactionManager = new TransactionManager();
        this.name = name;
        this.address = address;
    }

    public String getParkingOfficeName() {
        return name;
}

    public Customer register(String name, Address address,
                             String phone) {
        String customerId = "CUST-" + (customers.size() + 1);

        Customer customer = new Customer(
            customerId, name, address, phone
        );

        customers.add(customer);
        return customer;
    }

    public void register(Customer customer) {
    if (customer == null) {
        throw new IllegalArgumentException(
            "Customer cannot be null."
        );
    }

    if (!customers.contains(customer)) {
        customers.add(customer);
    }
}

    public Car register(Customer c, String license, CarType t) {
        if (!customers.contains(c)) {
            throw new IllegalArgumentException(
                "Customer must be registered first."
            );
        }

        Car car = c.register(license, t);
        register(car);
        return car;
    }

    public ParkingPermit register(Car car) {
    if (car == null) {
        throw new IllegalArgumentException(
            "Car cannot be null."
        );
    }

    String permitId = car.getPermit();

    if (permitId == null || permitId.isEmpty()) {
        throw new IllegalArgumentException(
            "Car must have a valid permit ID."
        );
    }

    ParkingPermit existingPermit =
        permitManager.getPermit(permitId);

    if (existingPermit != null) {
        return existingPermit;
    }

    if (!cars.contains(car)) {
        cars.add(car);
    }

    return permitManager.register(car, permitId);
}

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
    public ParkingTransaction park(
        Date date,
        ParkingPermit permit,
        ParkingLot lot) {

    if (date == null || permit == null || lot == null) {
        throw new IllegalArgumentException(
            "Date, permit, and parking lot are required."
        );
    }

    if (!lots.contains(lot)) {
        throw new IllegalArgumentException(
            "Parking lot is not registered."
        );
    }

    Money charge = new Money(500);

    return transactionManager.park(
        date, permit, lot, charge
    );
}
    public Money addCharge(ParkingCharge charge) {
        charges.add(charge);
        return charge.getAmount();
    }

public Money getParkingCharges(ParkingPermit permit) {
    if (permit == null) {
        throw new IllegalArgumentException(
            "Parking permit cannot be null."
        );
    }

    long totalCents =
        transactionManager.getTotalChargeCents(permit);

    return new Money(totalCents);
}

public Money getParkingCharges(Customer customer) {
    if (customer == null) {
        throw new IllegalArgumentException(
            "Customer cannot be null."
        );
    }

    long totalCents = 0;

    for (ParkingPermit permit : permitManager.getPermits()) {
        if (customer.getCustomerId().equals(
                permit.getCar().getOwner())) {

            totalCents +=
                transactionManager.getTotalChargeCents(permit);
        }
    }

    return new Money(totalCents);
}


    public void addParkingLot(ParkingLot lot) {
        lots.add(lot);
        lot.setParkingOffice(this);
    }

    public List<ParkingCharge> getCharges() {
        return charges;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<ParkingLot> getLots() {
        return lots;
    }


public Collection<String> getCustomerIds() {
    List<String> customerIds = new ArrayList<>();

    for (Customer customer : customers) {
        customerIds.add(customer.getCustomerId());
    }

    return customerIds;
}
public Collection<String> getPermitIds() {
    List<String> permitIds = new ArrayList<>();

    for (Car car : cars) {
        permitIds.add(car.getPermit());
    }

    return permitIds;
}
public Collection<String> getPermitIds(Customer customer) {
    List<String> permitIds = new ArrayList<>();

    if (customer == null) {
        return permitIds;
    }

    for (Car car : cars) {
        if (customer.getCustomerId().equals(car.getOwner())) {
            permitIds.add(car.getPermit());
        }
    }

    return permitIds;
}
}
