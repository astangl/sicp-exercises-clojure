(defn subsets
  "return set of all subsets (powerset) of s"
  [s]
  (if (empty? s)
    (list ())
    (let [rst (subsets (rest s))]
      (concat rst (map (fn [x] (cons (first s) x)) rst)))))

