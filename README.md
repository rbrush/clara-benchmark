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
WARNING: Final GC required 1.246746575408404 % of runtime
Evaluation count : 480 in 60 samples of 8 calls.
             Execution time mean : 135.949592 ms
    Execution time std-deviation : 2.780825 ms
   Execution time lower quantile : 134.141123 ms ( 2.5%)
   Execution time upper quantile : 142.940998 ms (97.5%)
                   Overhead used : 2.293881 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 9.3776 % Variance is slightly inflated by outliers

*** Running benchmark: clara.same-day-query ***
Evaluation count : 5100 in 60 samples of 85 calls.
             Execution time mean : 11.530499 ms
    Execution time std-deviation : 71.531804 µs
   Execution time lower quantile : 11.400598 ms ( 2.5%)
   Execution time upper quantile : 11.650198 ms (97.5%)
                   Overhead used : 2.293881 ns

*** Running benchmark: drools.simple-query-small ***
Evaluation count : 370080 in 60 samples of 6168 calls.
             Execution time mean : 165.654883 µs
    Execution time std-deviation : 1.652182 µs
   Execution time lower quantile : 163.320501 µs ( 2.5%)
   Execution time upper quantile : 168.780650 µs (97.5%)
                   Overhead used : 2.293881 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-query-small ***
Evaluation count : 2216100 in 60 samples of 36935 calls.
             Execution time mean : 27.642374 µs
    Execution time std-deviation : 386.616700 ns
   Execution time lower quantile : 27.162536 µs ( 2.5%)
   Execution time upper quantile : 28.199580 µs (97.5%)
                   Overhead used : 2.293881 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-query-large ***
Evaluation count : 76500 in 60 samples of 1275 calls.
             Execution time mean : 766.755903 µs
    Execution time std-deviation : 10.061460 µs
   Execution time lower quantile : 754.121628 µs ( 2.5%)
   Execution time upper quantile : 794.361609 µs (97.5%)
                   Overhead used : 2.293881 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 5 (8.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-query-large ***
Evaluation count : 63540 in 60 samples of 1059 calls.
             Execution time mean : 957.640073 µs
    Execution time std-deviation : 23.898791 µs
   Execution time lower quantile : 933.850398 µs ( 2.5%)
   Execution time upper quantile : 1.028153 ms (97.5%)
                   Overhead used : 2.293881 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 4 (6.6667 %)
 Variance from outliers : 12.5900 % Variance is moderately inflated by outliers

*** Running benchmark: drools.simple-join ***
Evaluation count : 36120 in 60 samples of 602 calls.
             Execution time mean : 1.725158 ms
    Execution time std-deviation : 43.289925 µs
   Execution time lower quantile : 1.661358 ms ( 2.5%)
   Execution time upper quantile : 1.831224 ms (97.5%)
                   Overhead used : 2.293881 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 2 (3.3333 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 12.5981 % Variance is moderately inflated by outliers

*** Running benchmark: clara.simple-join ***
Evaluation count : 27120 in 60 samples of 452 calls.
             Execution time mean : 2.228530 ms
    Execution time std-deviation : 35.101504 µs
   Execution time lower quantile : 2.201608 ms ( 2.5%)
   Execution time upper quantile : 2.259227 ms (97.5%)
                   Overhead used : 2.293881 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.accum-max ***
Evaluation count : 9900 in 60 samples of 165 calls.
             Execution time mean : 6.153348 ms
    Execution time std-deviation : 142.787795 µs
   Execution time lower quantile : 6.047246 ms ( 2.5%)
   Execution time upper quantile : 6.572154 ms (97.5%)
                   Overhead used : 2.293881 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 1 (1.6667 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 11.0084 % Variance is moderately inflated by outliers

*** Running benchmark: clara.accum-max ***
Evaluation count : 18660 in 60 samples of 311 calls.
             Execution time mean : 3.255742 ms
    Execution time std-deviation : 100.588492 µs
   Execution time lower quantile : 3.174821 ms ( 2.5%)
   Execution time upper quantile : 3.563958 ms (97.5%)
                   Overhead used : 2.293881 ns

Found 7 outliers in 60 samples (11.6667 %)
	low-severe	 4 (6.6667 %)
	low-mild	 3 (5.0000 %)
 Variance from outliers : 17.4164 % Variance is moderately inflated by outliers

*** Running benchmark: drools.simple-insert ***
Evaluation count : 223320 in 60 samples of 3722 calls.
             Execution time mean : 269.363719 µs
    Execution time std-deviation : 3.020705 µs
   Execution time lower quantile : 265.329249 µs ( 2.5%)
   Execution time upper quantile : 276.609743 µs (97.5%)
                   Overhead used : 2.293881 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 3 (5.0000 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-insert ***
Evaluation count : 80400 in 60 samples of 1340 calls.
             Execution time mean : 750.130107 µs
    Execution time std-deviation : 6.707091 µs
   Execution time lower quantile : 740.167856 µs ( 2.5%)
   Execution time upper quantile : 763.921363 µs (97.5%)
                   Overhead used : 2.293881 ns

*** Running benchmark: drools.accum-insert ***
Evaluation count : 211500 in 60 samples of 3525 calls.
             Execution time mean : 284.900557 µs
    Execution time std-deviation : 2.245721 µs
   Execution time lower quantile : 281.772174 µs ( 2.5%)
   Execution time upper quantile : 289.931380 µs (97.5%)
                   Overhead used : 2.293881 ns

Found 10 outliers in 60 samples (16.6667 %)
	low-severe	 2 (3.3333 %)
	low-mild	 4 (6.6667 %)
	high-mild	 4 (6.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.accum-insert ***
Evaluation count : 458940 in 60 samples of 7649 calls.
             Execution time mean : 132.240206 µs
    Execution time std-deviation : 1.245693 µs
   Execution time lower quantile : 130.684201 µs ( 2.5%)
   Execution time upper quantile : 134.804354 µs (97.5%)
                   Overhead used : 2.293881 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

```
