(defn last-pair
  "Return list containing last element of specified sequence"
  [seq]
  (if (empty? (rest seq))
    seq
    (recur (rest seq))))

