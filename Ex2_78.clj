(defn attach-tag [type-tag contents]
  (if (and (= type-tag 'clojure-number) (number? contents))
      contents
      (cons type-tag contents)))
(defn type-tag [datum]
  (cond (number? datum) 'clojure-number
        (list? datum) (first datum)
        :else (error "Bad tagged datum -- TYPE-TAG" datum)))
 
(defn contents [datum]
  (cond (number? datum) datum
        (list? datum) (second datum)
        :else (error "Bad tagged datum -- CONTENTS" datum)))


