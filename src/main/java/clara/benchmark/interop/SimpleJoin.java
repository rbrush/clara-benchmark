package clara.benchmark.interop;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.rules.QueryResult;
import clara.rules.RuleLoader;
import clara.rules.WorkingMemory;
import com.google.common.collect.Iterables;


public class SimpleJoin implements IBenchmark<WorkingMemory> {

    @Override
    public String getName() {
        return "clara.simple-join";
    }

    @Override
    public WorkingMemory getSession() throws Exception {
        return RuleLoader.loadRules("clara.benchmark.simple-join");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {

        return Iterables.concat(
                Data.getOrders(1000, 100),
                Data.getCustomers(100));
    }

    @Override
    public void run(WorkingMemory session, Iterable<Object> facts) throws Exception {

        Iterable<QueryResult> results = session.insert(facts)
                .fireRules()
                .query("clara.benchmark.simple-join/vip-orders");

        // Iterate through results to ensure all work is done.
        for (QueryResult result: results)  {
            result.getResult("?id");
            // System.out.println("total: " + result.getResult("?day"));
        }
    }
}
