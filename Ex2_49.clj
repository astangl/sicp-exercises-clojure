(defn for-each
  "Apply f to each element in specified sequence, discarding results"
  [f seq]
  (if (empty? seq)
    ()
    (do
      (f (first seq))
      (recur f (rest seq)))))

(defn segments->painter
  "from list of segments, create a painter procedure that paints into a frame"
  [segment-list]
  (fn [frame]
    (for-each
      (fn [segment]
        (draw-line
          ((frame-coord-map frame) (start-segment segment))
          ((frame-coord-map frame) (end-segment segment))))
      segment-list)))


(def outline-painter
  (segments->painter (list (make-segment (make-vect 0 0) (make-vect 0 1))
                           (make-segment (make-vect 0 1) (make-vect 1 0))
                           (make-segment (make-vect 1 1) (make-vect 0 -1))
                           (make-segment (make-vect 1 0) (make-vect -1 0)))))

(def x-painter
  (segments->painter (list (make-segment (make-vect 0 0) (make-vect 1 1))
                           (make-segment (make-vect 0 1) (make-vect 1 -1)))))

(def diamond-painter
  (segments->painter (list (make-segment (make-vect 0 0.5) (make-vect 0.5 0.5))
                           (make-segment (make-vect 0.5 1) (make-vect 0.5 -0.5))
                           (make-segment (make-vect 1 0.5) (make-vect -0.5 -0.5))
                           (make-segment (make-vect 0.5 0) (make-vect -0.5 0.5)))))

(def wave-painter
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
                           (make-segment (make-vect 0.15 0.4) (make-vect -0.15 0.25)))))


