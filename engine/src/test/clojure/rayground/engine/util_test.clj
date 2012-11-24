(ns rayground.engine.util-test
  (:use rayground.engine.util)
  (:use clojure.test)
  (:use midje.sweet)
  (:require [clojure.math.numeric-tower :as math]))

(deftest test_third
  (is (= (third [1 2 3]) 3)))

(deftest test_square
  (is (= (square 3) 9))
  (is (= (square -1) 1))
  (is (roughly (square 2) 2))
  )
