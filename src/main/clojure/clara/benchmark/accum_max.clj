(ns clara.benchmark.accum-max
  (:require [clara.rules :refer :all]
            [clara.rules.accumulators :as acc])
  (:import [clara.benchmark.beans Order]))

(def max-order-accum
  (accumulate
    :reduce-fn (fn [value item]
                 (if (or (= value nil)
                         (> (.getTotal ^Order item) (.getTotal ^Order value)))
                   item
                   value))))

(defquery max-order
   []
   [?max <- max-order-accum :from [Order]])
