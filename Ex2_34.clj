(defn horner-eval
  "Evaluate polynomial using Horner's rule"
  [x coefficient-sequence]
  (accumulate (fn [this-coeff higher-terms] (+ (* x higher-terms) this-coeff))
              0
              coefficient-sequence))


