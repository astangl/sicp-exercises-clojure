(defstruct linesegment :vect-to-origin :vect-to-endpoint)
(defn make-segment
  "make line segment from two vectors"
  [vOrigin vEnd]
  (struct linesegment vOrigin vEnd))

(def start-segment (accessor linesegment :vect-to-origin))
(defn end-segment
  "return endpoint (vector) of a line segment"
  [ls]
  (add-vect (:vect-to-origin ls) (:vect-to-endpoint ls)))

