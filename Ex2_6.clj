(def zero (fn [f] (fn [x] x)))
(defn add-1 [n] (fn [f] (fn [x] (f (n f) x))))


(def one (fn [f] (fn [x] (f x))))
(def two (fn [f] (fn [x] (f (f x)))))

(defn plus [a b]
  (fn [f] (fn [x] ((a f) ((b f) x)))))

