;; Maximum value - Easy
;; Write a function which takes a variable number of parameters and returns the maximum value.
;; tags - core-functions
;; restricted - max:max-key
(ns offline-4clojure.p38
  (:use clojure.test))

(def __
  (fn my-max
    ([x] x)
    ([x y] (if (> x y) x y))
    ([x y & more] (reduce my-max (my-max x y) more)))
  
  ; (fn [& xs] (reduce #(if (> %2 %1) %2 %1) xs))
  )

(defn -main []
  (are [soln] soln
(= (__ 1 8 3 4) 8)
(= (__ 30 20) 30)
(= (__ 45 67 11) 67)
))
