import java.util.Objects;
public class Money {
    private long cents;

    public Money(long cents) {
        this.cents = cents;
    }

    public double getDollars() {
        return cents / 100.0;
    }

    @Override
    public String toString() {
        return String.format("$%.2f", getDollars());
    }

    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Money)) return false;

    Money other = (Money) obj;
    return cents == other.cents;
}

@Override
public int hashCode() {
    return Objects.hash(cents);
}
}
