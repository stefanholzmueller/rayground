(ns rayground.engine.trace-test
  (:use rayground.engine.trace)
  (:use rayground.engine.geometry)
  (:use rayground.tests)
  (:use midje.sweet)
  )

(fact2 "returns background color #666666 when ray does not intersect with anything"
  (trace (new-ray [0 0 0] [0 0 1]) {}) => 0x666666
  )

(fact2 "returns object color #00FF00 when ray does intersect with anything"
  (trace (new-ray [0 0 0] [0 0 1]) {:sphere (new-sphere [0 0 5] 1)}) => 0x00FF00
  )