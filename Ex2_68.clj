(defn symbol-member
  "return whether a symbol is a member of a specified list of symbols"
  [symbol symbols]
  (cond (empty? symbols) false
        (= symbol (first symbols)) true
        :otherwise (recur symbol (rest symbols))))

(defn encode-symbol
  "encode a single symbol using the specified Huffman tree"
  [symbol tree]
  (if (not (symbol-member symbol (symbols tree)))
      (error "Invalid symbol not contained in tree--" symbol)
      (if (leaf? tree)
          '()
          (if (symbol-member symbol (symbols (left-branch tree)))
              (cons 0 (encode-symbol symbol (left-branch tree)))
              (cons 1 (encode-symbol symbol (right-branch tree)))))))
          
(defn encode
  "encode a message using the specified Huffman tree"
  [message tree]
  (if (empty? message)
      '()
      (concat (encode-symbol (first message) tree)
              (encode (rest message) tree))))

