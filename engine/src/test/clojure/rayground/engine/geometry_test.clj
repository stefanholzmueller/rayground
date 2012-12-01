(ns rayground.engine.geometry-test
  (:use rayground.engine.geometry)
  (:use clojure.test)
  (:use midje.sweet)
  )

(defmacro fact2 [name & body]
  `(deftest ~(symbol (clojure.string/replace name #"[^a-zA-Z0-9]" "_"))
     (fact ~name
       ~@body
       )
     )
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
