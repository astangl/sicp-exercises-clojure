; defining reverse for Exercise 2.18 even though it's already built-in
(defn reverse-seq
  "Return reverse of specified sequence"
  [seq]
  (defn revR [acc seq]
    (if (empty? seq)
      acc
      (recur (cons (first seq) acc) (rest seq))))
  (revR () seq))

