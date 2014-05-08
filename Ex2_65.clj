(defn union-ordered-list
  "produce union of two sets represented as ordered lists"
  [set1 set2]
  (cond (empty? set1) set2
        (empty? set2) set1
        :otherwise (let [x1 (first set1) x2 (first set2)]
                     (cond (= x1 x2) (union-ordered-list (rest set1) set2)
                           (< x1 x2) (cons x1 (union-ordered-list (rest set1) set2))
                           :otherwise (cons x2 (union-ordered-list set1 (rest set2)))))))


(defn intersection-ordered-list
  "return intersection of two sets, using ordered list representation"
  [set1 set2]
  (if (or (empty? set1) (empty? set2))
      '()
      (let [x1 (first set1) x2 (first set2)]
        (cond (= x1 x2) (cons x1 (intersection-ordered-list (rest set1) (rest set2)))
              (< x1 x2) (intersection-ordered-list (rest set1) set2)
              :otherwise (intersection-ordered-list set1 (rest set2))))))

(defn union-set
  "order-N union of 2 sets implemented as balanced binary trees"
  [set1 set2]
  (let [l1 (tree->list-2 set1) l2 (tree->list-2 set2)]
    (list->tree (union-ordered-list l1 l2))))

(defn intersection-set
  "order-N intersection of 2 sets implemented as balanced binary trees"
  [set1 set2]
  (let [l1 (tree->list-2 set1) l2 (tree->list-2 set2)]
    (list->tree (intersection-ordered-list l1 l2))))



