(ns clara.benchmark.visit-order-same-day
  (:require [clara.rules :refer :all]
            [clj-time.coerce :as coerce])
  (:import [clara.benchmark.beans Order Visit]))

(defquery same-day-visit
   "Queries orders that occurred the same day as a visit."
   []
   [Order (= ?id customerId) (= ?day (coerce/to-local-date time))]
   [Visit (= ?id customerId) (= ?day (coerce/to-local-date time))])