(ns intro.core
  (:require [clojure.set :as s])
  (:use [clojure.java.io :only (delete-file)]))

(let [x 10
      y 20]
  (+ x y))

;; Method overload
(defn messenger
;; no args, call self with default msg
  ([] (messenger "Hello world!"))

  ;; One arg, print it
  ([msg] (println msg)))

(messenger)
;; Hello world!

(messenger "Hello class!")

(defn do-union [ & sets]
  (apply s/union sets))

(defn delete-old-file [ & files]
  (doseq [f files]
    (delete-file f)))

(def names ["Bob" "Sally" "Joe"])

(defn rest-names [[_ & rest-names]]
  rest-names)

(rest-names names)

(defn draw-point [& {:keys [x y z]
                     :or {x 0
                          y 0
                          z 0}}]
  [x y z])

(draw-point :x 10 :y 20)

(def fibs
  (map first
    (iterate (fn [[a b]]
              [b (+ a b)])
            [0 1])))

(take 5 fibs)

(drop 5 fibs)

(map inc (take 5 fibs))

(defn show-evens [coll]
  (if-let [evens (seq (filter even? coll))]
    (println (str "The evens are: " evens))
    (println "Ther were no evens.")))

(show-evens (range 10))

(show-evens [1 3 5])

;; (defn str-binary [n]
;;   (cond
;;     (= n 0) "zero"
;;     (= n 1) "one"
;;     :else "unknown"))

;; (defn str-binary [n]
;;   (condp = n
;;     0 "zero"
;;     1 "one"
;;     "unknown"))

(defn str-binary [n]
  (case n
    0 "zero"
    1 "one"
    "unknown"))

(str-binary 0)
(str-binary 1)
(str-binary 4)

;; tail recursive function
(defn factorial
  ([n] (factorial 1 n))
  ([accum n]
   (if (zero? n)
     accum
     (factorial (*' accum n) (dec n)))))

;; Prevent stack overflow
(defn factorial-recur
  ([n] (factorial 1 n))
  ([accum n]
   (if (zero? n)
     accum
     (recur (*' accum n) (dec n)))))

(factorial 5)

(factorial 100)

(factorial 5000)

(factorial-recur 5)

(factorial-recur 100)

(factorial-recur 5000)
