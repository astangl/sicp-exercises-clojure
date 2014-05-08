(defn apply-generic
  [op & args]
  (let [type-tags (map type-tag args)
        proc (getOp op type-tags)]
    (if proc
        (apply proc (map contents args))
        (do (defn can-coerce-all-args [totype type-tags]
              (cond (empty? type-tags) true
                    (nil? (get-coercion (first type-tags) totype)) false
                    :else (recur totype (rest type-tags))))
            (defn coerce-args [totype type-tags args]
              (cond (empty? args) '()
                    (= totype (first type-tags))
                      (cons (first args)
                            (coerce-args totype (rest type-tags) (rest args)))
                    :else (let [t1->t2 (get-coercion (first type-tags) totype)]
                            (cons (t1->t2 (first args))
                                  (coerce-args totype
                                               (rest type-tags)
                                               (rest args))))))
            (defn try-coerce-args [type-tags args]
              (defn try-coerceR [totype-list type-tags args]
                (cond (empty? totype-list) nil
                      (can-coerce-all-args (first totype-list) type-tags)
                        (coerce-args (first totype-list) type-tags args)
                      :else (recur (rest totype-list) type-tags args)))
              (try-coerceR type-tags type-tags args))
            (let [coerced (try-coerce-args type-tags args)]
              (if (nil? coerced)
                  (error "No method for these types"
                         (list op type-tags))
                  (eval (concat '(apply-generic op) coerced))))))))
