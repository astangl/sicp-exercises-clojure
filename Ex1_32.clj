(defn accumulate
  "accumulate a collection of terms from a to b using a combiner function"
  [combiner null-value term a next b]
  (loop [acc null-value n a]
    (if (> n b)
        acc
        (recur (combiner acc (term n)) (next n)))))

(defn sum [term a next b]
  (accumulate + 0 term a next b))

(defn product [term a next b]
  (accumulate * 1 term a next b))

