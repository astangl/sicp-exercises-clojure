(defn fringe
  "return list of leaves of tree in left-to-right order"
  [tree]
  (if (seq? tree)
    (if (empty? tree)
      ()
      (concat (fringe (first tree)) (fringe (rest tree))))
    (list tree)))
