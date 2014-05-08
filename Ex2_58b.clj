(defn make-sum-simple
  [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list a1 '+ a2)))

(defn make-sum
  [& rst]
  (defn make-sumR
    [l]
    (cond (= 2 (length l)) (make-sum-simple (first l) (second l))
          :otherwise (make-sum-simple (first l) (make-sumR (rest l)))))
  (make-sumR rst))

(defn make-product-simple
  [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))

(defn make-product
  [& rst]
  (defn make-productR
    [l]
    (cond (= 2 (length l)) (make-product-simple (first l) (second l))
          :otherwise (make-product-simple (first l) (make-productR (rest l)))))
  (make-productR rst))


(defn sum? [x] (and (seq? x) (> (length x) 2) (or (= (second x) '+) (sum? (drop 2 x)))))
(defn addend [x] (if (= (second x) '+) (first x) (take-while (fn [l] (not= l '+)) x)))
(defn augend [x] (if (= (length x) 3)
                     (nth x 2)
                     (let [rst (rest (drop-while (fn [l] (not= l '+)) x))]
                       (if (= (length rst) 1) (first rst) rst))))

(defn product? [x] (and (seq? x) (not (sum? x)) (= (second x) '*)))
(def multiplier first)
(defn multiplicand [x] (if (> (length x) 3) (drop 2 x) (nth x 2)))
(defn make-sum-simple
  [a1 a2]
  (cond (=number? a1 0) a2
        (=number? a2 0) a1
        (and (number? a1) (number? a2)) (+ a1 a2)
        :else (list a1 '+ a2)))

(defn make-sum
  [& rst]
  (defn make-sumR
    [l]
    (cond (= 2 (length l)) (make-sum-simple (first l) (second l))
          :otherwise (make-sum-simple (first l) (make-sumR (rest l)))))
  (make-sumR rst))

(defn make-product-simple
  [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list m1 '* m2)))

(defn make-product
  [& rst]
  (defn make-productR
    [l]
    (cond (= 2 (length l)) (make-product-simple (first l) (second l))
          :otherwise (make-product-simple (first l) (make-productR (rest l)))))
  (make-productR rst))


(defn sum? [x] (and (seq? x) (> (length x) 2) (or (= (second x) '+) (sum? (drop 2 x)))))
(defn addend [x] (if (= (second x) '+) (first x) (take-while (fn [l] (not= l '+)) x)))
(defn augend [x] (if (= (length x) 3)
                     (nth x 2)
                     (let [rst (rest (drop-while (fn [l] (not= l '+)) x))]
                       (if (= (length rst) 1) (first rst) rst))))

(defn product? [x] (and (seq? x) (not (sum? x)) (= (second x) '*)))
(def multiplier first)
(defn multiplicand [x] (if (> (length x) 3) (drop 2 x) (nth x 2)))
