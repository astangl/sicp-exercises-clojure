; Evaluate continued fraction based upon n and d which return terms for
; the numerator and denominator, and k is number of terms (indexed by 1).
; this version uses an iterative process
(defn cont-frac [n d k]
  (loop [i k acc 0]
    (if (= i 0)
        acc
        (recur (dec i) (/ (n i) (+ (d i) acc))))))

; compute e via Euler's continued fraction, using k steps
; all Ni = 1, Di = 1,2,1,1,4,1,1,6,1,1,8,...
(defn compute-e [k]
  (defn d [i]
    (if (= (rem i 3) 2)
        (/ (+ i i 2) 3)
		1))
  (+ 2 (cont-frac (fn [x] 1.0) d k)))

