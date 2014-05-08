(defn transform-painter
  "transform painter by mapping into a different frame"
  [painter origin corner1 corner2]
  (fn [frame]
    (let [m (frame-coord-map frame) new-origin (m origin)]
      (painter
        (make-frame new-origin
                    (sub-vect (m corner1) new-origin)
                    (sub-vect (m corner2) new-origin))))))

(defn flip-horiz
  "flip painter horizontally"
  [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))

(defn rotate180
  "rotate (square) painter 180 degrees counterclockwise"
  [painter]
  (transform-painter painter
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 0.0)))

(defn rotate270
  "rotate (square) painter 270 degrees counterclockwise"
  [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))


                      

