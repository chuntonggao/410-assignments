1. Checking for String comparisons in Java that use == instead of .equals().

- Static program analysis
- Value-agnostic. The checker doesn't need to know the value of the string in order to distinguish between `==` and `.equals()`.
- Smallest program unit: operator / keyword
   
2. Generating a breakdown of how much runtime is spent in each Java class.

- Dynamic program analysis
- Smallest program unit: class / file
   
3. Finding methods in Java that have more than a single return statement.

- Static program analysis
- Value-agnostic.  The checker doesn't need to know the return value. It only needs to count how many return statements there are in a method.
- Smallest program unit: method / function
   
4. Calculating the number of code lines that each author has contributed to a Java repository.

- Raw-data analysis (One could also argue that it is meta-property analysis because it analyzes software process metrics (contribution and commit behavior) at the project level.)
- Smallest program unit: project
   
1. Highlighting unnecessary assignments in Java (because the old and the new value of a variable is always guaranteed to be the same).

- Static program analysis
- Value-sensitive. The checker needs to compare the old value and the new value.
- Smallest program unit: class / file

6. Finding suspiciously large files in Java that contain more than 250 lines.

- Raw-data analysis
- Smallest program unit: class / file