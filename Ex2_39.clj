(defn reverse1
  "reverse sequence using fold-right"
  [sequence]
  (fold-right (fn [x y] (fold-right cons (list x) y)) () sequence))

(defn reverse2
  "reverse sequence using fold-left"
  [sequence]
  (fold-left (fn [x y] (cons y x)) () sequence))






