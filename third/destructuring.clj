(ns third.destructuring)

(defn -main []
  (str "Hola!"))

(defn printName
  [name]
  "Desctructuring vector containing names"
  (let [[f-name m-name l-name] name] 
    (println (str l-name ", " f-name " " m-name))))


(defn pixel-xors
  [max-x max-y]
  "Xor the pixels based on their x and y coordinate"
  (for [x (range max-x) y (range max-y)]
    [x y (rem (bit-xor x y) 256)]))

(def awtFrame (java.awt.Frame.))
(.setVisible awtFrame true)
(.setSize awtFrame (java.awt.Dimension. 200 200))

(def awtGFX (.getGraphics awtFrame))
(.setColor awtGFX (java.awt.Color. 255 128 0))
(.fillRect awtGFX 70 70 50 50)

(doseq [[x y xor] (pixel-xors 200 200)]
  (.setColor awtGFX (java.awt.Color. xor xor 150))
  (.fillRect awtGFX x y 1 1))

(defn clear [g]
  (.clearRect g 0 0 200 200))

(defn fValues 
  [f xs ys]
  "Generate values for the function f"
  (for [x (range xs) y (range ys)]
    [x y (rem (f x y) 256)]))

(defn createAndColor 
  [f xs ys]
  "Create a frame and color it with the provided function as the pattern"
  (clear awtGFX)
  (.setSize awtFrame (java.awt.Dimension. xs ys))
  (doseq [[x y z] (fValues f xs ys)]
    (.setColor awtGFX (java.awt.Color. z z z))
    (.fillRect awtGFX x y 1 1)))
