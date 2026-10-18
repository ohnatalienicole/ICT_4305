
import java.util.ArrayList;
import java.util.List;

public class ParkingOffice {

    private String name;
    private Address address;
    private List<Customer> customers = new ArrayList<>();
    private List<Car> cars = new ArrayList<>();
    private List<ParkingLot> lots = new ArrayList<>();
    private List<ParkingCharge> charges = new ArrayList<>();

    public ParkingOffice(String name, Address address) {
        this.name = name;
        this.address = address;
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

    public Car register(Customer c, String license, CarType t) {
        if (!customers.contains(c)) {
            throw new IllegalArgumentException(
                "Customer must be registered first."
            );
        }

        Car car = c.register(license, t);
        cars.add(car);
        return car;
    }

    public Customer getCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    public Money addCharge(ParkingCharge charge) {
        charges.add(charge);
        return charge.getAmount();
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
}
