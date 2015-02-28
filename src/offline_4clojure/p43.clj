;; Reverse Interleave - Medium
;; Write a function which reverses the interleave process into x number of subsequences.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p43
  (:use clojure.test))

(def __
  #(apply map vector (partition %2 %1)))

; thattommyhall
(fn [s n]
  (map #(take-nth n %) (take n (iterate rest s))))

; alex
#(for [x (range %2)] (take-nth %2 (drop x %1)))

(defn -main []
  (are [soln] soln
(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))
))
