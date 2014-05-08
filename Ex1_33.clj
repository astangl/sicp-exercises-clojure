(defn filtered-accumulate
  "accumulate a filtered collection of terms from a to b using a combiner"
  [combiner null-value term a next b filterp]
  (loop [acc null-value n a]
    (if (> n b)
      acc
      (let [cur-term (term n) next-n (next n)]
        (if (filterp cur-term)
            (recur (combiner acc cur-term) next-n)
            (recur acc next-n))))))

; find smallest divisor of n
(defn remainder [a b] (mod a b))
(defn square [n] (* n n))
(defn divides? [a b]
  (= (remainder b a) 0))
(defn find-divisor [n test-divisor]
  (loop [n n test-divisor test-divisor]
    (cond (> (square test-divisor) n) n
          (divides? test-divisor n) test-divisor
          :else (recur n (+ test-divisor 1)))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))


(defn sum-prime-squares [a b]
  (defn square [n] (* n n))
  (defn id [n] n)
  (defn combiner [acc n] (+ acc (* n n)))
  (filtered-accumulate combiner 0 id a inc b prime?))

(defn prod-relative-primes
  "compute product of all positive integers less than n that are relatively prime to n"
  [n]
  (defn id [n] n)
  (defn gcd [a b]
    (if (= b 0)
        a
        (gcd b (remainder a b))))
  (defn filterp [i] (= (gcd i n) 1))
  (filtered-accumulate * 1 id 1 inc (- n 1) filterp))

