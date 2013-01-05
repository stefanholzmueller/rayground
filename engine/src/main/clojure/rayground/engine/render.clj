(ns rayground.engine.render
  (:use rayground.engine.geometry)
  (:use rayground.engine.trace)
  (:use rayground.engine.util)
  (:import java.awt.image.BufferedImage)
  )

(defn render [width height world]
  (let [image         (BufferedImage. width height BufferedImage/TYPE_INT_RGB)
        half-height   (int (/ height 2))
        half-width    (int (/ width 2))
        eye-point     [0 0 0]
        focal-length  1000
        ]
    (doseq [h  (range 0 height)
            w  (range 0 width)
            ]
      (let [x    (- w half-width)
            y    (+ half-height (- h))
            ray  (new-ray eye-point [x y focal-length])
            ]
        (.setRGB image w h (trace ray world))
        )
      )
    image
    )
  )

