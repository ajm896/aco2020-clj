(ns day02
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (line-seq (io/reader (io/resource "02.txt"))))

(def demo-input "1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc")


(defn parse-long [l]
  (Long/parseLong l))

(defn parse-line [l]
  (let [[_ min max char pwd] (re-find #"(\d+)-(\d+) (.): (.*)" l)]
    [(parse-long min) (parse-long max) (first char) pwd]))

(defn part1 [input]
  (->> input
       (map parse-line)
       (filter entry-ok1?)
       count))

(defn entry-ok1? [[min max char pwd]]
  (<= min (get (frequencies pwd) char 0) max))

(part1 input)


(defn entry-ok2? [[one two char pwd]]
  (let [ok1 (= char (nth pwd (dec one)))
        ok2 (= char (nth pwd (dec two)))]
    (not= ok1 ok2)))


(defn part2 [l] (->> l
                     (map parse-line)
                     (filter entry-ok2?)
                     count))

(part2 input)
