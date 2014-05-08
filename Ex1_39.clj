; Evaluate continued fraction based upon n and d which return terms for
; the numerator and denominator, and k is number of terms (indexed by 1).
; this version uses an iterative process
(defn cont-frac [n d k]
  (loop [i k acc 0]
    (if (= i 0)
        acc
        (recur (dec i) (/ (n i) (+ (d i) acc))))))

; compute tangent function via Lambert's continued fraction
; N1 = r; all other Ni = -r^2;  Di = 2i-1;  x is angle in radians; k is # steps
(defn tan-cf [x k]
  (let [mxx (- (* x x))]
    (defn n [i]
      (if (= i 1)
          x
          mxx))
    (cont-frac n (fn [i] (+ i i -1)) k)))

