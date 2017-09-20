# Groovy String Utilities [![](https://jitpack.io/v/Kjens93/groovy-string-utils.svg)](https://jitpack.io/#Kjens93/groovy-string-utils)
Useful Groovy String Utilities for Java 

## Quick Start

**Step 1.** Add the library to your project. The library is available for download from [JitPack](https://jitpack.io/#Kjens93/groovy-string-utils).

**Step 2.** Use it.

```java
import io.github.kjens93.groovy.GroovyStringUtils;
class Example {
    void example() {
        String s = "Hello ${name}!";
        Map context = ImmutableMap.of("name", "Robert");
        String result = GroovyStringUtils.interpolate(s, context);
        System.out.println(result); // Hello Robert!
    }
}
```
