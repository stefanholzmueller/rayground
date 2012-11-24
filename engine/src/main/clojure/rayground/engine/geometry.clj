(ns rayground.engine.geometry
  (:use rayground.engine.util))

(defn norm [v] (Math/sqrt (reduce + (map square v))))

(defn normalize [v]
  (let [length (norm v)]
    (map #(/ % length) v)))

(defrecord Ray [origin direction])

(defn new-ray [origin direction]
  {:pre [(= (count origin) 3) (= (count direction) 3)]}
  (->Ray origin (normalize direction))
  )