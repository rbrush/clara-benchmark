package clara.benchmark;

import clara.benchmark.beans.Customer;
import clara.benchmark.beans.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import clara.benchmark.beans.Visit;
import org.joda.time.IllegalInstantException;
import org.joda.time.Instant;
import org.joda.time.DateTime;

/**
 * Data for benchmarking.
 */
public class Data {

    /**
     * Returns a randomized date for testing.
     */
    private static final DateTime randomDate(Random random) {

        try {

            return new DateTime(2014,
                    random.nextInt(12) + 1,
                    random.nextInt(28) + 1,
                    random.nextInt(24),
                    random.nextInt(60));

        } catch (IllegalInstantException e) {

            // Handle small probability of landing in a bogus time due to DST
            // by just grabbing another date.
            return randomDate(random);
        }
    }

    /**
     * Returns a list of orders with random order IDs and customer IDs evenly distributed between 0 and customerCount.
     */
    public static List<Order> getOrders(int orderCount, int customerCount) {

        Random random = new Random();

        List<Order> facts = new ArrayList<Order>(orderCount);

        for (int i = 0; i < orderCount; ++ i) {

            facts.add(new Order(i % customerCount, randomDate(random), random.nextInt(1000000)));
        }

        return facts;
    }

    /**
     * Returns a list of orders with random order IDs and customer IDs evenly distributed between 0 and customerCount.
     */
    public static List<Visit> getVisits(int visitCount, int customerCount) {

        Random random = new Random();

        List<Visit> facts = new ArrayList<Visit>(visitCount);

        for (int i = 0; i < visitCount; ++ i) {

            facts.add(new Visit(i % customerCount, randomDate(random)));
        }

        return facts;
    }

    public static Iterable<Customer> getCustomers(int count) {

        List<Customer> customers = new ArrayList<Customer>();

        for (int i = 0; i < count; ++i) {

            customers.add(new Customer(i, "Alice", i % 2 == 0));
        }

        return customers;
    }
}
