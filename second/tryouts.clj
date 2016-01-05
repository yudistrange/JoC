(ns second.tryouts)

(def makeset
  (fn [x y]
    (println "Making a set")
    #{x y}))

(defn make-set 
  [%z]
  "Single element for making set"
  #{%z})

(defn make-set-indefinte
  [& args]
  #{args})


;; InterOp with Java
(def myPoint (new java.awt.Point))

;; Static member reference
(.-x myPoint)
(set! (.-x myPoint) 25)
(.getY myPoint)


;; Doto Macro
(doto (java.util.HashMap.)
  (.put "first" 1)
  (.put "second" "2nd"))

(def x 
  (doto (java.util.HashMap.)
    (.put "f" 1)
    (.put "s" "2nd")))
