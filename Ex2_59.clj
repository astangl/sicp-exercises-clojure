(defn element-of-set?
  "return whether x is a member of the set, using unordered list"
  [x set]
  (cond (empty? set) false
        (= x (first set)) true
        :otherwise (recur x (rest set))))

(defn adjoin-set
  "add x to set if it is not already a member, using unordered list"
  [x set]
  (if (element-of-set? x set)
    set
    (cons x set)))

(defn intersection-set
  "compute intersection of 2 sets using unordered lists"
  [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        (element-of-set? (first set1) set2)
          (cons (first set1)
                (intersection-set (rest set1) set2))
        :otherwise (intersection-set (rest set1) set2)))

(defn union-set
  "compute union of 2 sets using unordered lists"
  [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        (element-of-set? (first set1) set2) (union-set (rest set1) set2)
        :otherwise (cons (first set1)
                         (union-set (rest set1) set2))))


