package clara.benchmark.interop;

import clara.rules.RuleLoader;
import clara.rules.WorkingMemory;
import clara.rules.QueryResult;
import clara.benchmark.beans.Customer;
import clara.benchmark.IBenchmark;

import java.util.ArrayList;
import java.util.List;
import java.lang.Iterable;

public class AccumRepeatedlyNotSelected implements IBenchmark<WorkingMemory> {

    //@Override
    public String getName() {
        return "clara.accum-repeatedly-not-selected";
    }

    //@Override
    public WorkingMemory getSession() throws Exception {
        return RuleLoader.loadRules("clara.benchmark.accum-repeatedly-not-selected");
    }

    //@Override
    public Iterable<?> getFacts() throws Exception {
        List<List<Customer>> customersList = new ArrayList<List<Customer>>();
        for (int i = 1; i < 100; i++) {
            List<Customer> customerList = new ArrayList<Customer>();
            customerList.add(new Customer(i, "CUSTOMER_NAME", true));
            customersList.add(customerList);
        }
        return customersList;
    }

    //@Override
    public void run(WorkingMemory session, Iterable<Object> factLists) throws Exception {
        WorkingMemory lastSession = session;

        for (Object factList : factLists) {
            // Just use cast here to avoid complicating the IBenchmark interface since this is the only
            // special case right now.  In the future the type of the facts argument could be parameterized if this
            // is a common use-case.
            lastSession = lastSession.insert((Iterable<Object>) factList).fireRules();
            // Query the inserted facts to make sure we don't have any unrealized lazy computation.
            for (QueryResult q : lastSession.query("clara.benchmark.accum-repeatedly-not-selected/get-discounts")) {
                q.getResult("?percent");
            }
        }
    }
}
