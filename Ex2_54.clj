(defn equal?
  [a b]
  (let [firsta (first a) firstb (first b)]
    (cond (and (empty? a) (empty? b)) true
          (or (empty? a) (empty? b)) false
          (and (list? firsta) (list? firstb))
            (and (= (first firsta) (first firstb))
                 (equal? (rest firsta) (rest firstb)))
          (or (list? firsta) (list? firstb)) false
          :else (and (= firsta firstb) (equal? (rest a) (rest b))))))


