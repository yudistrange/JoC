(ns seventh.astar)

(def directions
  {:up [-1 0]
   :down [1 0]
   :left [0 -1]
   :right [0 1]})

(defn validMovemento
  [xy dir]
  (let [x1 (xy 0)
        y1 (xy 1)
        x2 ((dir directions) 0)
        y2 ((dir directions) 1)]
    (cond
      (> 0 (+ x1 x2)) false
      (>  0 (+ y1 y2)) false
      :else true)))

(defn createNeighbours
  [xy dir]
  (println "Direction logged:")
  (let [[x y] xy [x2 y2] (dir directions)]
    [(+ x x2) (+ y y2)]))

(defn getValidNeighbours
  [xy]
  (for [dir directions :let [neigh ()] :when (validMovement xy dir)]
    (conj neigh (createNeighbours xy dir))))
