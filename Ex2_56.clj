(def variable? symbol?)
(defn same-variable? [v1 v2]
  (and variable? v1) (variable? v2) (= v1 v2))
(defn =number? [exp num] (and (number? exp) (= exp num)))
(defn make-sum
  [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list '+ a1 a2)))

(defn make-product
  [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

(defn sum? [x] (and (list? x) (= (first x) '+)))
(def addend second)
(defn augend [s] (nth s 2))
(defn product? [x] (and (list? x) (= (first x) '*)))
(def multiplier second)
(defn multiplicand [p] (nth p 2))
(defn error [msg & rst] (throw (new Exception (str msg (print-str rst)))))

(defn exponentiation? [x] (and (list? x) (= (first x) '**)))
(defn make-exponentiation
  [b e]
  (cond (= e 0) 1
        (= e 1) b
        :else (list '** b e)))
(def base second)
(defn exponent [x] (nth x 2))

(defn deriv
  "Perform symbolic differentiation of expression, returning derivative w/ respect to specified var"
  [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        (sum? exp) (make-sum (deriv (addend exp) var)
                             (deriv (augend exp) var))
        (product? exp) (make-sum (make-product (multiplier exp)
                                               (deriv (multiplicand exp) var))
                                 (make-product (deriv (multiplier exp) var)
                                               (multiplicand exp)))
        (exponentiation? exp)
          (make-product (make-product (exponent exp)
                                      (make-exponentiation (base exp) (dec (exponent exp))))
                        (deriv (base exp) var))
        :else (error "unknown expression type -- DERIV" exp)))

