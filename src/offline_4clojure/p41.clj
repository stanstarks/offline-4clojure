;; Drop Every Nth Item - Easy
;; Write a function which drops every Nth item from a sequence.
;; tags - seqs
;; restricted - 
(ns offline-4clojure.p41
  (:use clojure.test))

(def __
  (fn [s n]
    (let [drp-help (fn drp [x m res]
                     (if (empty? x)
                       res
                       (if (= m 1)
                         (drp (rest x) n res)
                         (drp (rest x) (- m 1) (conj res (first x))))))]
      (drp-help s n []))))

; (mapcat #(if (= n (count %1)) (drop-last %1) %1) (partition-all n
; seqn))


(defn -main []
  (are [soln] soln
(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
))
