(def tolerance 0.00001)
(defn iterative-improve
  "perform iterative improvements of guess until it's good enough"
  [good-enough? improve]
  (fn [initial-guess]
    (loop [prev-guess initial-guess new-guess (improve initial-guess)]
      (if (good-enough? new-guess prev-guess)
          new-guess
          (recur new-guess (improve new-guess))))))

(defn average [x y] (/ (+ x y) 2))
(defn abs [x] (if (< x 0) (- x) x))
(defn good-enough?
  [guess prevGuess]
  (< (/ (abs (- guess prevGuess)) guess) 0.0001))

(defn sqrt [x]
  (defn improve-sqrt [guess]
    (average guess (/ x guess)))
  ((iterative-improve good-enough? improve-sqrt) 1.0))

(defn fixed-point
  [f first-guess]
  ((iterative-improve good-enough? (fn [x] (f x))) first-guess))

