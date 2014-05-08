; Compute (row, column) element of Pascal's triangle where row & column are
; both 1-based and assuming both are ranged correctly (i.e., no error detection here)

(defn pascal [row col]
  (cond (= col 1) 1
        (= col row) 1
        :else (let [prevrow (dec row)]
                (+ (pascal prevrow (dec col)) (pascal prevrow col)))))
