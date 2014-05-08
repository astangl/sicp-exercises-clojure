(defn for-each
  "Apply f to each element in specified sequence, discarding results"
  [f seq]
  (if (empty? seq)
    ()
    (do
      (f (first seq))
      (recur f (rest seq)))))

