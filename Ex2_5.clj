; using consf since cons is a reserved word
(defn pow
  "return x^y where y is a non-negative integer"
  [x y]
  (loop [y y acc 1]
    (if (= y 0)
        acc
        (recur (dec y) (* acc x)))))
    
(defn consf [a b] (* (pow 2 a) (pow 3 b)))


(defn powerFactor
  "return power of prime factor p in n"
  [n p]
  (loop [n n acc 0]
    (if (not= 0 (rem n p))
        acc
        (recur (/ n p) (inc acc)))))

(defn car [z] (powerFactor z 2))
(defn cdr [z] (powerFactor z 3))
