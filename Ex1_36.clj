(defn fixed-point [f first-guess]
  (defn abs [x] (if (< x 0.0) (- x) x))
  (defn close-enough? [v1 v2]
    (let [tolerance 0.00001]
      (< (abs (- v1 v2)) tolerance)))
  (defn tryf [guess]
    (loop [guess guess next (f guess)]
      (println guess)
      (if (close-enough? guess next)
          next
          (recur next (f next)))))
  (tryf first-guess))


