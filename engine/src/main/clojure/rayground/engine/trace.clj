(ns rayground.engine.trace
  (:use rayground.engine.geometry)
  (:use rayground.engine.util)
  )

(def background-color 0x666666)

(defn trace [ray world]
  (let [sphere (:sphere world)]
    (if (nil? sphere)
      background-color
      (if (nil? (intersect sphere ray))
        background-color
        0x00FF00
        )
      )
    )
  )