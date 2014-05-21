(ns clara.benchmark.simple-join
  (:require [clara.rules :refer :all]
            [clara.rules.accumulators :as acc])
  (:import [clara.benchmark.beans Order Customer]))

(defquery vip-orders
          [:?id]
          [Order (= ?id customerId) (= ?total total)]
          [Customer (= ?id id) (= true vip)])