(ns rayground.tests
  (:use clojure.test)
  (:use midje.sweet)
  )

; workarounds to wrap Midje (fact)s in clojure.test (deftest)s in order to run them with "mvn test"
; see https://groups.google.com/forum/?fromgroups=#!topic/clojure-maven-plugin/lPYV7MODO0g

(defmacro midje-wrapper [name & body]
  (let [deftest-name (gensym (clojure.string/replace name #"[^a-zA-Z0-9]" "_"))
        midje-call (clojure.string/replace (first &form) #"2$" "")
        ]
    (deftest deftest-name
      (midje-call name body)
      )
    )
  )

(defmacro fact2 [name & body]
  (midje-wrapper name body)
  )

(defmacro future-fact2 [name & body]
  (midje-wrapper name body)
  )
