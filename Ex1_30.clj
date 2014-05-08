(defn sum
  "Iterative function to sum terms from a to b"
  [term a next b]
  (loop [a a result 0]
    (if (> a b)
        result
        (recur (inc a) (+ result (term a))))))
    
