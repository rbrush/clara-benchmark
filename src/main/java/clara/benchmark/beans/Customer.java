package clara.benchmark.beans;

/**
 * Java bean used in example rules.
 */
public class Customer {

    private final long id;

    /**
     * Customer name;
     */
    private final String name;

    /**
     * VIP status.
     */
    private final boolean vip;

    /**
     * Creates a customer with the given name and status.
     */
    public Customer (long id, String name, boolean vip) {
        this.id = id;
        this.name = name;
        this.vip = vip;
    }

    public long getId() {
        return id;
    }

    /**
     * Returns true if the customer is a VIP.
     */
    public boolean isVip() {
        return vip;
    }

    /**
     * Returns the name of the customer.
     */
    public String getName() {
        return name;
    }

    public String toString() {
        return "VIP: " + isVip();
    }

    public boolean equals(Object that) {

        if (!(that instanceof  Customer)) {
            return false;
        }

        Customer _that = (Customer) that;

        return this.name.equals(_that.name) &&
               this.vip == _that.vip;
    }

    public int hashCode() {
        return 17 * name.hashCode() * (vip ? 1 : 2);
    }
}
