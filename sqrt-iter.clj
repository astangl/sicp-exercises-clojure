(defn average [a b] (/ (+ a b) 2))
(defn square [x] (* x x))
(defn abs [x] (if (< x 0) (- x) x))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x] (< (abs (- (square guess) x)) 0.001))
(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x)
               x)))


(defn sqrt [x] (sqrt-iter 1.0 x))



