(defn corner-split
  [painter n]
  (if (= n 0)
      painter
      (let [up (up-split painter (dec n))
            right (right-split painter (dec n))
            top-left (beside up up)
            bottom-right (below right right)
            corner (corner-split painter (dec n))]
        (beside (below painter top-left)
                (below bottom-right corner)))))

(defn flip-vert
  [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn flip-horiz
  [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.1 1.1)))


(def wave-with-smile-painter
  (segments->painter (list (make-segment (make-vect 0 0.85) (make-vect 0.15 -0.25))
                           (make-segment (make-vect 0.15 0.6) (make-vect 0.15 0.05))
                           (make-segment (make-vect 0.3 0.65) (make-vect 0.1 0))
                           (make-segment (make-vect 0.4 0.65) (make-vect -0.05 0.2))
                           (make-segment (make-vect 0.35 0.85) (make-vect 0.05 0.15))
                           (make-segment (make-vect 0.6 1) (make-vect 0.05 -0.15))
                           (make-segment (make-vect 0.65 0.85) (make-vect -0.05 -0.2))
                           (make-segment (make-vect 0.6 0.65) (make-vect 0.15 0))
                           (make-segment (make-vect 0.75 0.65) (make-vect 0.25 -0.3))
                           (make-segment (make-vect 1 0.15) (make-vect -0.4 0.35))
                           (make-segment (make-vect 0.6 0.5) (make-vect 0.15 -0.5))
                           (make-segment (make-vect 0.6 0) (make-vect -0.1 0.3))
                           (make-segment (make-vect 0.5 0.3) (make-vect -0.1 -0.3))
                           (make-segment (make-vect 0.25 0) (make-vect 0.1 0.5))
                           (make-segment (make-vect 0.35 0.5) (make-vect -0.05 0.1))
                           (make-segment (make-vect 0.3 0.6) (make-vect -0.15 -0.2))
                           (make-segment (make-vect 0.15 0.4) (make-vect -0.15 0.25))
                           (make-segment (make-vect 0.4 0.85) (make-vect 0.05 -0.1))
                           (make-segment (make-vect 0.45 0.75) (make-vect 0.1 0))
                           (make-segment (make-vect 0.55 0.75) (make-vect 0.05 0.1)))))

(defn corner-split-new
  "corner split, revised for exercise 2.52"
  [painter n]
  (if (= n 0)
      painter
      (let [up (up-split painter (dec n))
            right (right-split painter (dec n))
            corner (corner-split painter (dec n))]
        (beside (below painter up)
                (below right corner)))))


(defn square-of-four
  [tl tr bl br]
  (fn [painter]
    (let [top (beside (tl painter) (tr painter))
          bottom (beside (bl painter) (br painter))]
      (below bottom top))))

(defn square-limit-new
  "square-limit, revised for exercise 2.52 to make Mr. Rogers look out corners"
  [painter n]
  (let [combine4 (square-of-four flip-vert rotate180
                                 identity  flip-horiz)]
    (combine4 (corner-split painter n))))

                                 

