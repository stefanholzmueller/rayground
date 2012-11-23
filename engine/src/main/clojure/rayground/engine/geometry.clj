(ns rayground.engine.geometry
  (:use rayground.engine.util))

(defn norm [v] (Math/sqrt (reduce + (map square v))))

(defn normalize [v]
  (let [length (norm v)]
    (map #(/ % length) v)))

(defrecord Ray [direction origin])

(defn new-ray [direction origin]
  {:pre [(= (count direction) 3) (= (count origin) 3)]}
  (->Ray (normalize direction) origin)
  )