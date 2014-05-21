package clara.benchmark.drools;

import clara.benchmark.Data;
import clara.benchmark.IBenchmark;
import clara.benchmark.beans.Order;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;


public class AccumMax implements IBenchmark<KieBase> {

    @Override
    public String getName() {
        return "drools.accum-max";
    }

    @Override
    public KieBase getSession() throws Exception {
        return KnowledgeSupport.load("accum_max.drl");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        return Data.getOrders(10000, 10);
    }

    @Override
    public void run(KieBase base, Iterable<Object> facts) throws Exception {
        KieSession session = base.newKieSession();

        try {
            for (Object order: facts) {
                session.insert(order);
            }

            session.fireAllRules();

            QueryResults results = session.getQueryResults("maxorder");
        } finally {
            session.dispose();
        }
    }
}
