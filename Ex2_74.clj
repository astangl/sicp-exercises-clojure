(def *dispatch-map* (hash-map))
(defn getKey [op type] (str op "|" type))

(defn get-record
  "return specified employee's record found from specified personnel file, if found, else nil"
  [name personnel-file]
  (let [record-type (first personnel-file)
        contents (rest personnel-file)
        lookup-key (getKey 'lookup-employee record-type)
        lookupfn (get *dispatch-map* lookup-key)]
    (lookupfn name contents)))


(defn get-salary
  "return salary from an employee's record, from any personnel file"
  [rec]
  (let [record-type (first rec)
        contents (rest rec)
        lookup-key (getKey 'lookup-salary record-type)
        contents (rest rec)
        lookupfn (get *dispatch-map* lookup-key)]
    (lookupfn contents)))

(defn find-employee-record
  "search for employee record across all personnel files, if found, else nil"
  [name personnel-files]
  (if (empty? personnel-files)
      nil
      (let [file (first personnel-files)
            rec (get-record name file)]
        (if (nil? rec)
            (recur name (rest personnel-files))
            rec))))

        



  


