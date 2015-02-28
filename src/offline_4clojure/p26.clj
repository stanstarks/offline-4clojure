;; Fibonacci Sequence - Easy
;; Write a function which returns the first X fibonacci numbers.
;; tags - Fibonacci:seqs
;; restricted - 
(ns offline-4clojure.p26
  (:use clojure.test))

(def __
  (fn fib [n]
    (case n
      1 '(1)
      2 '(1 1)
      (let [lasts (reverse (fib (dec n)))]
        (reverse (cons (+
                        (first lasts)
                        (first (rest lasts)))
                       lasts)))
      ))
  )

(fn austintaylors-fib [n]
  (map first (reductions
              (fn [[a b] _] [b (+ a b)]
                [1 1]
                (range 1 n)))))

(fn alex_makurins-fib [n]
  (take n
        (map first (rest (iterate (fn [[a b]]
                                    [b (+ a b)])
                                  [0 1])))))

(defn -main []
  (are [soln] soln
(= (__ 3) '(1 1 2))
(= (__ 6) '(1 1 2 3 5 8))
(= (__ 8) '(1 1 2 3 5 8 13 21))
))
