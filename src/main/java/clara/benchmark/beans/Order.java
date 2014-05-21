package clara.benchmark.beans;

import org.joda.time.DateTime;

/**
 * Java bean used in example rules.
 */
public class Order {

    /**
     * The order's total.
     */
    private final int total;

    /**
     * Customer ID.
     */
    private final long customerId;

    /**
     * The order's time.
     */
    private final DateTime time;

    /**
     * Creates an order with the given total.
     * @param total
     */
    public Order(long customerId, DateTime time, int total) {
        this.customerId = customerId;
        this.time = time;
        this.total = total;
    }

    /**
     * Returns the customer id.
     */
    public long getCustomerId() {
        return customerId;
    }

    /**
     * Returns the order time.
     */
    public DateTime getTime() {
        return time;
    }

    /**
     * Returns the order's total.
     */
    public int getTotal() {
        return total;
    }

    public boolean equals(Object that) {

        if (!(that instanceof  Order)) {
            return false;
        }

        Order _that = (Order) that;

        return this.total == _that.total &&
               this.customerId == _that.customerId &&
               this.time.equals (_that.time);
    }

    public int hashCode() {
        return (int) customerId * total;
    }

    public String toString() {
       return "Order total: " + total;
    }
}
