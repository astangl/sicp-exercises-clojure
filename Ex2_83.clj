
;; to be included in the clojure-number package
(putOp 'raise '(clojure-number)
  (fn [x] (make-rational x 1)))

;; to be included in the rational package
(putOp 'raise '(rational)
  (fn [x] (make-real x)))

;; to be included in the real package
(putOp 'raise '(real)
  (fn [x] (make-from-real-imag x 0)))

(defn raise [x]
  (apply-generic 'raise x))

