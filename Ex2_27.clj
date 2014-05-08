; deep-reverse-seq reverses all sub-sequences as well as outer sequence
(defn deep-reverse-seq
  "Return deep reverse of specified sequence"
  [seq]
  (defn revR [acc seq]
    (if (empty? seq)
      acc
      (let [frstEl (first seq)]
      (recur (cons (if (seq? frstEl) (deep-reverse-seq frstEl) frstEl) acc) (rest seq)))))
  (revR () seq))

