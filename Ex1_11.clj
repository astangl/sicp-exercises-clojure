; compute f where f(n) = n if n < 3 and f(n-1) + 2f(n-2) + 3f(n-3) if n >= 3
; as a recursive process and a linear process

(defn frecur [n]
  (if (< n 3) n
              (+ (frecur (- n 1)) (* 2 (frecur (- n 2))) (* 3 (frecur (- n 3))))))


; a, b, c track f(x-1), f(x-2), and f(x-3) respectively
(defn fiter [n]
  (if (< n 3) n
              (loop [x 3 a 2 b 1 c 0]
                (let [fx (+ a b b c c c)]
                  (if (= x n) fx
                              (recur (inc x) fx a b))))))
