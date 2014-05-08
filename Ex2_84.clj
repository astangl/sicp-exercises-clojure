(defn type-tag [datum]
  (cond (number? datum) 'clojure-number
        (list? datum) (first datum)
        :else (error "Bad tagged datum -- TYPE-TAG" datum)))
 
(defn height-of-type [x]
  (let [type (type-tag x)]
    (cond (= type 'clojure-number) 1.0
          (= type 'rational) 2.0
          (= type 'real) 3.0
          (= type 'complex) 4.0
          :else (error "unhandled type" (list x)))))

(defn raise-to-height
  "raise x to the specified height, if below, via coercion"
  [x height]
  (if (< (height-of-type x) height)
      (recur (raise x) height)
      x))

(defn apply-generic
  [op & args]
  (let [type-tags (map type-tag args)
        proc (getOp op type-tags)]
    (if proc
        (apply proc (map contents args))
        (let [maxheight (max (map height-of-type type-tags))
              coerced (map (fn [x] (raise-to-height x maxheight)))]
          (if (nil? coerced)
              (error "No method for these types"
                     (list op type-tags))
              (eval (concat '(apply-generic op) coerced)))))))

