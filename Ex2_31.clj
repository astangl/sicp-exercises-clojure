(defn tree-map
  "apply a function to every element in a tree (nested list)"
  [f tree]
  (map (fn [n] (if (seq? n) (tree-map f n) (f n))) tree))

