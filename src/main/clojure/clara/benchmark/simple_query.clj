(ns clara.benchmark.simple-query
  (:require [clara.rules :refer :all]
            [clara.rules.accumulators :as acc])
  (:import [clara.benchmark.beans Order]))

(defquery customer-orders
   [:?id]
   [Order (= ?id customerId) (= ?total total)])