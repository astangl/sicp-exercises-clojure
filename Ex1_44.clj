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

(defn smooth
  "create smoothed version that averages f(x) with f(x-dx) and f(x+dx)"
  [f]
  (let [dx 0.0001]
    (fn [x] (/ (+ (f (- x dx)) (f x) (f (+ x dx))) 3))))

(defn smooth-repeated
  "create the n-fold smoothed function based upon f"
  [f n]
  ((repeated smooth n) f))

