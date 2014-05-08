; add to install procedure for complex
(putOp 'equ? '(complex complex)
  (fn [x y] (and (= (real-part x) (real-part y))
                 (= (imag-part x) (imag-part y)))))

; add to install procedure for clojure-number
(putOp 'equ? '(clojure-number clojure-number)
  (fn [x y] (= x y)))

; add to install procedure for rational
; assumes rationals always stored in normalized form
(putOp 'equ? '(rational rational)
  (fn [x y] (and (= (numer x) (numer y))
                 (= (denom x) (denom y)))))


(defn equ? [x y] (apply-generic 'equ? x y))

