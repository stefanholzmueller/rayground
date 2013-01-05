(ns rayground.engine.render-test
  (:use rayground.engine.render)
  (:use rayground.engine.trace)
  (:use rayground.tests)
  (:use midje.sweet)
  )

(fact2 "returns correctly sized RenderedImage"
  (let [image (render 16 9 {})]
    (.getWidth image) => 16
    (.getHeight image) => 9
    )
  )

(fact2 "returns RenderedImage with correctly painted pixels"
  (-> (render 16 9 {})
    .getData
    .getDataBuffer
    .getData
    (aget 0)
    ) => 0x123456

  (provided
    (trace anything {}) => 0x123456
    )
  )
