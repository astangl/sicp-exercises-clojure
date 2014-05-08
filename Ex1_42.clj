(defn compose
  "compose f after g: create function that takes x and returns f(g(x))"
  [f g]
  (fn [x] (f (g x))))

