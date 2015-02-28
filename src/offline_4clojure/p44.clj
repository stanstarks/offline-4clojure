;; Rotate Sequence - Medium
;; Write a function which can rotate a sequence in either direction.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p44
  (:use clojure.test))

(def __
  (fn [n s]
    (let [len (count s)]
      (if (< n 0)
        (recur (+ n len) s)
        (if (> n len)
          (recur (- n len) s)
          (concat (drop n s) (take n s)))))))

(defn thattommyhall [n l]
  (let [c (count l)
        d (mod n c)]
    (take c (drop d (cycle l)))))

(defn -main []
  (are [soln] soln
(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
(= (__ 1 '(:a :b :c)) '(:b :c :a))
(= (__ -4 '(:a :b :c)) '(:c :a :b))
))
