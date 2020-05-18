## 1
### original
<pre>
SHAPE ::= COLOR "Circle" | COLOR "Triangle" | COLOR "Rectangle"
COLOR ::= "Blue" | "Red" | "Green"
</pre>

### factored
<pre>
SHAPE ::= COLOR ("Circle" | "Triangle" | "Rectangle")
COLOR ::= "Blue" | "Red" | "Green"
</pre>

### explanation
Any `SHAPE` must start with a `COLOR`. Therefore, we can use `COLOR` as a prefix for `SHAPE`.

## 2
### original
<pre>
SHAPE ::= "Blue" "Triangle" | COLOR "Circle"
COLOR ::= "Blue" | "Red" | "Green"
</pre>

### factored
<pre>
SHAPE ::= ("Blue" ("Triangle" | "Circle")) | (("RED" | "GREEN") "Circle")
COLOR ::= "Blue" | "Red" | "Green"
</pre>

### explanation
Like question 1, we want to use `COLOR` as a prefix. However, in question 2, `TRIANGLE` and `CIRCLE` require different prefixes, so we need to have two cases.

## 3
### original
<pre>
SHAPE ::= ("Circle" | "Triangle")? "Circle"
</pre>

### factored
<pre>
SHAPE ::= ("Circle" "Circle"?) | ("Triangle" "Circle")
</pre>

### explanation
Every `SHAPE` must start with either `"Circle"` or `"Triangle"`. What should come after `"Circle"` is different from what should come after `"Triangle"`, so we need to have two cases.

## 4
### original
<pre>
SHAPE ::= ("Circle" | "Triangle")* "Circle"
</pre>

### factored
<pre>
SHAPE ::= SHAPE (("CIRCLE" | "TRIANGLE")* "CIRCLE")?
</pre>

### explanation
The original definition tells us that `SHAPE` must end with `"Circle"` but can have an arbitrary number of `"CIRCLE"`s and `"TRIANGLE"`s before the ending .
