first if: may be executed 
second if: definitely will be executed
third if: definitely will not be executed

```java
     void fun(int a, int b) {
[1]      int x = a            // x == a                            
[2]      int y = b            // x == a, y == b
[3]      int z = 0            // x == a, y == b, z == 0
[4]                           // x == a, y == b, z == 0
[5]      if (x == 0)          // x == z == 0, y == b
[6]          y = x            // x == y == z == 0
[7]      else                 // y == b, z == 0, x == a != 0
[8]          y = z            // y == z == 0, x == a != 0
[9]                           // y == z == 0
[10]     if (y == 0)          // y == z == 0
[11]         x = z            // x == y == z == 0
[12]                          // x == y == z == 0
[13]     if (x != y)          // impossible
[14]         z = 1            // impossible
[15]                          // x == y == z == 0
[16]     print(x)             // x == y == z == 0
[17]     print(y)             // x == y == z == 0
[18]     print(z)             // x == y == z == 0
     }
```