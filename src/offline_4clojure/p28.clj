;; Flatten a Sequence - Easy
;; Write a function which flattens a sequence.
;; tags - seqs:core-functions
;; restricted - flatten
(ns offline-4clojure.p28
  (:use clojure.test))

(def __
  (fn my-flatten [coll]
    (if (sequential? coll)
      (mapcat my-flatten coll)
      (list coll)))
  ; (filter (complement sequential?)
  ;         (rest (tree-seq sequential? seq x)))
  )

(defn -main []
  (are [soln] soln
(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
(= (__ '((((:a))))) '(:a))
))
