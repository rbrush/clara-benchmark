This project profiles several uses of Clara, starting with trivial examples. It also benchmarks of some equivalent Drools rules for comparison purposes.

Test outputs are below. This should be considered a work in progress as Clara continues to be optimized.

```
Matched benchmarks:
   drools.same-day-query
   clara.same-day-query
   drools.simple-query-small
   clara.simple-query-small
   drools.simple-query-large
   clara.simple-query-large
   drools.simple-join
   clara.simple-join
   drools.accum-max
   clara.accum-max
   drools.simple-insert
   clara.simple-insert
   drools.accum-insert
   clara.accum-insert

*** Running benchmark: drools.same-day-query ***
WARNING: Final GC required 1.1660444700724268 % of runtime
Evaluation count : 660 in 60 samples of 11 calls.
             Execution time mean : 95.692870 ms
    Execution time std-deviation : 527.384688 µs
   Execution time lower quantile : 94.752726 ms ( 2.5%)
   Execution time upper quantile : 96.657130 ms (97.5%)
                   Overhead used : 1.635497 ns

*** Running benchmark: clara.same-day-query ***
Evaluation count : 11400 in 60 samples of 190 calls.
             Execution time mean : 5.318370 ms
    Execution time std-deviation : 35.870730 µs
   Execution time lower quantile : 5.263150 ms ( 2.5%)
   Execution time upper quantile : 5.403207 ms (97.5%)
                   Overhead used : 1.635497 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 3 (5.0000 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-query-small ***
Evaluation count : 665580 in 60 samples of 11093 calls.
             Execution time mean : 88.914891 µs
    Execution time std-deviation : 381.759629 ns
   Execution time lower quantile : 88.042338 µs ( 2.5%)
   Execution time upper quantile : 89.600095 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-query-small ***
Evaluation count : 3284340 in 60 samples of 54739 calls.
             Execution time mean : 18.266966 µs
    Execution time std-deviation : 100.152737 ns
   Execution time lower quantile : 18.153738 µs ( 2.5%)
   Execution time upper quantile : 18.479056 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 1 (1.6667 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-query-large ***
Evaluation count : 115680 in 60 samples of 1928 calls.
             Execution time mean : 522.477903 µs
    Execution time std-deviation : 2.374250 µs
   Execution time lower quantile : 518.957390 µs ( 2.5%)
   Execution time upper quantile : 527.815066 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-query-large ***
Evaluation count : 76980 in 60 samples of 1283 calls.
             Execution time mean : 785.522397 µs
    Execution time std-deviation : 11.411490 µs
   Execution time lower quantile : 769.658536 µs ( 2.5%)
   Execution time upper quantile : 814.870578 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 5 (8.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-join ***
Evaluation count : 53340 in 60 samples of 889 calls.
             Execution time mean : 1.128628 ms
    Execution time std-deviation : 4.972688 µs
   Execution time lower quantile : 1.121912 ms ( 2.5%)
   Execution time upper quantile : 1.139322 ms (97.5%)
                   Overhead used : 1.635497 ns

*** Running benchmark: clara.simple-join ***
Evaluation count : 33540 in 60 samples of 559 calls.
             Execution time mean : 1.785791 ms
    Execution time std-deviation : 9.729442 µs
   Execution time lower quantile : 1.768463 ms ( 2.5%)
   Execution time upper quantile : 1.801497 ms (97.5%)
                   Overhead used : 1.635497 ns

*** Running benchmark: drools.accum-max ***
Evaluation count : 12960 in 60 samples of 216 calls.
             Execution time mean : 4.670814 ms
    Execution time std-deviation : 39.815625 µs
   Execution time lower quantile : 4.597924 ms ( 2.5%)
   Execution time upper quantile : 4.755623 ms (97.5%)
                   Overhead used : 1.635497 ns

*** Running benchmark: clara.accum-max ***
Evaluation count : 25620 in 60 samples of 427 calls.
             Execution time mean : 2.359613 ms
    Execution time std-deviation : 15.774922 µs
   Execution time lower quantile : 2.331183 ms ( 2.5%)
   Execution time upper quantile : 2.391741 ms (97.5%)
                   Overhead used : 1.635497 ns

*** Running benchmark: drools.simple-insert ***
Evaluation count : 370440 in 60 samples of 6174 calls.
             Execution time mean : 161.890331 µs
    Execution time std-deviation : 1.156327 µs
   Execution time lower quantile : 160.384500 µs ( 2.5%)
   Execution time upper quantile : 164.470141 µs (97.5%)
                   Overhead used : 1.635497 ns

*** Running benchmark: clara.simple-insert ***
Evaluation count : 286740 in 60 samples of 4779 calls.
             Execution time mean : 209.269851 µs
    Execution time std-deviation : 691.958581 ns
   Execution time lower quantile : 208.457807 µs ( 2.5%)
   Execution time upper quantile : 210.431300 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.accum-insert ***
Evaluation count : 356760 in 60 samples of 5946 calls.
             Execution time mean : 168.978923 µs
    Execution time std-deviation : 1.336035 µs
   Execution time lower quantile : 166.806975 µs ( 2.5%)
   Execution time upper quantile : 171.372637 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.accum-insert ***
Evaluation count : 620340 in 60 samples of 10339 calls.
             Execution time mean : 97.537190 µs
    Execution time std-deviation : 268.953375 ns
   Execution time lower quantile : 97.071679 µs ( 2.5%)
   Execution time upper quantile : 98.009115 µs (97.5%)
                   Overhead used : 1.635497 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers
```
