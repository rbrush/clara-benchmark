package clara.benchmark.drools;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import com.google.common.collect.Iterables;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

public class SameDayQuery implements IBenchmark<KieBase> {


    @Override
    public String getName() {
        return "drools.same-day-query";
    }

    @Override
    public KieBase getSession() throws Exception {

        return KnowledgeSupport.load("visit_order_same_day.drl");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {

        return Iterables.concat(Data.getOrders(1000, 10),
                                Data.getVisits(1000, 10));
    }

    @Override
    public void run(KieBase base, Iterable<Object> facts) throws Exception {

        KieSession session = base.newKieSession();

        try {
            for (Object fact : facts) {
                session.insert(fact);
            }

            session.fireAllRules();

            QueryResults results = session.getQueryResults("same_day_visit");

            // Iterate through results to ensure all work is done.
            for (QueryResultsRow result : results) {

                result.get("$day");
                // System.out.println("total: " + result.get("$day"));
            }
        } finally {

            session.dispose();
        }
    }
}
