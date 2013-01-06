(ns rayground.engine.geometry
  (:use rayground.engine.util))

(defn norm [v] (Math/sqrt (reduce + (map square v))))

(defn normalize [v]
  (let [length (norm v)]
    (map #(/ % length) v)))

(defn dot
  "dot product"
  [a b]
  (reduce + (map * a b))
  )

(defrecord Ray [origin direction])

(defn new-ray [origin direction]
  {:pre [(= (count origin) 3) (= (count direction) 3)]}
  (->Ray origin (normalize direction))
  )

(defrecord Sphere [center ^double radius])

(defn new-sphere [center radius]
  {:pre [(= (count center) 3) (number? radius)]}
  (->Sphere center radius)
  )

(defn intersect
  "returns the closest intersection as a map containing the distance and the point, or nil"
  [sphere ray]
  (let [offset (:origin ray)
        d (:direction ray)
        c (map - (:center sphere) offset)
        dc (dot d c)
        discriminant (+ (- (square dc) (dot c c)) (square (:radius sphere)))]
    (if (>= discriminant 0)
      (let [distance (- dc (Math/sqrt discriminant))]
        (if (>= distance 0)
          {:distance distance :point (mapv + (map #(* distance %) d) offset)}
          nil
          )
        )
      nil
      )
    )
  )