- Briefly summarize your results up to this point (i.e. which project you picked, how many issues the analyses found and if there are any noteworthy observations).

    We picked [Java Algorithms](https://github.com/TheAlgorithms/Java), a project that implements common data structures and algorithms. The analyzer found 8900 warnings, 4 weak warnings and 35 errors. Most of these issues are related to code style.

- Pick 3 results found by the analyses you find interesting, and inspect them more closely. For each of them, briefly describe what the “issue” found by the analysis is.

    Issue 1: Local variable of concrete class.
    Description: Local variables whose type is declared to be a concrete class. Such declarations may represent a failure of abstraction, and may make testing more difficult. Declarations whose classes come from system or third-party libraries will not be reported by this inspection. This issue appears in the project 200 times. Although the analyzer is correct that local variables of concrete class may make testing more difficult, it is almost unavoidable to use them. I find it very interesting that such a common practice is considered a warning by the analyzer.

    Issue 2: Magic number.
    Description: Numeric literals used without being named by a constant declaration. This issue appears 280 times in the project. I find it interesting because this project is the second most popular repository on GitHub. Given its popularity, it should follow good code style and avoid magic numbers. However, it uses a lot of magic numbers.

    Issue 3: Auto-boxing.
    Description: The automatic wrapping of primitive values as objects. Code which relies on auto-boxing will not work in pre-Java 5.0 environments. This issue appears 407 times in the project. I find it interesting because I don't think it's necessary to highlight auto-boxing issues. Almost no one writes Java for pre-Java 5.0 environments, and auto-boxing is so commonplace that almost everyone uses it.

- For each of the previously described results, explain whether you think that fixing it would make your (or the author’s) code better, and if you think working on this issue would be “time well spent” (i.e. if you think the effort of fixing the code would pay off in the long run).

    Issue 1: In some cases, fixing local variables of concrete class will improve abstraction and testability because doing so would decouple classes from each other. However, in most cases, it is unavoidable to use local variables of concrete class. If fixing this issue doesn't require a lot of work and really improves abstraction and testability, then it is time well spent. This issue should really be considered on a case-by-case basis.

    Issue 2: Fixing magic numbers will definite make the code better because doing so will clarify the intent of each variable and make the code more readable. Also, it doesn't take a lot of effort to fix magic numbers. Therefore, fixing magic numbers is time well spent.

    Issue 3: Fixing auto-boxing will not make the code better. In fact, it might even make the code more confusing by introducing anti-patterns. Auto-boxing is so commonplace that most people don't consider it a problem at all. It is not time well spent to fix this issue.
  
- Based on your findings, briefly summarize (in 3-4 sentences) what advice would you give a friend or colleague that is interested in using static analysis? Can you recommend using the approach you took for this exercise? If not, can you think of a way to use static analyses more effectively?

    My advice is that we should take results produced by static analysis with a grain of salt. In some cases, static analysis highlights potential problems. In some other cases, the advice given by the static analyzer is just not very applicable to the current project. 

    I don't particularly recommend using the approach I took for this exercise. In this exercise, I relied heavily on IntelliJ's GUI (e.g. the "Inspection" menu). This approach has several drawbacks. First, not every Java developer uses IntelliJ. Second, the IntelliJ GUI is different on each OS. Third, GUI operations are hard to automate. I think it is more cross-platform and efficient to integrate static analysis tools into command line interfaces or scripts. This way, we can guarantee that the results are consistent across different machines and platforms. This approach is also automatic.