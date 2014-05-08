(defn enumerate-interval [low high]
  (range low (inc high)))

(defn unique-pairs
  "return sequence of unique pairs (i,j) with 1 <= j < i <= n"
  [n]
  (for [i (range 1 (inc n)) j (range 1 i)] (list i j)))

(defn flatmap
  "combined map with folding (using append)"
  [proc seq]
  (accumulate append () (map proc seq)))

(defn make-pair-sum
  [pair]
  (let [fst (first pair) snd (first (rest pair))]
    (list fst snd (+ fst snd))))

(defn next-divisor
  "return next divisor value to test for find-divisor"
  [n]
  (if (= n 2) 3 (+ n 2)))

; find smallest divisor of n
(defn remainder [a b] (mod a b))
(defn square [n] (* n n))
(defn divides? [a b]
  (= (remainder b a) 0))
(defn find-divisor [n test-divisor]
  (loop [n n test-divisor test-divisor]
    (cond (> (square test-divisor) n) n
          (divides? test-divisor n) test-divisor
          :else (recur n (next-divisor test-divisor)))))
(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn prime-sum? [pair]
  (prime? (+ (first pair) (first (rest pair)))))

(defn prime-sum-pairs
 "return all pairs of unique integers up to n that add up to a prime"
 [n]
 (map make-pair-sum
   (filter prime-sum? (unique-pairs n))))





