;; Compress a Sequence - Easy
;; Write a function which removes consecutive duplicates from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p30
  (:use clojure.test))

(def __
  (fn [ss]
    (let [compress (fn my-compress [s res]
                     (if (empty? s)
                       res
                       (if (= (first s) (first res))
                         (my-compress (rest s) res)
                         (my-compress (rest s) (conj res (first s))))))]
      (reverse (compress ss '())))))

; (fn [a] (map first (partition-by identity a)))
; (fn cmprs [x] (reverse (reduce #(if (~ %2 (first %1 (conj %1 &2))
; `() x))

(defn -main []
  (are [soln] soln
(= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))
))
