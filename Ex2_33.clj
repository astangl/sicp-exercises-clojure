; implement foldr (aka reduce)
(defn accumulate
  "accumulate value by applying binary operator to accumulator w/ each element"
  [op initial sequence]
  (if (empty? sequence)
      initial
      (op (first sequence)
          (accumulate op initial (rest sequence)))))

; named map-seq since name map is reserved
(defn map-seq [p sequence]
  (accumulate (fn [x y] (cons (p x) y)) () sequence))

(defn append [seq1 seq2]
  (accumulate cons seq2 seq1))

(defn length [sequence]
  (accumulate (fn [x y] (inc y)) 0 sequence))


