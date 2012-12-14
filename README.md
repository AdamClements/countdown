# Countdown numbers game

A solver for the countdown numbers game written using core.logic

## Usage

    (play [5 74 2 3 9] 674)
    Testing: (+ 5 (+ 3 (* 74 9))) => 674
    (+ 5 (+ 3 (* 74 9)))

Any number of integer options may be given and any integer target,
however if any of the intermediate calculations fall outside the range
of -10000 .. 10000 then the program will probably miss the solution in
all but the simplest cases.

This is my first core.logic program, please file an issue/pull request
if you can suggest nicer ways of doing this and/or overcoming any of the
limitations, thanks :D

## License

Copyright © 2012 Adam Clements

Distributed under the Eclipse Public License, the same as Clojure.
