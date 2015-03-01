;; Longest Increasing Sub-Seq - Hard
;; Given a vector of integers, find the longest consecutive sub-sequence of increasing numbers. If two sub-sequences have the same length, use the one that occurs first. An increasing sub-sequence must have a length of 2 or greater to qualify.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p53
  (:use clojure.test))

(def __
  ;; your solution here
  (fn f ([s]
           (f s [] []))
    ([s res tmp]
       (let [size_t (count tmp)
             size_r (count res)
             item (first s)
             others (rest s)]
         (cond (empty? s) (if (> size_t size_r 1) tmp res)
               (empty? tmp) (recur others res [item])
               (> item (last tmp)) (recur others res (conj tmp item))
               (< size_t 2) (recur others res [item])
               (< size_r size_t) (recur others tmp [item])
               :else (recur others res [item])))))
  )

; austintaylor
(fn [s]
  (let [subseqs (filter
                 #(not= 1 (count %))
                 (mapcat
                  (partial reductions conj [])
                  (tree-seq
                   (complement empty?)
                   (comp list rest) s)))
        inc? #(or (empty? %) (= % (range (first %) (inc (last %)))))]
    (last (sort-by count (filter inc? subseqs)))))

(defn -main []
  (are [soln] soln
(= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
(= (__ [5 6 1 3 2 7]) [5 6])
(= (__ [2 3 3 4 5]) [3 4 5])
(= (__ [7 6 5 4]) [])
))
