(defn element-of-set?
  "return whether x is a member of the set, using ordered list representation"
  [x set]
  (cond (empty? set) false
        (= x (first set)) true
        (< x (first set)) false
        :otherwise (recur x (rest set))))

(defn intersection-set
  "return intersection of two sets, using ordered list representation"
  [set1 set2]
  (if (or (empty? set1) (empty? set2))
      '()
      (let [x1 (first set1) x2 (first set2)]
        (cond (= x1 x2) (cons x1 (intersection-set (rest set1) (rest set2)))
              (< x1 x2) (intersection-set (rest set1) set2)
              :otherwise (intersection-set set1 (rest set2))))))

(defn adjoin-set
  "return adjoined-set produced from adding member to set if not present"
  [x set]
  (cond (empty? set) (list x)
        (= x (first set)) set
        (> x (first set)) (cons (first set) (adjoin-set x (rest set)))
        :otherwise (cons x set)))


