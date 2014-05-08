(defn fold-right
  "fold from the right-hand side (same as accumulate)"
  [op initial sequence]
  (if (empty? sequence)
      initial
      (op (first sequence)
          (fold-right op initial (rest sequence)))))

(defn fold-left
  "fold from left-hand side"
  [op initial sequence]
  (defn iter [result rst]
    (if (empty? rst)
      result
      (iter (op result (first rst))
            (rest rst))))
  (iter initial sequence))

 
