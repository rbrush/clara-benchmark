(ns clara.benchmark
  (:require [criterium.core :as c])
  (:import [clara.benchmark IBenchmark]))


(def benchmarks
  [(clara.benchmark.drools.SameDayQuery.)
   (clara.benchmark.interop.SameDayQuery.)
   (clara.benchmark.drools.SimpleQuerySmall.)
   (clara.benchmark.interop.SimpleQuerySmall.)
   (clara.benchmark.drools.SimpleQueryLarge.)
   (clara.benchmark.interop.SimpleQueryLarge.)
   (clara.benchmark.drools.SimpleJoin.)
   (clara.benchmark.interop.SimpleJoin.)
   (clara.benchmark.drools.AccumMax.)
   (clara.benchmark.interop.AccumMax.)])

(defn- run-benchmark [^IBenchmark benchmark]
  (let [session (.getSession benchmark)
        facts (.getFacts benchmark)]
    (println)
    (println "*** Running benchmark:" (.getName benchmark) "***")

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