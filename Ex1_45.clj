(defn average2 [x y] (/ (+ x y) 2))
(defn average-damp
  "return a modified version of function that averages its value with its arg"
  [f]
  (fn [x] (average2 x (f x))))

(defn fixed-point [f first-guess]
  (defn abs [x] (if (< x 0.0) (- x) x))
  (defn close-enough? [v1 v2]
    (let [tolerance 0.00001]
      (< (abs (- v1 v2)) tolerance)))
  (defn tryf [guess]
    (loop [guess guess next (f guess)]
      (if (close-enough? guess next)
          next
          (recur next (f next)))))
  (tryf first-guess))

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

(defn floor-log2
  "return floor of log base 2 of n for positive n"
  [n]
  (loop [l 0 ll 2]
    (if (> ll n)
        l
        (recur (inc l) (* 2 ll)))))

(defn nthroot
  "try to find nth root of x using repeated applications of average damping"
  [n x]
  (fixed-point
    ((repeated average-damp (floor-log2 n)) (fn [y] (/ x (Math/pow y (- n 1)))))
    2.0))
