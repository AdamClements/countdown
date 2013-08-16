(ns countdown.core
  (:require [clojure.core.logic :refer :all]
            [clojure.core.logic.fd :as fd])
  (:refer-clojure :exclude [==]))

(def all-integers (fd/interval Integer/MIN_VALUE Integer/MAX_VALUE))

(defn can-calco [a op b target]
  (conde [(fd/+ a b target) (== op '+)]
         [(fd/* a b target) (== op '*)]
         [(fd/- a b target) (== op '-)]
         [(fd/* target b a) (== op '/)]))

(defn reach-numbero [target choices output]
  (!= choices '())                      ; Run out of choices, fail

  (conde [(membero target choices)      ; Our target is simply a number
          (== output target)]           ; available in our remaining choices

         [(fresh [a op b remaining-choices suboutput]
                 (rembero a choices remaining-choices)
                 (fd/in b all-integers)
                 (reach-numbero b remaining-choices suboutput)
                 (can-calco a op b target)
                 (== output (list op a suboutput)))]))

(defn play
  "Given a target integer, will attempt to arithmetically (+,-,*,/) compute it using
   only numbers given in the array of choices at most once"
  [target choices]
  (first (run 1 [output]
              (reach-numbero target choices output))))
