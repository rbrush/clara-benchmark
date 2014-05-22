This project profiles several uses of Clara, starting with trivial examples. It also benchmarks of some equivalent Drools rules for comparison purposes.

Output of a test run is below. Some notes:

For trivial use cases Drools is faster. After profiling I found this is partially due to the natural overhead of persistent data structures, but there are some optimizations we can do to mitigate this. Of course, if these trivial use cases are representative of a problem set, it's probably easier just to write them directly and skip a rule engine outright.

Clara performs better than Drools for more sophisticated use cases. This includes when accumulators are used, presumably because these boil down to _reduce_ operations that Clojure has optimized.

Clara will significantly outperform Drools in some cases since it's able to use hash-based indexes where Drools does not. This is the case in the "same-day-query" example below, where facts that occur on the same day are grouped together. Clara will index the results of the function call to get the date, but since Drools does not it falls back to a cartesian join of facts. The result is Clara is much faster if a significant number of facts are in play.

Clara's performance is sufficient for many use cases now. However, these tests will be expanded and run over time to track and improve performance.

```
Matched benchmarks:
   drools.same-day-query
   drools.accum-max
   drools.simple-query
   drools.simple-join
   clara.same-day-query
   clara.accum-max
   clara.simple-query
   clara.simple-join
Running benchmark:  drools.same-day-query
WARNING: Final GC required 1.307523778333914 % of runtime
Evaluation count : 420 in 60 samples of 7 calls.
             Execution time mean : 141.751093 ms
    Execution time std-deviation : 2.702800 ms
   Execution time lower quantile : 138.118284 ms ( 2.5%)
   Execution time upper quantile : 145.533712 ms (97.5%)
                   Overhead used : 1.996975 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 7.8359 % Variance is slightly inflated by outliers
Running benchmark:  drools.accum-max
Evaluation count : 10440 in 60 samples of 174 calls.
             Execution time mean : 5.786824 ms
    Execution time std-deviation : 78.632713 µs
   Execution time lower quantile : 5.644061 ms ( 2.5%)
   Execution time upper quantile : 5.920866 ms (97.5%)
                   Overhead used : 1.996975 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
Running benchmark:  drools.simple-query
Evaluation count : 87720 in 60 samples of 1462 calls.
             Execution time mean : 687.966334 µs
    Execution time std-deviation : 14.372383 µs
   Execution time lower quantile : 673.770233 µs ( 2.5%)
   Execution time upper quantile : 733.625825 µs (97.5%)
                   Overhead used : 1.996975 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 4 (6.6667 %)
 Variance from outliers : 9.4033 % Variance is slightly inflated by outliers
Running benchmark:  drools.simple-join
Evaluation count : 37860 in 60 samples of 631 calls.
             Execution time mean : 1.607701 ms
    Execution time std-deviation : 25.334244 µs
   Execution time lower quantile : 1.560737 ms ( 2.5%)
   Execution time upper quantile : 1.649374 ms (97.5%)
                   Overhead used : 1.996975 ns
Running benchmark:  clara.same-day-query
Evaluation count : 6300 in 60 samples of 105 calls.
             Execution time mean : 9.750906 ms
    Execution time std-deviation : 174.418442 µs
   Execution time lower quantile : 9.540093 ms ( 2.5%)
   Execution time upper quantile : 10.278991 ms (97.5%)
                   Overhead used : 1.996975 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 4 (6.6667 %)
 Variance from outliers : 7.7681 % Variance is slightly inflated by outliers
Running benchmark:  clara.accum-max
Evaluation count : 12420 in 60 samples of 207 calls.
             Execution time mean : 4.838321 ms
    Execution time std-deviation : 42.850550 µs
   Execution time lower quantile : 4.765998 ms ( 2.5%)
   Execution time upper quantile : 4.926041 ms (97.5%)
                   Overhead used : 1.996975 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
Running benchmark:  clara.simple-query
Evaluation count : 37740 in 60 samples of 629 calls.
             Execution time mean : 1.592016 ms
    Execution time std-deviation : 24.369290 µs
   Execution time lower quantile : 1.565318 ms ( 2.5%)
   Execution time upper quantile : 1.645240 ms (97.5%)
                   Overhead used : 1.996975 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
Running benchmark:  clara.simple-join
Evaluation count : 20700 in 60 samples of 345 calls.
             Execution time mean : 2.906811 ms
    Execution time std-deviation : 45.954473 µs
   Execution time lower quantile : 2.850334 ms ( 2.5%)
   Execution time upper quantile : 3.026286 ms (97.5%)
                   Overhead used : 1.996975 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
```