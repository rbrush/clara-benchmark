package clara.benchmark.interop;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.rules.QueryResult;
import clara.rules.RuleLoader;
import clara.rules.WorkingMemory;

import java.util.Collections;

public class AccumInsert implements IBenchmark<WorkingMemory> {

    @Override
    public String getName() {

        return "clara.accum-insert";
    }

    @Override
    public WorkingMemory getSession() throws Exception {
        return RuleLoader.loadRules("clara.benchmark.accum-insert");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Data.getCustomers(100);
    }

    @Override
    public void run(WorkingMemory session, Iterable<Object> facts) throws Exception {

        Iterable<QueryResult> results = session.insert(facts)
                .fireRules()
                .query("clara.benchmark.accum-insert/get-discounts");

        // Iterate through results to ensure all work is done.
        for (QueryResult result: results)  {
            result.getResult("?percent");
            // System.out.println("percent: " + result.getResult("?percent"));
        }
    }
}
