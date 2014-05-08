(defn same-parity
  "Return list containing all arguments that have the same even/odd parity as the first argument"
  [& args]
  (filter (fn [x] (= (even? x) (even? (first args)))) args))
  

