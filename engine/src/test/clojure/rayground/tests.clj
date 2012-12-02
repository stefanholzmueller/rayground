(ns rayground.tests
  (:use clojure.test)
  (:use midje.sweet)
  )

; workarounds to wrap Midje (fact)s in clojure.test (deftest)s in order to run them with "mvn test"
; see https://groups.google.com/forum/?fromgroups=#!topic/clojure-maven-plugin/lPYV7MODO0g

(defmacro fact2 [name & body]
  `(deftest ~(symbol (clojure.string/replace name #"[^a-zA-Z0-9]" "_"))
     (fact ~name
       ~@body
       )
     )
  )

(defmacro future-fact2 [name & body]
  `(deftest ~(symbol (clojure.string/replace name #"[^a-zA-Z0-9]" "_"))
     (future-fact ~name
       ~@body
       )
     )
  )