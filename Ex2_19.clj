(def first-denomination first)
(def except-first-denomination rest)
(def no-more? empty?)

(defn cc
  "Return # of ways to count change for the specified amount using specified coins"
  [amount coin-values]
  (cond (= amount 0) 1
        (or (< amount 0) (no-more? coin-values)) 0
        :else (+ (cc amount
                     (except-first-denomination coin-values))
                 (cc (- amount
                        (first-denomination coin-values))
                     coin-values))))


