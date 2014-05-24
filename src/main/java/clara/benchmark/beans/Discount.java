package clara.benchmark.beans;

/**
 * Java Bean used in test rules.
 */
public class Discount {

    private final int percent;

    public Discount(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }

    public boolean equals(Object that) {

        if (!(that instanceof  Discount)) {
            return false;
        }

        Discount _that = (Discount) that;

        return this.percent == _that.percent;
    }

    public int hashCode() {
        return percent;
    }
}
