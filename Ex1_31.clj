(defn product
  "Iterative function to multiply terms from a to b"
  [term a next b]
  (loop [a a result 1.0]
    (if (> a b)
        result
        (recur (next a) (* result (term a))))))
    
(defn pi-div-4 [nterms]
  (defn piterm [n]
    (if (even? n)
        (/ (+ n 2) (+ n 3))
        (/ (+ n 3) (+ n 2))))
  (product piterm 0 inc nterms))
  
