(defn partial-tree
  [elts n]
  (if (= n 0)
      (cons nil elts)
      (let [left-size (quot (dec n) 2)
            left-result (partial-tree elts left-size)
            left-tree (first left-result)
            non-left-elts (rest left-result)
            right-size (- n (inc left-size))
            this-entry (first non-left-elts)
            right-result (partial-tree (rest non-left-elts) right-size)
            right-tree (first right-result)
            remaining-elts (rest right-result)]
        (cons (make-tree this-entry left-tree right-tree) remaining-elts))))

(defn list->tree [elements]
  (first (partial-tree elements (length elements))))
            
