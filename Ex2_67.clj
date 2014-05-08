(defn make-leaf [symbol weight] (list 'leaf symbol weight))
(defn leaf? [object] (= (first object) 'leaf))
(defn symbol-leaf [x] (second x))
(defn weight-leaf [x] (nth x 2))

(def left-branch first)
(def right-branch second)
(defn symbols
  "return symbols for a Huffman tree"
  [tree]
  (if (leaf? tree)
      (list (symbol-leaf tree))
      (nth tree 2)))

(defn weight
  "return weight for a Huffman tree"
  [tree]
  (if (leaf? tree)
      (weight-leaf tree)
      (nth tree 3)))

(defn make-code-tree
  "make a Huffman tree by joining left and right subtrees"
  [left right]
  (list left
        right
        (concat (symbols left) (symbols right))
        (+ (weight left) (weight right))))

(defn choose-branch
  [bit branch]
  (cond (= bit 0) (left-branch branch)
        (= bit 1) (right-branch branch)
        :otherwise (error "bad bit -- CHOOSE-BRANCH" bit)))

(defn decode
  "decode stream of 1s and 0s using the supplied Huffman tree"
  [bits tree]
  (defn decode-1
    [bits current-branch]
    (if (empty? bits)
        '()
        (let [next-branch (choose-branch (first bits) current-branch)]
          (if (leaf? next-branch)
              (cons (symbol-leaf next-branch)
                    (decode-1 (rest bits) tree))
              (decode-1 (rest bits) next-branch)))))
  (decode-1 bits tree))

(defn adjoin-set
  [x set]
  (cond (empty? set) (list x)
        (< (weight x) (weight (first set))) (cons x set)
        :otherwise (cons (first set)
                         (adjoin-set x (rest set)))))

(defn make-leaf-set
  [pairs]
  (if (empty? pairs)
      '()
      (let [pair (first pairs)]
        (adjoin-set (make-leaf (first pair) (second pair))
                    (make-leaf-set (rest pairs))))))

(def sample-tree
  (make-code-tree (make-leaf 'A 4)
                  (make-code-tree
                    (make-leaf 'B 2)
                    (make-code-tree (make-leaf 'D 1)
                                    (make-leaf 'C 1)))))
(def sample-message '(0 1 1 0 0 1 0 1 0 1 1 1 0))



