; Evaluate continued fraction based upon n and d which return terms for
; the numerator and denominator, and k is number of terms (indexed by 1).
;(defn cont-frac [n d k]
;  (defn contR [i]
;    (if (= i k)
;        (/ (n i) (d i))
;        (/ (n i) (+ (d i) (contR (inc i))))))
;  (contR 1))


; Evaluate continued fraction based upon n and d which return terms for
; the numerator and denominator, and k is number of terms (indexed by 1).
; this version uses an iterative process
(defn cont-frac [n d k]
  (loop [i k acc 0]
    (if (= i 0)
        acc
        (recur (dec i) (/ (n i) (+ (d i) acc))))))
