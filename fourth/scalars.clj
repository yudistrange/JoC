(ns fourth.scalars)
(def hi "Hi")
(println hi)
:keyword
::keyword
::user/keys
:key

(def x ::user/key)
(def y :user/key)
(identical? x y)
(= x y)
x
y

(= 'fx 'fx)
(identical? 'fx 'fx)
(resolve 'x)

