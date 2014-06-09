(ns clara.benchmark.accum-insert
  (:require [clara.rules :refer :all]
            [clara.rules.accumulators :as acc])
  (:import [clara.benchmark.beans Discount Customer]))

(defrule vip-discount
   [?customers <- (acc/all) :from [Customer (= true vip)]]
   =>
   (apply insert! (for [customer ?customers]
                    (Discount. 10))))

(defquery get-discounts
  []
  [Discount (= ?percent percent)])