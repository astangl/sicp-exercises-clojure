(defn make-mobile
  "Make binary mobile, based on left and right branch"
  [left right]
  (list left right))


(defn make-branch
  "Make mobile branch based upon its length and structure"
  [len struc]
  (list len struc))


(defn left-branch
  "return left branch of binary mobile"
  [mobile]
  (first mobile))

(defn right-branch
  "return right branch of binary mobile"
  [mobile]
  (first (rest mobile)))

(defn branch-length
  "return length of a binary mobile branch"
  [branch]
  (first branch))

(defn branch-structure
  "return structure associated with a binary mobile branch"
  [branch]
  (first (rest branch)))

(defn is-simple-weight?
  "return whether structure is a simple weight (versus a mobile)"
  [struc]
  (not (seq? struc)))

(defn total-weight
  "return total weight of a binary mobile"
  [mobile]
  (defn total-branch-weight
    "return total weight associated with a branch, ignoring arm weight"
    [branch]
    (let [struc (branch-structure branch)]
      (if (is-simple-weight? struc)
        struc
        (total-weight struc))))
  (+ (total-branch-weight (left-branch mobile))
     (total-branch-weight (right-branch mobile))))


(defn balanced?
  "return whether specified binary mobile is balanced"
  [mobile]
  (let [leftbranch (left-branch mobile)
        rightbranch (right-branch mobile)
        leftstruc (branch-structure leftbranch)
        rightstruc (branch-structure rightbranch)
        leftweight (if (is-simple-weight? leftstruc)
                     leftstruc
                     (total-weight leftstruc))
        rightweight (if (is-simple-weight? rightstruc)
                      rightstruc
                      (total-weight rightstruc))
        leftlen (branch-length leftbranch)
        rightlen (branch-length rightbranch)
        lefttorque (* leftlen leftweight)
        righttorque (* rightlen rightweight)
        leftbalanced (if (is-simple-weight? leftstruc)
                       true
                       (balanced? leftstruc))
        rightbalanced (if (is-simple-weight? rightstruc)
                        true
                        (balanced? rightstruc))]
    (and (= lefttorque righttorque) leftbalanced rightbalanced)))
   
