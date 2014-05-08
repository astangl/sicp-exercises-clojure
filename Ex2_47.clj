(defn make-frame1
  "make frame, using a list"
  [origin edge1 edge2]
  (list origin edge1 edge2))

(def origin-frame1 first)
(def edge1-frame1 second)
(defn edge2-frame1 [f] (nth f 2))


(defstruct frame :origin :edge1 :edge2)
(defn make-frame2
  "make frame, using a struct"
  [origin edge1 edge2]
  (struct frame origin edge1 edge2))
(def origin-frame2 (accessor frame :origin))
(def edge1-frame2 (accessor frame :edge1))
(def edge2-frame2 (accessor frame :edge2))


