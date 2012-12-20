# Countdown numbers game

A solver for the countdown numbers game written using core.logic

## Usage

    (play 674 [5 74 2 3 9])
    => (+ 5 (+ 3 (* 74 9)))

Any number of integer choices may be given and any integer target.

It will only find exact answers, if there is no solution it will return
nil rather than the closest calculation.

This is my first core.logic program, please file an issue/pull request
if you can suggest nicer ways of doing this and/or overcoming any of the
limitations, thanks :D

## License

Copyright © 2012 Adam Clements

Distributed under the Eclipse Public License, the same as Clojure.
