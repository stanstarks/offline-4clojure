;; Pack a Sequence - Easy
;; Write a function which packs consecutive duplicates into sub-lists.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p31
  (:use clojure.test))

(def __
  (fn [x]
    (reverse (reduce #(if (= %2 (first (first %1)))
                        (conj (rest %1) (conj (first %1) %2))
                        (conj %1 (list %2)))
                     (list (list (first x))) (rest x)))))

(defn -main []
  (are [soln] soln
(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))
))
