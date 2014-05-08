(def *dispatch-map* (hash-map))
(defn build-key [op type] (str op "|" type))

(defn putOp [op type item]
  (def *dispatch-map* (assoc *dispatch-map* (build-key op type) item)))

(defn getOp [op type]
  (get *dispatch-map* (build-key op type)))

(defn square [x] (* x x))

(defn attach-tag [type-tag contents] (cons type-tag contents))
(defn type-tag [datum]
  (if (list? datum)
      (first datum)
      (error "Bad tagged datum -- TYPE-TAG" datum)))
(defn contents [datum]
  (if (list? datum)
      (second datum)
      (error "Bad tagged datum -- CONTENTS" datum)))

(defn install-rectangular-package []
  ;; internal procedures
  (defn real-part [z] (first z))
  (defn imag-part [z] (second z))
  (defn make-from-real-imag [x y] (list x y))
  (defn magnitude [z]
    (Math/sqrt (+ (square (real-part z))
             (square (imag-part z)))))
  (defn angle [z] (Math/atan2 (imag-part z) (real-part z)))
  (defn make-from-mag-ang [r a] (list (* r (Math/cos a)) (* r (Math/sin a))))
  ;; interface to the rest of the system
  (defn tag [x] (attach-tag 'rectangular x))
  (putOp 'real-part '(rectangular) real-part)
  (putOp 'imag-part '(rectangular) imag-part)
  (putOp 'magnitude '(rectangular) magnitude)
  (putOp 'angle '(rectangular) angle)
  (putOp 'make-from-real-imag 'rectangular (fn [x y] (tag (make-from-real-imag x y))))
  (putOp 'make-from-mag-ang 'rectangular (fn [r a] (tag (make-from-mag-ang r a)))))


(defn install-polar-package []
  ;; internal procedures
  (defn magnitude [z] (first z))
  (defn angle [z] (second z))
  (defn make-from-mag-ang [r a] (list r a))
  (defn real-part [z] (* (magnitude z) (Math/cos (angle z))))
  (defn imag-part [z] (* (magnitude z) (Math/sin (angle z))))
  (defn make-from-real-imag [x y] (list (Math/sqrt (+ (square x) (square y)))
                                        (Math/atan2 y x)))
  ;; interface to the rest of the system
  (defn tag [x] (attach-tag 'polar x))
  (putOp 'real-part '(polar) real-part)
  (putOp 'imag-part '(polar) imag-part)
  (putOp 'magnitude '(polar) magnitude)
  (putOp 'angle '(polar) angle)
  (putOp 'make-from-real-imag 'polar (fn [x y] (tag (make-from-real-imag x y))))
  (putOp 'make-from-mag-ang 'polar (fn [r a] (tag (make-from-mag-ang r a)))))

(defn operator [exp] (first exp))
(defn operands [exp] (rest exp))
(defn deriv [exp var]
  (cond (number? exp) 0
        (variable? exp) (if (same-variable? exp var) 1 0)
        :else ((getOp 'deriv (operator exp)) (operands exp) var)))

(defn install-deriv-package []
  ;; internal procedures
  (defn =number? [exp num] (and (number? exp) (= exp num)))
  (defn make-sum [a1 a2]
    (cond (=number? a1 0) a2
          (=number? a2 0) a1
          (and (number? a1) (number? a2)) (+ a1 a2)
          :else (list '+ a1 a2)))
  (def addend first)
  (def augend second)
  (defn make-product [m1 m2]
    (cond (or (=number? m1 0) (=number? m2 0)) 0
          (=number? m1 1) m2
          (=number? m2 1) m1
          (and (number? m1) (number? m2)) (* m1 m2)
          :else (list '* m1 m2)))
  (def multiplier first)
  (def multiplicand second)
  (defn make-exponentiation [b e]
    (cond (=number? e 0) 1
          (=number? e 1) b
          :else (list '** b e)))
  (def base first)
  (def exponent second)

  (defn deriv-sum [exp var] (make-sum (deriv (addend exp) var)
                                      (deriv (augend exp) var)))
  (defn deriv-product [exp var]
    (make-sum
      (make-product (multiplier exp)
                    (deriv (multiplicand exp) var))
      (make-product (deriv (multiplier exp) var)
                    (multiplicand exp))))
  (defn deriv-exponentiation [exp var]
    (make-product (make-product (exponent exp)
                                (make-exponentiation (base exp) (make-sum (exponent exp) -1)))
                  (deriv (base exp) var)))

  ;; interface to the rest of the system
  (putOp 'deriv '+ deriv-sum)
  (putOp 'deriv '* deriv-product)
  (putOp 'deriv '** deriv-exponentiation))


(defn apply-generic [op & args]
  (let [type-tags (map type-tag args)
        proc (getOp op type-tags)]
    (if proc
      (apply proc (map contents args))
      (error "No method for these types -- APPLY-GENERIC" (list op type-tags)))))

(defn real-part [z] (apply-generic 'real-part z))
(defn imag-part [z] (apply-generic 'imag-part z))
(defn magnitude [z] (apply-generic 'magnitude z))
(defn angle [z] (apply-generic 'angle z))

(defn make-from-real-imag [x y]
  ((getOp 'make-from-real-imag 'rectangular) x y))
(defn make-from-mag-ang [r a]
  ((getOp 'make-from-mag-ang 'polar) r a))


