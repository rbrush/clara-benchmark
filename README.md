This project profiles several uses of Clara, starting with trivial examples. It also benchmarks of some equivalent Drools rules for comparison purposes.

Test outputs are below. This should be considered a work in progress as Clara continues to be optimized.

```

*** Running benchmark: drools.same-day-query ***
WARNING: Final GC required 1.290784265758516 % of runtime
Evaluation count : 480 in 60 samples of 8 calls.
             Execution time mean : 141.837990 ms
    Execution time std-deviation : 1.150565 ms
   Execution time lower quantile : 139.641248 ms ( 2.5%)
   Execution time upper quantile : 144.173682 ms (97.5%)
                   Overhead used : 2.241068 ns

*** Running benchmark: clara.same-day-query ***
Evaluation count : 5460 in 60 samples of 91 calls.
             Execution time mean : 11.172075 ms
    Execution time std-deviation : 86.225661 µs
   Execution time lower quantile : 11.054031 ms ( 2.5%)
   Execution time upper quantile : 11.320844 ms (97.5%)
                   Overhead used : 2.241068 ns

*** Running benchmark: drools.simple-query-small ***
Evaluation count : 367020 in 60 samples of 6117 calls.
             Execution time mean : 163.450266 µs
    Execution time std-deviation : 1.215899 µs
   Execution time lower quantile : 161.588408 µs ( 2.5%)
   Execution time upper quantile : 165.459260 µs (97.5%)
                   Overhead used : 2.241068 ns

*** Running benchmark: clara.simple-query-small ***
Evaluation count : 2007960 in 60 samples of 33466 calls.
             Execution time mean : 29.997760 µs
    Execution time std-deviation : 232.970350 ns
   Execution time lower quantile : 29.627234 µs ( 2.5%)
   Execution time upper quantile : 30.532000 µs (97.5%)
                   Overhead used : 2.241068 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-query-large ***
Evaluation count : 81480 in 60 samples of 1358 calls.
             Execution time mean : 738.325533 µs
    Execution time std-deviation : 4.800613 µs
   Execution time lower quantile : 730.388775 µs ( 2.5%)
   Execution time upper quantile : 746.466371 µs (97.5%)
                   Overhead used : 2.241068 ns

*** Running benchmark: clara.simple-query-large ***
Evaluation count : 36000 in 60 samples of 600 calls.
             Execution time mean : 1.681929 ms
    Execution time std-deviation : 11.091976 µs
   Execution time lower quantile : 1.662634 ms ( 2.5%)
   Execution time upper quantile : 1.705667 ms (97.5%)
                   Overhead used : 2.241068 ns

*** Running benchmark: drools.simple-join ***
Evaluation count : 36300 in 60 samples of 605 calls.
             Execution time mean : 1.663648 ms
    Execution time std-deviation : 13.975138 µs
   Execution time lower quantile : 1.644945 ms ( 2.5%)
   Execution time upper quantile : 1.695372 ms (97.5%)
                   Overhead used : 2.241068 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-join ***
Evaluation count : 19920 in 60 samples of 332 calls.
             Execution time mean : 3.039193 ms
    Execution time std-deviation : 21.075864 µs
   Execution time lower quantile : 3.007609 ms ( 2.5%)
   Execution time upper quantile : 3.091982 ms (97.5%)
                   Overhead used : 2.241068 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.accum-max ***
Evaluation count : 9780 in 60 samples of 163 calls.
             Execution time mean : 6.196626 ms
    Execution time std-deviation : 48.272818 µs
   Execution time lower quantile : 6.125581 ms ( 2.5%)
   Execution time upper quantile : 6.312841 ms (97.5%)
                   Overhead used : 2.241068 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.accum-max ***
Evaluation count : 11040 in 60 samples of 184 calls.
             Execution time mean : 5.448588 ms
    Execution time std-deviation : 40.594201 µs
   Execution time lower quantile : 5.399585 ms ( 2.5%)
   Execution time upper quantile : 5.529767 ms (97.5%)
                   Overhead used : 2.241068 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-insert ***
Evaluation count : 216240 in 60 samples of 3604 calls.
             Execution time mean : 278.895761 µs
    Execution time std-deviation : 2.597156 µs
   Execution time lower quantile : 273.921733 µs ( 2.5%)
   Execution time upper quantile : 285.114553 µs (97.5%)
                   Overhead used : 2.241068 ns

Found 4 outliers in 60 samples (6.6667 %)
	low-severe	 1 (1.6667 %)
	low-mild	 3 (5.0000 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-insert ***
Evaluation count : 89640 in 60 samples of 1494 calls.
             Execution time mean : 669.873071 µs
    Execution time std-deviation : 4.469681 µs
   Execution time lower quantile : 663.126942 µs ( 2.5%)
   Execution time upper quantile : 679.072056 µs (97.5%)
                   Overhead used : 2.241068 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.accum-insert ***
WARNING: Final GC required 1.430711429156397 % of runtime
Evaluation count : 215700 in 60 samples of 3595 calls.
             Execution time mean : 281.168471 µs
    Execution time std-deviation : 2.334104 µs
   Execution time lower quantile : 277.573562 µs ( 2.5%)
   Execution time upper quantile : 286.606941 µs (97.5%)
                   Overhead used : 2.238298 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 3 (5.0000 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.accum-insert ***
Evaluation count : 511620 in 60 samples of 8527 calls.
             Execution time mean : 118.240651 µs
    Execution time std-deviation : 734.894078 ns
   Execution time lower quantile : 117.218472 µs ( 2.5%)
   Execution time upper quantile : 119.847404 µs (97.5%)
                   Overhead used : 2.238298 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

```
