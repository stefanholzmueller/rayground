(ns rayground.Engine
  (:use rayground.engine.render)
  (:use rayground.engine.geometry)
  (:gen-class :methods [#^{:static true} [renderSync [] "[I"]]))

(defn -renderSync []
  (render 1600 900 {:sphere (new-sphere [0 0 9000] 2500)})
  )