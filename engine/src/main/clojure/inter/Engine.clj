(ns inter.Engine
  (:gen-class :methods [#^{:static true} [renderSync [] "[I"]]))

(defn -renderSync []
  (int-array (* 1600 900) 0x666666))