; Use (x / y^2 + 2y) / 3 for successive approximation of cube root

(defn abs [x] (if (< x 0) (- x) x))

(defn improve [guess x]
  (/ (+ (/ x guess guess) guess guess) 3.0))

(defn good-enough? [guess prevGuess] (< (/ (abs (- guess prevGuess)) guess) 0.0001))

(def cubert-iter	
  (fn [guess x]
    (loop [guess guess prevGuess -10]
      (if (good-enough? guess prevGuess)
        guess
        (recur (improve guess x) guess)))))


(defn cubert [x] (cubert-iter 1.0 x))

