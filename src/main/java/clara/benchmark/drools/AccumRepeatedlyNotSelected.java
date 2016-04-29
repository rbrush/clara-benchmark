package clara.benchmark.drools;

import clara.benchmark.IBenchmark;
import clara.benchmark.beans.Customer;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.List;

public class AccumRepeatedlyNotSelected implements IBenchmark<KieBase> {

    @Override
    public String getName() {
        return "drools.accum-repeatedly-not-selected";
    }

    @Override
    public KieBase getSession() throws Exception {
        return KnowledgeSupport.load("accum_repeatedly_not_selected.drl");
    }

    @Override
    public Iterable<?> getFacts() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        for (int i = 1; i < 100; i++) {
            customers.add(new Customer(i, "CUSTOMER_NAME", true));
        }
        return customers;
    }

    @Override
    public void run(KieBase base, Iterable<Object> facts) throws Exception {

        KieSession session = base.newKieSession();

        try {
            for (Object fact : facts) {

                session.insert(fact);
                session.fireAllRules();

                QueryResults results = session.getQueryResults("get_discounts");

                // Iterate through results to ensure all work is done.
                for (QueryResultsRow result : results) {
                    result.get("$percent");
                }
            }
        } finally {
            session.dispose();
        }
    }
}
