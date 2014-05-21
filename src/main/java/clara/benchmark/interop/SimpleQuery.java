package clara.benchmark.interop;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.benchmark.beans.Order;
import clara.rules.QueryResult;
import clara.rules.RuleLoader;
import clara.rules.WorkingMemory;

import java.util.Collections;


public class SimpleQuery implements IBenchmark<WorkingMemory> {
    @Override
    public String getName() {

        return "clara.simple-query";
    }

    @Override
    public WorkingMemory getSession() throws Exception {
        return RuleLoader.loadRules("clara.benchmark.simple-query");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Data.getOrders(1000, 10);
    }

    @Override
    public void run(WorkingMemory session, Iterable<Object> facts) throws Exception {

        Iterable<QueryResult> results = session.insert(facts)
                .fireRules()
                .query("clara.benchmark.simple-query/customer-orders",
                        Collections.singletonMap("?id", 5L));

        // Iterate through results to ensure all work is done.
        for (QueryResult result: results)  {
            result.getResult("?total");
            // System.out.println("total: " + result.getResult("?total"));
        }
    }
}
