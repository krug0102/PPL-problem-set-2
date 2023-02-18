(ns problem-set-2.core-test
  (:require [clojure.test :refer :all]
            [problem-set-2.core :refer :all]))


(deftest fib-testing
  (testing "fib function"
    (is (= 0 (fib 0)))
    (is (= 1 (fib 1)))
    (is (= 1 (fib 2)))
    (is (= 2 (fib 3)))
    (is (= 55 (fib 10)))
    (is (= 4181 (fib 19)))))

(deftest count-seq-testing
  (testing "count-seqs function"
  (is (= 0 (count-seqs 5)))
  (is (= 1 (count-seqs [1])))
  (is (= 2 (count-seqs [1 [2]])))
  (is (= 2 (count-seqs [[1] 2])))
  (is (= 3 (count-seqs [1 [2 [3]]])))
  (is (= 4 (count-seqs [[1] [2 [3]]])))
  (is (= 10 (count-seqs nested-vectors)))))

(deftest impl-testing
  (testing "impl macro"
    (is (true? (impl (< 2 3) (< 5 6))))
    (is (true? (impl (> 2 3) (< 5 (/ 1 0)))))
    (is (true? (impl (> 2 3) (< 5 6))))
    (is (false? (impl (< 2 3) (> 5 6))))
    (is (false? (impl (< 2 3) nil)))))
