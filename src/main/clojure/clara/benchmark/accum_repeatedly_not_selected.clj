(ns clara.benchmark.accum-repeatedly-not-selected
  "Added to test performance improvements in clara-rules issue 182"
  (:require [clara.rules :refer :all]
            [clara.rules.accumulators :as acc])
  (:import [clara.benchmark.beans Discount Customer]
           [java.util
            ArrayList
            List]))

(def min-id (acc/min (fn [^Customer c] (.getId c)) :returns-fact true))

(defrule vip-discount
  [?customer <- min-id :from [Customer]]
  =>
  (insert-all! (for [n (range 1000)] (Discount. 10))))

(defquery get-discounts
  []
  [Discount (= ?percent percent)])
