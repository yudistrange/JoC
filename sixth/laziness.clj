(ns sixth.laziness)

(defn rec-steps
  [x & xs]
  (if x
    [x rec-steps xs]
    []))

(defn lazy-range
  [x limit]
  (when (< x limit)
    (conj (lazy-range (inc x) limit) x)))

(defn sort-parts [work]
  (loop [[part & parts] work]
    (if-let [[pivot & xs] (seq part)]
      (let [smaller? #(< % pivot)]
        (recur (list*
                (filter smaller? xs)
                pivot
                (remove smaller? xs)
                parts)))
      (when-let [[x & parts] parts]
        (cons x (sort-parts parts))))))

(defn gcd
  [x y]
  (cond
    (zero? x) y
    (zero? y) x
    (> x y) (recur (rem x y) y)
    (< x y) (recur (rem y x) x)
    :else x))
