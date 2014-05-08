(defn split
  "general painter split defined in terms of an inner and outer operation"
  [outer inner]
  (defn splitR [painter n]
    (if (= n 0)
      painter
      (let [smaller (splitR painter (dec n))]
        (outer painter (inner smaller smaller)))))
  splitR)

