package clara.benchmark.interop;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.rules.QueryResult;
import clara.rules.RuleLoader;
import clara.rules.WorkingMemory;
import com.google.common.collect.Iterables;

/**
 * Created by RB4106 on 5/19/14.
 */
public class SameDayQuery implements IBenchmark<WorkingMemory> {

    @Override
    public String getName() {
        return "clara.same-day-query";
    }

    @Override
    public WorkingMemory getSession() throws Exception {
        return RuleLoader.loadRules("clara.benchmark.visit-order-same-day");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {

        return Iterables.concat(
                Data.getOrders(1000, 10),
                Data.getVisits(1000, 10));
    }

    @Override
    public void run(WorkingMemory session, Iterable<Object> facts) throws Exception {

        Iterable<QueryResult> results = session.insert(facts)
                .fireRules()
                .query("clara.benchmark.visit-order-same-day/same-day-visit");

        // Iterate through results to ensure all work is done.
        for (QueryResult result: results)  {
            result.getResult("?day");
            // System.out.println("total: " + result.getResult("?day"));
        }
    }
}
