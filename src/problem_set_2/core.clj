(ns problem-set-2.core
  (:gen-class))

  ;;; Problem 1 ;;;
  ; (defn fib-no-loop
  ;   "takes a number n, computes the nth fibonacci number"
  ;   [n]
  ;   (cond
  ;     (= n 0) n
  ;     (= n 1) n
  ;     :else (+ (fib-no-loop (dec n)) (fib-no-loop (- n 2)))))

  (defn fib
    "takes a number n, computes the nth fibonacci number"
    [n]
    (if (< n 2)
      n
      (loop [i 1 lst 0 nxt 1]
        (if (>= i n)
          nxt
          (recur (inc i) nxt (+ lst nxt))))))


  ;;; Problem 2 ;;;
  (def nested-vectors [[1] [2 [3]] [[[4 5] 6 [7 8]] [9 []] ]]) ; 10 nested sequences

  (defn count-seqs-recur
    "helper function which does the actual recursion, and keeps track of the count"
    [seq count] ; count will be initialized as 0
    (cond
      (not (seqable? seq)) count ; if seq is not a sequence, return 0
      (and (empty? (rest seq)) (not (seqable? (first seq)))) (inc count) ; if seq is the only element and not a sequence, return 1
      (seqable? (first seq)) (count-seqs-recur (first seq) (inc count))
      :else (count-seqs-recur (rest seq) count))) ; otherwise, look at the first element in the sequences
      ;;; TODO: how to do i move to the next element in seq?

  (defn count-seqs
    "takes a sequence that has nested sequences in it, returns the total number of nested sequences,
    including the outer sequence"
    [seq]
    (count-seqs-recur seq 0))

  (= 0 (count-seqs 5))
  (= 1 (count-seqs [1]))
  (= 2 (count-seqs [1 [2]]))
  (= 2 (count-seqs [[1] 2]))
  (= 3 (count-seqs [1 [2 [3]]]))
  (= 4 (count-seqs [[1] [2 [3]]]))
  (= 10 (count-seqs nested-vectors))

  ;;; Problem 3 ;;;
  ;; 1. Sort a sequence of strings by length ;;
  (defn compare-lengths
    "comparator function that takes two strings, returns:
     -1 if length of p is < length of q
     0 if length of p = length of q
     1 if length of p is > length q"
    [p q]
    (cond
      (< (.length p) (.length q)) -1
      (= (.length p) (.length q)) 0
      (> (.length p) (.length q)) 1))

  (defn sort-strings
    "takes a sequence of strings and sorts them by length"
    [seq]
    (sort compare-lengths seq))

  ;; 2. Sort a sequence of hashmaps that have the keys :name, :age, :hometown by the :age field ;;
  (defn compare-hashmaps
    "takes two hashmaps, returns:
    -1 if :age value of p is < :age value of q
    0 if :age value of p is = :age value of q
    1 if :age value of p is > :age value of q"
    [m1 m2]
    (cond
      (< (:age m1) (:age m2)) -1
      (= (:age m1) (:age m2)) 0
      (> (:age m1) (:age m2)) 1))

  (defn sort-ages
    "takes a sequence of hashmaps with keys :name, :age, :hometown and sorts them by :age field"
    [seq]
    (sort compare-hashmaps seq))

  ;; 3. Sort a sequence of BigIntegers by their values
