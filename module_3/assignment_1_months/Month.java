
public class Month<T> {
    private T month;

    // Default constructor
    public Month() {
    }

    // Constructor with parameter
    public Month(T month) {
        this.month = month;
    }

    // Setter
    public void setMonth(T month) {
        this.month = month;
    }

    // Getter
    public T getMonth() {
        return month;
    }
}

