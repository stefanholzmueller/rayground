(ns rayground.engine.geometry-test
  (:use rayground.engine.geometry)
  (:use clojure.test)
  (:use midje.sweet)
  (:import rayground.engine.geometry.Ray)
  )

(fact (new-ray [] []) => (throws AssertionError))
(fact (new-ray [1 2 3] []) => (throws AssertionError))

(deftest define_a_ray
  (def r (new-ray [1 2 3] [-1.0 -2.0 -3.0]))
  (is (roughly (:direction r) [0.2672612419124244 0.5345224838248488 0.8017837257372732]))
  (is (= (:origin r) [-1.0 -2.0 -3.0]))
  )

(deftest ray_uses_unit_vector
  (def r (new-ray [1 2 3] [0 0 0]))
  (is (roughly (norm (:direction r)) 1))
  )

(deftest length_of_direction_vector
  (is (= (norm [1 1 1]) (Math/sqrt 3)))
  (is (= (norm [2 0 0]) 2.0))
  (is (roughly (norm [1 2 2]) 3))
  )
