(defn cubic
  "return function that computes f(x) -> ax^2 + bx + c"
  [a b c]
  (fn [x] (+ (* x x x) (* a x x) (* b x) c)))

