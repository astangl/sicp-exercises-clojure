; using consf since cons is reserved
(defn consf [x y]
  (fn [m] (m x y)))

(defn car [z] (z (fn [p q] p)))
(defn cdr [z] (z (fn [p q] q)))
