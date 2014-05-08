(defn average [a b] (/ (+ a b) 2))
(defn square [x] (* x x))
(defn abs [x] (if (< x 0) (- x) x))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn good-enough? [guess x] (< (abs (- (square guess) x)) 0.001))
(defn good-enough2? [guess prevGuess] (< (/ (abs (- guess prevGuess)) guess) 0.0001))

(def sqrt-iter
  (fn [guess x]
    (loop [guess guess x x]
      (if (good-enough? guess x)
        guess
        (recur (improve guess x) x)))))

(def sqrt-iter2	
  (fn [guess x]
    (loop [guess guess prevGuess -10]
      (if (good-enough2? guess prevGuess)
        guess
        (recur (improve guess x) guess)))))


(defn sqrt [x] (sqrt-iter2 1.0 x))



