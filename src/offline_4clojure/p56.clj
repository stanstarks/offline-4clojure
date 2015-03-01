;; Find Distinct Items - Medium
;; Write a function which removes the duplicates from a sequence. Order of the items must be maintained.
;; tags - seqs:core-functions
;; restricted - distinct
(ns offline-4clojure.p56
  (:use clojure.test))

(def __
  ;; your solution here
  (fn [coll]
    (let [step (fn step [[f :as xs] seen]
                 (if (nil? f) []
                     (if (contains? seen f)
                       (recur (rest xs) seen)
                       (cons f (step (rest xs) (conj seen f))))))]
      (step coll #{})))
  )

;; austintaylor
(fn [s]
  (reduce #(if ((set %1) %2)
             %1
             (conj %1 %2))
          [] s))

(defn -main []
  (are [soln] soln
(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
(= (__ [:a :a :b :b :c :c]) [:a :b :c])
(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (__ (range 50)) (range 50))
))
