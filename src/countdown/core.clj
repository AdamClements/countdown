(ns countdown.core
  (:require [clojure.core.logic :refer :all])
  (:refer-clojure :exclude [==]))

(defn can-calco [a op b target]
  (conde [(+fd a b target) (== op '+)]
         [(*fd a b target) (== op '*)]
         [(-fd a b target) (== op '-)]
         [(*fd target b a) (== op '/)]))

(defn nested-calco [target options output]
  (!= options '())                      ; Run out of options, fail

  (conde [(membero target options)      ; Our target is simply a number
          (== output target)]           ; available in our remaining options

         [(fresh [a op b remaining-options suboutput]
                 (rembero a options remaining-options)
                 (infd b (interval -10000 10000))
                 (nested-calco b remaining-options suboutput)
                 (can-calco a op b target)
                 (== output (list op a suboutput)))]))

(defn play [options target]
  (let [soln (first (run 1 [output] (nested-calco target options output)))]
    (println "Testing... " soln " => " (eval soln))
    soln))
