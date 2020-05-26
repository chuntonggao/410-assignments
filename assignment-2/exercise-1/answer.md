**How could procedures (with or without parameters) be used in this language?**

In our project we will design a new stylesheet language called BSS that compiles to CSS and implement a BSS-to-CSS compiler. Although functions do not exist in CSS, we do have functions in BSS. You can declare a function to encapsulate a style block that may potentially be used many times. You can also pass arguments into the function. Example:

```css
/* CSS */
.container {
  -webkit-transform: rotate(60deg);
  -ms-transform: rotate(60deg);
  transform: rotate(60deg);
}
```

```css
/* BSS */
@func transform($effect) {
  -webkit-transform: $effect;
  -ms-transform: $effect;
  transform: $effect;
}
.container { @call transform(rotate(60deg)); }
```

**Do you think they would be beneficial for your users? Why, or why not?**

Many things (like the example) are tedious to write, especially vendor prefixes. BSS functions allows you to make groups of CSS declarations that you want to reuse. You can also pass in arguments to make functions more flexible. 