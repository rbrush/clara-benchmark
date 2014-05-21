package clara.benchmark.beans;


import org.joda.time.DateTime;

public class Visit {

    /**
     * Customer ID.
     */
    private final long customerId;

    /**
     * The order's time.
     */
    private final DateTime time;

    /**
     * Creates a visit for the given customer at the given time.
     */
    public Visit(long customerId, DateTime time) {
        this.customerId = customerId;
        this.time = time;
    }

    /**
     * Returns the customer id.
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Returns the visit itme.
     */
    public DateTime getTime() {
        return time;
    }


    public boolean equals(Object that) {

        if (!(that instanceof  Order)) {
            return false;
        }

        Visit _that = (Visit) that;

        return this.time.equals(_that.time) &&
                this.customerId == _that.customerId;
    }

    public int hashCode() {
        return (int) customerId * time.hashCode();
    }

    public String toString() {
        return "Visit at: " + time.toString();
    }
}
