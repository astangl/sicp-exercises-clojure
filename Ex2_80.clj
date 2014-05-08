; add to install procedure for complex
(putOp '=zero? '(complex)
  (fn [x] (and (= 0 (real-part x)) (= 0 (imag-part x)))))

; add to install procedure for clojure-number
(putOp '=zero? '(clojure-number)
  (fn [x] (= 0 x)))

; add to install procedure for rational
; assumes 0/0 should not count as zero
(putOp '=zero? '(rational)
  (fn [x] (and (= (numer x) 0)
               (not= (denom x) 0))))

(defn =zero? [x] (apply-generic '=zero? x))

