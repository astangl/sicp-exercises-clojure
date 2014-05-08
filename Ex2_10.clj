(defn div-interval [x y]
  (if (and (< (lower-bound y) 0.0) (> (upper-bound y) 0.0))
      (throw (IllegalArgumentException. "Divide by zero"))
      (mul-interval x 
        (make-interval (/ 1.0 (upper-bound y))
                       (/ 1.0 (lower-bound y))))))


