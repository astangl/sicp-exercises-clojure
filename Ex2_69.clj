(defn successive-merge
  "perform successive merge of smallest weight nodes to build up Huffman tree"
  [leaves]
  (cond (empty? leaves) nil
        (= (length leaves) 1) (first leaves)
        :otherwise (recur (adjoin-set (make-code-tree (first leaves) (second leaves))
                                      (drop 2 leaves)))))

(defn generate-huffman-tree
  "generate Huffman tree from a list of symbol-frequency pairs"
  [pairs]
  (successive-merge (make-leaf-set pairs)))

