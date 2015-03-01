;; Function Composition - Medium
;; Write a function which allows you to create function compositions.  The parameter list should take a variable number of functions, and create a function applies them from right-to-left.
;; tags - higher-order-functions:core-functions
;; restricted - comp
(ns offline-4clojure.p58
  (:use clojure.test))

(def __
  ;; your solution here
  (fn
    ([f g]
       (fn [x] (f (g x))))
    ([f g h]
       (fn
         ([x] (f (g (h x))))
         ([x y] (f (g (h x y))))
         ([x y z a] (f (g (h x y z a)))))))
  )

;; austintaylor
(fn [& fs]
  (fn [& xs]
    (first (reduce #(vector (apply %2 %1)) xs (reverse fs)))))

(defn -main []
  (are [soln] soln
(= [3 2 1] ((__ rest reverse) [1 2 3 4]))
(= 5 ((__ (partial + 3) second) [1 2 3 4]))
(= true ((__ zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))
))
