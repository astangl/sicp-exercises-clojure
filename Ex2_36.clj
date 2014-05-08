(defn accumulate-n
  "Accumulate n values, folding using nth element of each specified sequence"
  [op init seqs]
  (if (empty? (first seqs))
    ()
    (cons (accumulate op init (map first seqs))
          (accumulate-n op init (map rest seqs)))))


