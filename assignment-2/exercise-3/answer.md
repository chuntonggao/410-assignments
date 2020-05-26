1. Procedures can call other procedures that were defined before themselves.

> True for our language. It should be true for an ideal language. It follows orthogonality. In the global context, we are allowed to call procedures that were previously defined. Orthogonally, in a local context (e.g. inside a procedure), we should also be able to call procedures that were previously defined.

2. Procedures can call other procedures that were defined after themselves.

> False for our language. It should be false for an ideal language. Disallowing such behavior would mean security from bad programming. If such behavior is allowed, when programmers write programs from top to bottom, they might call procedures that do not exist yet, believing that they will declare them later. If they forget to declare them later, the program will call undefined procedures in runtime, resulting in error. Disallowing such behavior will prevent this type of error.

3. Procedures can be overwritten by adding a second procedure definition with the same name.

> True for our language. It should be false for an ideal language. Disallowing such behavior would mean security from bad programming. If such behavior is allowed, programmers need to be think very carefully what the function actually does when they call a function, since the actual behavior of the function depends on the location at which it is called.

4. Procedures can be overwritten like variables by assigning a new procedure body to the procedure name.

> False for our language. It should be false for an ideal language. The rationale is the same as 3. Disallowing such behavior would mean security from bad programming. If such behavior is allowed, programmers need to be think very carefully what the function actually does when they call a function, since the actual behavior of the function depends on the location at which it is called.

5. Procedures can be undefined by assigning a number to the procedure name.

> True for our language (the token is still defined and represents a number, although it is not callable any more). It should be false for an ideal language. This behavior is very counter-intuitive because it does not exist in most programming languages, resulting in bad learnability.