(defn make-sum
  [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list a1 '+ a2)))

(defn make-product
  [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))

(defn sum? [x] (and (seq? x) (= (second x) '+)))
(def addend first)
(defn augend [x] (nth x 2))
(defn product? [x] (and (seq? x) (= (second x) '*)))
(def multiplier first)
(defn multiplicand [x] (nth x 2))
