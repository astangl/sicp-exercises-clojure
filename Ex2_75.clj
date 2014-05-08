
(defn make-from-mag-ang
  "make complex number from its magnitude/angle, using message passing"
  [mag ang]
  (fn [op]
    (cond (= op 'real-part) (* mag (Math/cos ang))
          (= op 'imag-part) (* mag (Math/sin ang))
          (= op 'magnitude) mag
          (= op 'angle) ang
          :else (error "Unknown op -- MAKE-FROM-MAG-ANG" op))))

