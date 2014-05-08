(defn element-of-set?
  "return whether x is a member of the set, using unordered list"
  [x set]
  (cond (empty? set) false
        (= x (first set)) true
        :otherwise (recur x (rest set))))

(def adjoin-set cons)

(defn intersection-set
  "compute intersection of 2 sets using unordered lists"
  [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2)
          (cons (first set1)
                (intersection-set (rest set1) set2))
        :otherwise (intersection-set (rest set1) set2)))

(def union-set concat)


