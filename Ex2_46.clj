(defn make-vect [x y] [x y])
(def xcor-vect first)
(def ycor-vect second)


(defn add-vect
  "add two vectors"
  [v1 v2]
  (let [x1 (xcor-vect v1) x2 (xcor-vect v2)
        y1 (ycor-vect v1) y2 (ycor-vect v2)]
    (make-vect (+ x1 x2) (+ y1 y2))))

(defn sub-vect
  "subtract vector v2 from vector v1"
  [v1 v2]
  (let [x1 (xcor-vect v1) x2 (xcor-vect v2)
        y1 (ycor-vect v1) y2 (ycor-vect v2)]
    (make-vect (- x1 x2) (- y1 y2))))

(defn scale-vect
  "multiply vector by a scalar"
  [s v]
  (make-vect (* s (xcor-vect v)) (* s (ycor-vect v))))

