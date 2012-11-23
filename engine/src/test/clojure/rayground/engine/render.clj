(ns test.rayground.engine.render
  (:use rayground.engine.render)
  (:use clojure.test))

(deftest test-main
  (let [result (with-out-str (-main))]
    (is
      (= "Hello, World!" result))))