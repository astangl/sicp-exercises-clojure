(defn lookup
  "lookup key in a set of records, structured as a binary tree"
  [given-key set-of-records]
  (cond (nil? set-of-records) false
        (= given-key (getKey (entry set-of-records))) (entry set-of-records)
        (< given-key (getKey (entry set-of-records))) (recur given-key (left-branch set-of-records))
        :otherwise (recur given-key (right-branch set-of-records))))



