(defn install-division1-package[]
  ;; internal procedures
  (defn getKey [employee-record]
  (defn lookup-key-in-tree
    "lookup key in a set of records, structured as a binary tree"
    [given-key set-of-records]
    (cond (nil? set-of-records) false
          (= given-key (getKey (entry set-of-records))) (entry set-of-records)
          (< given-key (getKey (entry set-of-records))) (recur given-key (left-branch set-of-records))
          :else (recur given-key (right-branch set-of-records))))
(defstruct div1-employee :name :salary)
(defn make-div1-employee [name salary] (struct div1-employee name salary))

(defn make-div2-employee [name salary] (list name salary))

(def all-divisions-employees
  (list division1-employees
        division2-employees
        division3-employees))

(defn install-employee-package []
  
; assuming names are unique
(defn get-record
  "return specified employee's record found from specified personnel file, if found, else nil"
  [name personnel-file]
  (let [fntbl (first personnel-file)
        contents (rest personnel-file)
        lookupfn (get fntbl 'lookup-employee)
        employee (lookupfn name contents)]
    (if (nil? employee)
        nil
        (list fntbl employee))))

(defn get-salary
  "return salary from an employee's record, from any personnel file"
  [rec]
  (let [fntbl (first rec)
        contents (rest rec)
        lookupfn (get fntbl 'lookup-salary)]
    (lookupfn contents)))

(find-employee-record
  "search for employee record across all personnel files, if found, else nil"
  [name personnel-files]
  (if (empty? personnel-files)
      nil
      (let [file (first personnel-files)
            rec (get-record name file)]
        (if (nil? rec)
            (recur name (rest personnel-file))
            rec))))

        



  


