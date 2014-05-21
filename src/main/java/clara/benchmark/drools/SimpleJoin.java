package clara.benchmark.drools;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import com.google.common.collect.Iterables;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

/**
 * Created by RB4106 on 5/20/14.
 */
public class SimpleJoin implements IBenchmark<KieBase> {

    @Override
    public String getName()  {
        return "drools.simple-join";
    }

    @Override
    public KieBase getSession() throws Exception {
        return KnowledgeSupport.load("simple_join.drl");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Iterables.concat(
                Data.getOrders(1000, 100),
                Data.getCustomers(100));
    }

    @Override
    public void run(KieBase base, Iterable<Object> facts) throws Exception {

        KieSession session = base.newKieSession();

        try {
            for (Object fact : facts) {
                session.insert(fact);
            }

            session.fireAllRules();

            QueryResults results = session.getQueryResults("vip_orders");

            // Iterate through results to ensure all work is done.
            for (QueryResultsRow result : results) {

                result.get("$id");
                // System.out.println("total: " + result.get("$day"));
            }
        } finally {

            session.dispose();
        }
    }
}
