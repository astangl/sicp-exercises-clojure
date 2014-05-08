(defn square-list1 [items]
  (if (empty? items)
    ()
    (let [frst (first items)]
      (cons (* frst frst) (square-list1 (rest items))))))

(defn square-list2 [items]
  (map (fn [x] (* x x)) items))

