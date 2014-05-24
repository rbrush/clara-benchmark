(ns clara.benchmark.simple-insert
  (:require [clara.rules :refer :all])
  (:import [clara.benchmark.beans Discount Customer]))

(defrule vip-discount
   [Customer (= true vip)]
   =>
   (insert! (Discount. 10)))

(defquery get-discounts
  []
  [Discount (= ?percent percent)])