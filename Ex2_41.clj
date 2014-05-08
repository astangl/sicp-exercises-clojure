(defn ex2_41
  "return ordered triples of distinct positive ints i,j,k <= n that sum to s"
  [n s]
  (for [i (range 1 (inc n)) j (range 1 i) k (range 1 j) :while (= s (+ i j k))]
    (list i j k)))


