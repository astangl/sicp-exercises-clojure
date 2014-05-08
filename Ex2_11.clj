(defn mul-interval-new [x y]
  (let [l1 (lower-bound x)
	    l2 (lower-bound y)
        u1 (upper-bound x)
        u2 (upper-bound y)]
    (cond (and (>= l1 0) (>= l2 0)) (make-interval (* l1 l2) (* u1 u2))
          (and (<= u1 0) (<= u2 0)) (make-interval (* u1 u2) (* l1 l2))
          (and (< l1 0) (< l2 0) (> u1 0) (> u2 0)) (make-interval (min (* l1 u2) (* l2 u1)) (max (* l1 l2) (* u1 u2)))
          (and (>= l1 0) (<= u2 0)) (make-interval (* u1 l2) (* l1 u2))
          (and (>= l2 0) (<= u1 0)) (make-interval (* l1 u2) (* u1 l2))
          (and (>= l1 0) (< l2 0) (> u2 0)) (make-interval (* u1 l2) (* u1 u2))
          (and (< l1 0) (> u1 0) (>= l2 0)) (make-interval (* l1 u2) (* u1 u2))
          (and (<= u1 0) (< l2 0) (> u2 0)) (make-interval (* l1 u2) (* l1 l2))
          :else (make-interval (* u1 l2) (* l1 l2)))))


(defn cmpval [f1 f2 x y]
  (let [i1 (f1 x y)
        i2 (f2 x y)]
    (if (not= i1 i2) (println "Failed for " x y))))

(defn testcases [f1 f2]
  (cmpval f1 f2 (make-interval -10 10) (make-interval -10 10))
  (cmpval f1 f2 (make-interval -10 0) (make-interval -10 10))
  (cmpval f1 f2 (make-interval -10 -5) (make-interval -10 7))
  (cmpval f1 f2 (make-interval 0 0) (make-interval 0 0))
  (cmpval f1 f2 (make-interval 0 0) (make-interval -16 0))
  (cmpval f1 f2 (make-interval 0 0) (make-interval -16 -12))
  (cmpval f1 f2 (make-interval 0 0) (make-interval -13 7))
  (cmpval f1 f2 (make-interval 0 0) (make-interval 0 3))
  (cmpval f1 f2 (make-interval -7 -3) (make-interval 7 17))
  (cmpval f1 f2 (make-interval -7 -2) (make-interval 0 21))
  (cmpval f1 f2 (make-interval 3 7) (make-interval 0 0))
  (cmpval f1 f2 (make-interval 4 6) (make-interval -7 -2))
  (cmpval f1 f2 (make-interval 5 7) (make-interval -13 0))
  (cmpval f1 f2 (make-interval 4 8) (make-interval -12 17))
  (cmpval f1 f2 (make-interval 7 13) (make-interval 7 13))
  (cmpval f1 f2 (make-interval 7 11) (make-interval 0 21))
  (cmpval f1 f2 (make-interval -12 7) (make-interval -13 1))
  (cmpval f1 f2 (make-interval -17 2) (make-interval -5 20)))


