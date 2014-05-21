package clara.benchmark.interop;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.benchmark.drools.KnowledgeSupport;
import clara.rules.QueryResult;
import clara.rules.RuleLoader;
import clara.rules.WorkingMemory;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;


public class AccumMax implements IBenchmark<WorkingMemory> {

    @Override
    public String getName() {
        return "clara.accum-max";
    }

    @Override
    public WorkingMemory getSession() throws Exception {
        return RuleLoader.loadRules("clara.benchmark.accum-max");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Data.getOrders(10000, 10);
    }

    @Override
    public void run(WorkingMemory base, Iterable<Object> facts) throws Exception {

        Iterable<QueryResult> results = base.insert(facts)
                .fireRules()
                .query("clara.benchmark.accum-max/max-order");
    }
}
