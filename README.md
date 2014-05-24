This project profiles several uses of Clara, starting with trivial examples. It also benchmarks of some equivalent Drools rules for comparison purposes.

Output of a test run is below. This should be considered a work in progress as Clara continues to be optimized.

```
*** Running benchmark: drools.same-day-query ***
WARNING: Final GC required 1.360807965705165 % of runtime
Evaluation count : 480 in 60 samples of 8 calls.
             Execution time mean : 134.410484 ms
    Execution time std-deviation : 1.209009 ms
   Execution time lower quantile : 131.659498 ms ( 2.5%)
   Execution time upper quantile : 136.963623 ms (97.5%)
                   Overhead used : 1.987550 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 1 (1.6667 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.same-day-query ***
Evaluation count : 5520 in 60 samples of 92 calls.
             Execution time mean : 10.909172 ms
    Execution time std-deviation : 91.632528 µs
   Execution time lower quantile : 10.715042 ms ( 2.5%)
   Execution time upper quantile : 11.082065 ms (97.5%)
                   Overhead used : 1.987550 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-query-small ***
Evaluation count : 396000 in 60 samples of 6600 calls.
             Execution time mean : 152.434581 µs
    Execution time std-deviation : 1.246068 µs
   Execution time lower quantile : 150.033013 µs ( 2.5%)
   Execution time upper quantile : 155.056630 µs (97.5%)
                   Overhead used : 1.987550 ns

Found 5 outliers in 60 samples (8.3333 %)
	low-severe	 1 (1.6667 %)
	low-mild	 4 (6.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-query-small ***
Evaluation count : 2123160 in 60 samples of 35386 calls.
             Execution time mean : 28.356743 µs
    Execution time std-deviation : 246.350426 ns
   Execution time lower quantile : 27.959805 µs ( 2.5%)
   Execution time upper quantile : 28.760354 µs (97.5%)
                   Overhead used : 1.987550 ns

*** Running benchmark: drools.simple-query-large ***
Evaluation count : 79500 in 60 samples of 1325 calls.
             Execution time mean : 753.448541 µs
    Execution time std-deviation : 5.724767 µs
   Execution time lower quantile : 743.840277 µs ( 2.5%)
   Execution time upper quantile : 765.201296 µs (97.5%)
                   Overhead used : 1.987550 ns

Found 1 outliers in 60 samples (1.6667 %)
	low-severe	 1 (1.6667 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-query-large ***
Evaluation count : 36780 in 60 samples of 613 calls.
             Execution time mean : 1.602039 ms
    Execution time std-deviation : 18.827460 µs
   Execution time lower quantile : 1.571529 ms ( 2.5%)
   Execution time upper quantile : 1.653507 ms (97.5%)
                   Overhead used : 1.987550 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 3 (5.0000 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: drools.simple-join ***
Evaluation count : 37200 in 60 samples of 620 calls.
             Execution time mean : 1.633420 ms
    Execution time std-deviation : 29.148785 µs
   Execution time lower quantile : 1.602333 ms ( 2.5%)
   Execution time upper quantile : 1.686188 ms (97.5%)
                   Overhead used : 1.987550 ns

Found 3 outliers in 60 samples (5.0000 %)
	low-severe	 1 (1.6667 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 7.7654 % Variance is slightly inflated by outliers

*** Running benchmark: clara.simple-join ***
Evaluation count : 21300 in 60 samples of 355 calls.
             Execution time mean : 2.845482 ms
    Execution time std-deviation : 25.108431 µs
   Execution time lower quantile : 2.806980 ms ( 2.5%)
   Execution time upper quantile : 2.906761 ms (97.5%)
                   Overhead used : 1.987550 ns

*** Running benchmark: drools.accum-max ***
Evaluation count : 9060 in 60 samples of 151 calls.
             Execution time mean : 6.566402 ms
    Execution time std-deviation : 59.474112 µs
   Execution time lower quantile : 6.469561 ms ( 2.5%)
   Execution time upper quantile : 6.706757 ms (97.5%)
                   Overhead used : 1.987550 ns

Found 2 outliers in 60 samples (3.3333 %)
	low-severe	 2 (3.3333 %)
 Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

*** Running benchmark: clara.accum-max ***
Evaluation count : 11760 in 60 samples of 196 calls.
             Execution time mean : 5.177555 ms
    Execution time std-deviation : 128.974424 µs
   Execution time lower quantile : 5.060794 ms ( 2.5%)
   Execution time upper quantile : 5.493988 ms (97.5%)
                   Overhead used : 1.987550 ns

Found 7 outliers in 60 samples (11.6667 %)
	low-severe	 5 (8.3333 %)
	low-mild	 2 (3.3333 %)
 Variance from outliers : 12.5872 % Variance is moderately inflated by outliers
```