(ns rayground.tests
  (:use clojure.test)
  (:use midje.sweet)
  )

(defmacro fact2 [name & body]
  `(deftest ~(symbol (clojure.string/replace name #"[^a-zA-Z0-9]" "_"))
     (fact ~name
       ~@body
       )
     )
  )