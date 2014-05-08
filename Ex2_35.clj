(defn count-leaves
  "return count of leaves in tree (nested list)"
  [t]
  (accumulate (fn [x y] (+ y (if (seq? x) (count-leaves x) 1)))
              0 t))
;  (accumulate (fn [x y] (+ y (if (seq? x) (count-leaves x) 1)))
;              0 (map count-leaves t)))

