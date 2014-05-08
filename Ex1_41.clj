(defn doublef
  "takes 1-arg procedure and returns procedure that applies original twice"
  [f]
  (fn [x] (f (f x))))

