(ns rayground.engine.render-test
  (:use rayground.engine.render)
  (:use rayground.engine.trace)
  (:use rayground.tests)
  (:use midje.sweet)
  )

(fact2 "returns correctly sized integer array"
  (count (render 16 9 {})) => (* 16 9)
  (render 16 9 {}) => (has every? #{0xFFFFFF})

  (provided
    (trace anything {}) => 0xFFFFFF :times (* 16 9)
    )
  )