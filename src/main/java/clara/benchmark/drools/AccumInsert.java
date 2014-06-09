package clara.benchmark.drools;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import com.google.common.collect.Iterables;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

public class AccumInsert implements IBenchmark<KieBase> {

    @Override
    public String getName()  {
        return "drools.accum-insert";
    }

    @Override
    public KieBase getSession() throws Exception {
        return KnowledgeSupport.load("accum_insert.drl");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Data.getCustomers(100);
    }

    @Override
    public void run(KieBase base, Iterable<Object> facts) throws Exception {

        KieSession session = base.newKieSession();

        try {
            for (Object fact : facts) {
                session.insert(fact);
            }

            session.fireAllRules();

            QueryResults results = session.getQueryResults("get_discounts");

            // Iterate through results to ensure all work is done.
            for (QueryResultsRow result : results) {

                result.get("$percent");
             //   System.out.println("total: " + result.get("$percent"));
            }
        } finally {

            session.dispose();
        }
    }
}
