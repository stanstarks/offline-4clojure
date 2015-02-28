;; Group a Sequence - Easy
;; Given a function f and a sequence s, write a function which returns a map.  The keys should be the values of f applied to each item in s.  The value at each key should be a vector of corresponding items in the order they appear in s.
;; tags - core-functions
;; restricted - group-by
(ns offline-4clojure.p63
  (:use clojure.test))

(def __
  (fn [f v]
    (into {} (map #(vector (f (first %)) (vec %))
                  (partition-by f (sort v))))))

; thattommyhall
(fn [f s]
  (apply merge-with concat
         (map #(hash-map (f %) (vector %)) s)))

; austintaylor
(fn [f s]
  (reduce (fn [m a]
            (let [x (f a)]
              (assoc m x (conj (get m x []) a)))) {} s))

; astangl's solution
(fn [f s]
  (letfn [(add-to [m k v] (assoc m k (conj (m k []) v)))]
    (reduce #(add-to %1 (f %2) %2) {} s)))

; alex
(fn [f s]
  (zipmap (distinct (map #(f %) s))
          (for [x (distinct (map #(f %)))])))

(defn -main []
  (are [soln] soln
(= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
(= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
(= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
))
