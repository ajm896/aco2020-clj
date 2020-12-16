(ns day01
  (:require [clojure.java.io :as io]))

(def input 
  (map #(Long/parseLong %)
       (line-seq (io/reader (io/resource "01.txt")))))

(set (for [x input
           y input
           :when (= 2020 (+ x y))]
       (* x y)))


(set (for [x input
           y input
           z input
           :when (= 2020 (+ x y z))]
       (* x y z)))
