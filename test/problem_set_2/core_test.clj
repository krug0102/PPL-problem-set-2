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

; (deftest count-seq-testing
;   (testing "count-seqs function"
;   (is (= 0 (count-seqs 5)))
;   (is (= 1 (count-seqs [1])))
;   (is (= 2 (count-seqs [1 [2]])))
;   (is (= 2 (count-seqs [[1] 2])))
;   (is (= 3 (count-seqs [1 [2 [3]]])))
;   (is (= 4 (count-seqs [[1] [2 [3]]])))
;   (is (= 10 (count-seqs nested-vectors)))))

(deftest sort-strings-testing
  (testing "sort-strings function"
  (is (true? (= (sort-strings ["hello" "world" "i" "am" "sorted"]) `("i" "am" "hello" "world" "sorted"))))
  (is (true? (= (sort-strings ["this" "is" "not" "sorted" "correctly"]) `("is" "not" "this" "sorted" "correctly"))))
  (is (true? (= (sort-strings ["a" "aa" "aaa" "aaaa" "aaaaa"]) `("a" "aa" "aaa" "aaaa" "aaaaa"))))
  (is (true? (= (sort-strings ["aaaaa" "aaaa" "aaa" "aa" "a"]) `("a" "aa" "aaa" "aaaa" "aaaaa"))))))

(deftest sort-ages-testing
  (testing "sort-ages function"
  (is (true? (= (sort-ages
    [{:name "me" :age 1 :hometown "here"} {:name "I" :age 64 :hometown "yonder"} {:name "we" :age 13 :hometown "there"} {:name "us" :age 9 :hometown "over there"}])
    `({:name "me" :age 1 :hometown "here"} {:name "us" :age 9 :hometown "over there"} {:name "we" :age 13 :hometown "there"} {:name "I" :age 64 :hometown "yonder"}))))))


(deftest sort-BigIntegers-testing
  (testing "sort-BigIntegers function"
  (is (true? (= (sort-BigIntegers [(BigInteger. "112345") (BigInteger. "58979324") (BigInteger. "123")]) `(123 112345 58979324))))
  (is (true? (= (sort-BigIntegers [(BigInteger. "112345")]) `(112345))))
  (is (true? (= (sort-BigIntegers [(BigInteger. "100") (BigInteger. "200") (BigInteger. "300") (BigInteger. "400")]) `(100 200 300 400))))
  (is (true? (= (sort-BigIntegers [(BigInteger. "400") (BigInteger. "300") (BigInteger. "200") (BigInteger. "100")]) `(100 200 300 400))))))

(deftest impl-testing
  (testing "impl macro"
    (is (true? (impl (< 2 3) (< 5 6))))
    (is (true? (impl (> 2 3) (< 5 (/ 1 0)))))
    (is (true? (impl (> 2 3) (< 5 6))))
    (is (false? (impl (< 2 3) (> 5 6))))
    (is (false? (impl (< 2 3) nil)))))
