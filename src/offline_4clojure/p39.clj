;; Interleave Two Seqs - Easy
;; Write a function which takes two sequences and returns the first item from each, then the second item from each, then the third, etc.
;; tags - seqs:core-functions
;; restricted - interleave
(ns offline-4clojure.p39
  (:use clojure.test))

(def __
  (fn my-interleave [a b]
    (if-not (or (empty? a)
                (empty? b))
      (cons (first a) (cons (first b) (my-interleave (rest a)
                                                     (rest b))))
      '()))
  ; use lazy-seq
  ; (if (and (seq a) (seq b))
  ;   (let [[ha & ta] a
  ;         [hb & tb] b] (list* ha hb (my-interleave ta tb))))
  )

;; or use loop-recur

(defn -main []
  (are [soln] soln
(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
(= (__ [1 2 3 4] [5]) [1 5])
(= (__ [30 20] [25 15]) [30 25 20 15])
))
