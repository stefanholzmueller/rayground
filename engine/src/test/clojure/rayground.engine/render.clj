(ns test.rayground.engine.render
  (:use clojure.test
        rayground.engine.render))

(deftest test-main
  (let [result (with-out-str (-main))]
    (is
      (= "Hello, World!" result))))