package clara.benchmark;

import java.util.Iterator;

/**
 * Benchmark interface.
 */
public interface IBenchmark<T> {

    /**
     * Returns the benchmark name.
     */
    public String getName();

    /**
     * Returns the state used to setup the benchmark.
     */
    public T getSession() throws Exception;

    /**
     * Returns a sequence of facts to be used in the benchmark.
     */
    public Iterable<?> getFacts() throws Exception;

    /**
     * Runs an iteration of the benchmark.
     */
    public void run(T session, Iterable<Object> facts) throws Exception;
}
