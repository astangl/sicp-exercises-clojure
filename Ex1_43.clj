(defn compose
  "compose f after g: create function that takes x and returns f(g(x))"
  [f g]
  (fn [x] (f (g x))))

(defn repeated
  "nth repeated application of f"
  [f n]
  (fn [x] (if (= n 0)
              x
              ((compose f (repeated f (dec n))) x))))
