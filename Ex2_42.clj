(defn abs [n] (if (< n 0) (- n) n))

(defn enumerate-interval
  [low high]
  (range low (inc high)))

(defn flatmap
  "combined map with folding (using append)"
  [proc seq]
  (accumulate append () (map proc seq)))

(def empty-board ())

(defn adjoin-position
  "return board with queen added at specified row, col"
  [row col board]
  (cons (list row col) board))

(defn safe?
  "return whether queen in kth column is safe w/ respect to positions"
  [col positions]
  (defn safeR [p b]
    (let [position (first (filter (fn [n] <= col (first (rest n))) positions))
          row (first position)
          prow (first p)
          pcol (first (rest p))]
      (cond (not b) false
            (= col pcol) b
            (= row prow) false
            (= (abs (- row prow)) (abs (- col pcol))) false
            :else b)))
  (accumulate safeR true positions))

(defn queens
  "solve the N queens problem for a board of specified NxN size"
  [board-size]
  (defn queen-cols [k]
    (if (= k 0)
        (list empty-board)
        (filter
          (fn [positions] (safe? k positions))
          (flatmap
            (fn [rest-of-queens]
              (map (fn [new-row] (adjoin-position new-row k rest-of-queens))
                   (enumerate-interval 1 board-size)))
            (queen-cols (dec k))))))
  (queen-cols board-size))

