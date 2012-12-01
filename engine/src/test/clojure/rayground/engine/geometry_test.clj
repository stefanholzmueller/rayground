(ns rayground.engine.geometry-test
  (:use rayground.engine.geometry)
  (:use rayground.tests)
  (:use midje.sweet)
  )

(fact2 "assert vectors have exactly 3 elements"
  (new-ray [] []) => (throws AssertionError)
  (new-ray [1 2 3] [1]) => (throws AssertionError)
  (new-ray [1 2 3] [1 2 3]) =not=> (throws AssertionError)
  )

(fact2 "constructor fn creates a ray"
  (let [r (new-ray [-1.0 -2.0 -3.0] [1 2 3])]
    (:origin r) => [-1.0 -2.0 -3.0]
    (:direction r) => [0.2672612419124244 0.5345224838248488 0.8017837257372732]
    )
  )

(fact2 "ray uses (normalized) unit vector"
  (norm (:direction (new-ray [0 0 0] [1 2 3]))) => (roughly 1)
  )

(fact2 "length of vectors"
  (norm [1 1 1]) => (Math/sqrt 3)
  (norm [2 0 0]) => 2.0
  (norm [1 2 2]) => 3.0
  )

(fact2 "no intersection between ray and sphere returns nil"
  (intersect (new-sphere [0 0 5] 1) (new-ray [0 0 0] [1 0 0])) => nil
  )

(fact2 "intersection between ray and sphere returns closest intersection"
  (intersect (new-sphere [0 0 5] 1) (new-ray [0 0 0] [0 0 1])) => [0.0 0.0 4.0]
  (intersect (new-sphere [0 0 9] 3) (new-ray [3 0 3] [0 0 1])) => [3.0 0.0 9.0]
  )

(fact2 "no intersection in direction of ray"
  (intersect (new-sphere [0 0 5] 1) (new-ray [0 0 8] [0 0 1])) => nil
  )

(fact2 "dot product"
  (dot [1 1 1] [1 2 3]) => 6
  (dot [1 2 3] [1 0 -1]) => -2
  )
