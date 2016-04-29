(ns clara.benchmark
  (:require [criterium.core :as c]
            [clojure.tools.cli :as cli]
            [clojure.string :as string])
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
   (clara.benchmark.interop.AccumMax.)
   (clara.benchmark.drools.SimpleInsert.)
   (clara.benchmark.interop.SimpleInsert.)
   (clara.benchmark.drools.AccumInsert.)
   (clara.benchmark.interop.AccumInsert.)
   (clara.benchmark.drools.AccumRepeatedlyNotSelected.)
   (clara.benchmark.interop.AccumRepeatedlyNotSelected.)])

(defn- run-benchmark [^IBenchmark benchmark options]
  (let [session (.getSession benchmark)
        facts (.getFacts benchmark)]
    (println)
    (println "*** Running benchmark:" (.getName benchmark) "***")

    (if (:quick options)
      (c/quick-bench (.run benchmark session facts))
      (c/bench (.run benchmark session facts)))))

(defn get-benchmarks
  "Returns the benchmarks that match the given pattern."
  ([] (get-benchmarks nil))
  ([pattern]
     (let [regex (re-pattern (or pattern ".*"))]

       (filter (fn [^IBenchmark benchmark]
                 (re-matches regex (.getName benchmark)))
               benchmarks))))

(def cli-options
  [["-q" "--quick" "Do a quick benchmark, which is faster but lest accurate."  ]
   ["-l" "--list" "List the available benchmarks."]
   ["-p" "--profile" "Runs the given benchmarks for profiling, without benchmark warming."]
   ["-c" "--count COUNT" "Number of iterations to run when profiling." :default 10000 :parse-fn #(Integer/parseInt %)]])

(defn -main
  "Accepts a regex pattern for the benchmarks to run."
  [& args]
  (let [{:keys [options arguments errors summary]} (cli/parse-opts args cli-options)
        [pattern & more] arguments
        ;; Get only the benchmarks that matches the specified pattern.
        matched (get-benchmarks pattern)]

    (cond

     (> (count errors) 0)
     (do
       (println
        (string/join \newline errors)
        \newline
        "Valid options:")
       (println summary))

     (:list options)
     (do
       (println "Benchmarks:")
       (doseq [benchmark matched]
         (println "  "  (.getName benchmark))))

     (:profile options)
     (do

       (println "Attach profiler and press enter to start benchmarks.")
       (read-line)

       (doseq [benchmark matched]
         (let [session (.getSession benchmark)
               facts (.getFacts benchmark)]

           (println)
           (println "*** Profiling benchmark:" (.getName benchmark) "***")

           (dotimes [n (:count options)]
             (.run benchmark session facts))))

       (println "Finished. Press enter to exit")
       (read-line))

     :default
     (if (= 0 (count matched))

       (println "No benchmarks matched.")

       (do
         (println "Matched benchmarks:")
         (doseq [benchmark matched]
           (println "  " (.getName benchmark)))

         ;; Run the benchmarks!
         (doseq [benchmark matched]
           (run-benchmark benchmark options)))))))
