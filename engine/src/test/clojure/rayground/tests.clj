(ns rayground.tests
  (:use clojure.test)
  (:use midje.sweet)
  )

; workarounds to wrap Midje (fact)s in clojure.test (deftest)s in order to run them with "mvn test"
; see https://groups.google.com/forum/?fromgroups=#!topic/clojure-maven-plugin/lPYV7MODO0g

(defmacro wrap-midje [wrapper name & body]
  (let [deftest-sym (gensym (str "test_" (clojure.string/replace name #"[^a-zA-Z0-9]" "_")))
        midje-call (symbol (clojure.string/replace wrapper #"2$" ""))
        ]
    (list 'deftest deftest-sym
      `(~midje-call ~name ~@body)
      )
    )
  )

(defmacro fact2 [name & body]
  `(wrap-midje ~(first &form) ~name ~@body)
  )

(defmacro future-fact2 [name & body]
  `(wrap-midje ~(first &form) ~name ~@body)
  )
