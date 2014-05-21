(ns clara.benchmark
  (:require [criterium.core :as c])
  (:import [clara.benchmark IBenchmark]))


(def benchmarks
  [(clara.benchmark.drools.SameDayQuery.)
   (clara.benchmark.drools.AccumMax.)
   (clara.benchmark.drools.SimpleQuery.)
   (clara.benchmark.drools.SimpleJoin.)
   (clara.benchmark.interop.SameDayQuery.)
   (clara.benchmark.interop.AccumMax.)
   (clara.benchmark.interop.SimpleQuery.)
   (clara.benchmark.interop.SimpleJoin.)])

(defn- run-benchmark [^IBenchmark benchmark]
  (let [session (.getSession benchmark)
        facts (.getFacts benchmark)]
    (println "Running benchmark: " (.getName benchmark))

    (c/bench (.run benchmark session facts))))

(defn -main
  "Accepts a regex pattern for the benchmarks to run."
  [& [pattern & more]]
  (let [regex (re-pattern (or pattern ".*"))

        ;; Get only the benchmarks that matches the specified pattern.
        matched (filter (fn [^IBenchmark benchmark]
                          (re-matches regex (.getName benchmark)))
                        benchmarks)]

    (if (= 0 (count matched))

      (println "No benchmarks matched.")

      (do
        (println "Matched benchmarks:")
        (doseq [benchmark matched]
          (println "  " (.getName benchmark)))

        ;; Run the benchmarks!
        (doseq [benchmark matched]
          (run-benchmark benchmark))))))