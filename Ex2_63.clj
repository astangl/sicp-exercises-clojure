(defstruct node :left-branch :entry :right-branch)

(def entry (accessor node :entry))
(def left-branch (accessor node :left-branch))
(def right-branch (accessor node :right-branch))
(defn make-tree
  "build a tree from its entry, left, and right branches"
  [entry left right]
  (struct node left entry right))

(defn element-of-set?
  [x set]
  (cond (nil? set) false
        (= x (entry set)) true
        (< x (entry set)) (element-of-set? x (left-branch set))
        :otherwise (element-of-set? x (right-branch set))))

(defn adjoin-set
  [x set]
  (cond (nil? set) (make-tree x nil nil)
        (= x (entry set)) set
        (< x (entry set)) (make-tree (entry set)
                                     (adjoin-set x (left-branch set))
                                     (right-branch set))
        :otherwise (make-tree (entry set)
                              (left-branch set)
                              (adjoin-set x (right-branch set)))))

(defn tree->list-1
  [tree]
  (if (nil? tree)
      '()
      (concat (tree->list-1 (left-branch tree))
              (cons (entry tree)
                    (tree->list-1 (right-branch tree))))))

(defn tree->list-2
  [tree]
  (defn copy-to-list [tree result-list]
    (if (nil? tree)
        result-list
        (recur (left-branch tree)
               (cons (entry tree)
               (copy-to-list (right-branch tree)
                             result-list)))))
  (copy-to-list tree '()))



