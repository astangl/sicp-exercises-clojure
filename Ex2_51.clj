(defn below1
  "create composite painter out of 2 other painters, painting first below 2nd"
  [painterB painterT]
  (let [split-point (make-vect 0.0 0.5)
        paint-top (transform-painter painterT
                                     split-point
                                     (make-vect 1.0 0.0)
                                     (make-vect 0.0 1.0))
        paint-bottom (transform-painter painterB
                                        (make-vect 0.0 0.0)
                                        (make-vect 1.0 0.0)
                                        split-point)]
    (fn [frame]
      (paint-top frame)
      (paint-bottom frame))))

(defn below2
  "create composite painter out of 2 other painters, painting first below 2nd"
  [painterB painterT]
  (rotate90 (beside (rotate270 painterB) (rotate270 painterT))))

