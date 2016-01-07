(ns fifth.collections)

(defn hi []
  (println "Hi"))

(def mat [[1 2 3]
          [4 5 6]
          [7 8 9]])

(get mat 1)
(get-in mat [0 2])

(defn neighbour
  [delta size xy]
  (filter (fn [new-xy] (every? #(< -1 % size) new-xy))
          (map #(vec (map + xy %)) delta)))

(defn pos
  [elem sequence]
  "Give the position of the elem in the sequence"
  (loop [elem elem s sequence position 0]
    (cond
      (= elem (first s)) position
      (empty? s) -1
      :else (recur elem (rest s) (inc position)))))


(defn getIndices
  [coll]
  (cond
    (map? coll) (seq coll)
    (set? coll) (map vector coll coll)
    :else (map vector (iterate inc 0) coll)))

(defn newPost
  [elem coll]
  (for [[index element] (getIndices coll) :when (= element elem)] index ))
