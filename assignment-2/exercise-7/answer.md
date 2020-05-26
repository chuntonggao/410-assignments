**Briefly describe (in 2-3 sentences) at least one potential disadvantage of this feature (besides the additional implementation effort).**

> Supporting call-by-reference means that our functions could have side effects. Functions with side effects are not pure functions and may change variables in the outer, surrounding scope in unexpected ways. Many programmers favor pure functions in some settings because they are easier to reason about than side effects.


**Briefly describe why it is not possible to support call-by-reference without also introducing variable aliasing (even if there is no explicit alias keyword).**

```
def swap(ref a, ref b) {
    new temp
    set temp, a
    set a, b
    set b, temp
}

new a
set a, 1
new b
set b, 2
call swap(a, b)
print a
print b
```

> In this example, the local `a` in the function scope and the global `a` point to the same memory location which contains an integer value. Therefore, they are actually aliases of each other even though we did not explicitly use the keyword `alias`.   
