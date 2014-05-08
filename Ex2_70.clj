(def sample-tree2_70
  (generate-huffman-tree (list '(A 2) '(BOOM 1) '(GET 2) '(JOB 2)
                               '(NA 16) '(SHA 3) '(YIP 9) '(WAH 1))))

(def sample-coding2_70
  (encode (list 'GET 'A 'JOB
                'SHA 'NA 'NA 'NA 'NA 'NA 'NA 'NA 'NA
                'GET 'A 'JOB
                'SHA 'NA 'NA 'NA 'NA 'NA 'NA 'NA 'NA
                'WAH 'YIP 'YIP 'YIP 'YIP 'YIP 'YIP 'YIP 'YIP 'YIP
                'SHA 'BOOM)
          sample-tree2_70))


