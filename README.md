This project profiles several uses of Clara, starting with trivial examples. It also benchmarks of some equivalent Drools rules for comparison purposes.

Output of a test run is below. Some notes:

For trivial use cases Drools is faster, sometimes significantly. After profiling I found this is partially due to the natural overhead of persistent data structures, but there are some optimizations we can do to mitigate this. The larges is [Clara issue 56](https://github.com/rbrush/clara-rules/issues/56). Of course, if these trivial use cases are representative of a problem set, it's probably easier just to write them directly and skip a rule engine outright.

The gap closes for more sophisticated use cases. Clara performs well when accumulators are used, presumably because these boil down to _reduce_ operations that Clojure has optimized.

Clara will significantly outperform Drools in some cases since it's able to use hash-based indexes where Drools does not. This is the case in the "same-day-query" example below, where facts that occur on the same day are grouped together. Clara will index the results of the function call to get the date, but since Drools does not it falls back to a cartesian join of facts. The result is Clara is much faster if a significant number of facts are in play.

Clara's performance is sufficient for many use cases now. However, these tests will be expanded and run over time to track and improve performance.

```
Running benchmark:  drools.same-day-query
WARNING: Final GC required 1.24948703971699 % of runtime
Evaluation count : 480 in 60 samples of 8 calls.
             Execution time mean : 134.130308 ms
    Execution time std-deviation : 1.885852 ms
   Execution time lower quantile : 131.688873 ms ( 2.5%)
   Execution time upper quantile : 138.040364 ms (97.5%)
                   Overhead used : 2.023648 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Running benchmark:  drools.accum-max
Evaluation count : 10800 in 60 samples of 180 calls.
             Execution time mean : 5.645946 ms
    Execution time std-deviation : 115.742003 µs
   Execution time lower quantile : 5.469765 ms ( 2.5%)
   Execution time upper quantile : 5.981692 ms (97.5%)
                   Overhead used : 2.023648 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 3 (5.0000 %)
 Variance from outliers : 9.3803 % Variance is slightly inflated by outliers

Running benchmark:  drools.simple-query
Evaluation count : 90840 in 60 samples of 1514 calls.
             Execution time mean : 672.455573 µs
    Execution time std-deviation : 8.204752 µs
   Execution time lower quantile : 663.036286 µs ( 2.5%)
   Execution time upper quantile : 692.500768 µs (97.5%)
                   Overhead used : 2.023648 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Running benchmark:  drools.simple-join
Evaluation count : 39000 in 60 samples of 650 calls.
             Execution time mean : 1.594262 ms
    Execution time std-deviation : 25.661123 µs
   Execution time lower quantile : 1.550472 ms ( 2.5%)
   Execution time upper quantile : 1.645148 ms (97.5%)
                   Overhead used : 2.023648 ns

Running benchmark:  clara.same-day-query
Evaluation count : 4200 in 60 samples of 70 calls.
             Execution time mean : 14.553710 ms
    Execution time std-deviation : 127.688780 µs
   Execution time lower quantile : 14.310627 ms ( 2.5%)
   Execution time upper quantile : 14.786575 ms (97.5%)
                   Overhead used : 2.023648 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Running benchmark:  clara.accum-max
Evaluation count : 9660 in 60 samples of 161 calls.
             Execution time mean : 6.267130 ms
    Execution time std-deviation : 65.618921 µs
   Execution time lower quantile : 6.174004 ms ( 2.5%)
   Execution time upper quantile : 6.445520 ms (97.5%)
                   Overhead used : 2.023648 ns

Found 4 outliers in 60 samples (6.6667 %)
	low-severe	 2 (3.3333 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers\

Running benchmark:  clara.simple-query
Evaluation count : 7620 in 60 samples of 127 calls.
             Execution time mean : 7.957183 ms
    Execution time std-deviation : 82.389267 µs
   Execution time lower quantile : 7.842833 ms ( 2.5%)
   Execution time upper quantile : 8.168141 ms (97.5%)
                   Overhead used : 2.023648 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 4 (6.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

Running benchmark:  clara.simple-join
Evaluation count : 9540 in 60 samples of 159 calls.
             Execution time mean : 6.400607 ms
    Execution time std-deviation : 142.032186 µs
   Execution time lower quantile : 6.288734 ms ( 2.5%)
   Execution time upper quantile : 6.600219 ms (97.5%)
                   Overhead used : 2.023648 ns

Found 6 outliers in 60 samples (10.0000 %)
	low-severe	 1 (1.6667 %)
	low-mild	 4 (6.6667 %)
	high-mild	 1 (1.6667 %)
 Variance from outliers : 10.9468 % Variance is moderately inflated by outliers
```