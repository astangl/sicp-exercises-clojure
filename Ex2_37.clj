(defn dot-product
  "return dot product of two vectors"
  [v w]
  (accumulate + 0 (map * v w)))

(defn matrix-star-vector
  "multiply matrix times vector"
  [m v]
  (map (fn [mi] (accumulate + 0 (map * mi v))) m))

(defn transpose
  "transpose rows and columns in matrix"
  [mat]
  (accumulate-n cons () mat))

(defn matrix-star-matrix
  "multiply matrix by matrix"
  [m n]
  (let [cols (transpose n)]
    (map (fn [mi] (map (fn [nj] (dot-product mi nj)) cols)) m)))


