(ns rayground.engine.render
  (:use rayground.engine.geometry)
  (:use rayground.engine.trace)
  (:use rayground.engine.util)
  )

(def eye-point [0 0 0])
(def focal-length 1000)

(defn render [width height world]
  (let [pixels       (int-array (* height width))
        half-height  (int (/ height 2))
        half-width   (int (/ width 2))
        ]
    (doseq [h  (range 0 height)
            w  (range 0 width)
            ]
      (let [i    (+ (* h width) w)
            x    (- w half-width)
            y    (+ half-height (- h))
            ray  (new-ray eye-point [x y focal-length])
            ]
        (aset-int pixels i (trace ray world))
        )
      )
    pixels
    )
  )
