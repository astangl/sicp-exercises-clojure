(defn union-set
  "produce union of two sets represented as ordered lists"
  [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :otherwise (let [x1 (first set1) x2 (first set2)]
                     (cond (= x1 x2) (union-set (rest set1) set2)
                           (< x1 x2) (cons x1 (union-set (rest set1) set2))
                           :otherwise (cons x2 (union-set set1 (rest set2)))))))


