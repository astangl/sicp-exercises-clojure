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

        



  


