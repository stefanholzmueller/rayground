(ns rayground.engine.util)

(defmacro dbg [x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#)) ; from http://stackoverflow.com/questions/2352020/debugging-in-clojure

(defn third [x] (nth x 2))

(defn square [x] (* x x))
