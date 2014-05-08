(def below ())
(def beside ())

(defn right-split
  "recursively split painter to the right, n times"
  [painter n]
  (if (= n 0)
    painter
    (let [smaller (right-split painter (dec n))]
      (beside painter (below smaller smaller)))))

(defn up-split
  "recursively split painter upwards, n times"
  [painter n]
  (if (= n 0)
    painter
    (let [smaller (up-split painter (dec n))]
      (below painter (beside smaller smaller)))))



