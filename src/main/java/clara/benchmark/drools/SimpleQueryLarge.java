package clara.benchmark.drools;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.benchmark.beans.Order;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.List;

/**
 * Simple query benchmark.
 */
public class SimpleQueryLarge implements IBenchmark<KieBase> {

    public String getName() {

        return "drools.simple-query-large";
    }

    @Override
    public KieBase getSession() throws Exception {

        return KnowledgeSupport.load("simple_query.drl");

    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Data.getOrders(1000, 10);
    }

    @Override
    public void run(KieBase base, Iterable<Object> facts) throws Exception {

        KieSession session = base.newKieSession();

        try {
            for (Object order: facts) {
                session.insert(order);
            }

            session.fireAllRules();

            QueryResults results = session.getQueryResults("customer_orders", 2L);

            // Iterate through results to ensure all work is done.
            for (QueryResultsRow result: results) {
                result.get("$total");

//                System.out.println("total: " + result.get("$total"));
            }
        } finally {

            session.dispose();
        }
    }
}
