(defn square-tree1
  "return tree (nested list) structure similar to input but with numbers squared"

  [tree]
  (cond (not (seq? tree)) (* tree tree)
    
        (empty? tree) ()
        :else (let [frst (first tree)]
                (cons (square-tree1 frst) (square-tree1 (rest tree))))))


(defn square-tree2
  "return tree (nested list) structure similar to input but with numbers squared"

  [tree]
  (map (fn [n] (if (seq? n) (square-tree2 n) (* n n))) tree))

