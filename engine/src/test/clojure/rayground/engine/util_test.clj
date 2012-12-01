(ns rayground.engine.util-test
  (:use rayground.engine.util)
  (:use rayground.tests)
  (:use midje.sweet)
  )

(fact2 "returns third element"
  (third [1 2 3]) => 3
  )

(fact2 "squares numbers"
  (square 4) => 16
  (square -1) => 1
  (square (Math/sqrt 2)) => (roughly 2)
  )
