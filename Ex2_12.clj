(defn abs [x] (if (< x 0) (- x) x))

(defn make-center-width [c w]
  (make-interval (- c w) (+ c w)))

(defn center [i] (/ (+ (lower-bound i) (upper-bound i)) 2))
(defn width [i] (/ (- (upper-bound i) (lower-bound i)) 2))

(defn make-center-percent
  "Interval constructor taking a center point and percent tolerance"
  [center pct-tol]
  (let [width (abs (* center pct-tol))]
    (make-interval (- center width) (+ center width))))

(defn percent [i]
  (/ (width i) (center i)))


