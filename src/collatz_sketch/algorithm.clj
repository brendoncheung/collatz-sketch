(ns collatz-sketch.algorithm)

(defn next-collatz
  "computes the next collatz number"
  [n]
  (cond
    (even? n) (-> n (/ 2))
    (odd? n) (-> n (* 3) (inc))))

(defn collatz-eager
  "eager evaluation of collatz conjecture from a given number, returns a vector"
  [n]
  (loop [number n
         output []]
    (if (= number 1)
      (conj output 1)
      (recur (next-collatz number)
             (conj output number)))))

(defn collatz-lazy
  "lazy evaluation of collatz conjecture from a given number, returns a list"
  [n]
  (lazy-seq
    (cons n (when (> n 1)
              (collatz-lazy (next-collatz n))))))
