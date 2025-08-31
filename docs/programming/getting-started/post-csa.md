
# Post CSA Supplement

If you've taken AP CSA, you have a pretty good overview of the Java language and its features. However, some Java features are left out. Here's a short overview of the features we use that aren't covered in CSA.

## Interfaces

_See: [W3 Schools](https://www.w3schools.com/java/java_interface.asp), [Oracle](https://docs.oracle.com/javase/tutorial/java/concepts/interface.html)_

In brief, an interface is like a class, except it defines no instance variables, does not define a constructor, and cannot have instances constructed directly. Additionally, methods described in an interface have no body unless the `default` keyword is used.

_Q: So what? It's just a list of methods?_

_A: That's exactly what it is._

The benefit of an interface is that it's a contract. The interface defines a set of method signatures for classes to implement, and any class can implement them. Classes can also implement more than one interface, as opposed to only extending one class.

When writing robot code, we tend to prefer interfaces to super classes when:

- We're trying to isolate IO from subsystem logic, eg: `private ArmIO io;` -- there's no 'true' `ArmIO`, only different implementations. We don't have to start out with a default class that implements all of the arm's behavior, and then pave over it with subclasses. See the [AdvantageKit documentation](https://github.com/Mechanical-Advantage/AdvantageKit/blob/main/docs/RECORDING-INPUTS.md) for more details.
- We're trying to describe an optional property/behavior a subsystem can have, eg: in 2024 we defined the `Tunable` interface, which provided utility methods to tune the mechanisms of a subsystem.

## Generics

_See: [Geeks For Geeks](https://www.geeksforgeeks.org/generics-in-java/), [Oracle](https://docs.oracle.com/javase/tutorial/java/generics/types.html)_

Generics allow the programmer to write a class that interacts with _some_ type. They're useful for list data structures and container classes. In the context of a robot program, you're likely to encounter them in library features more often than you write them. However, if we continue to develop an in-house utility library, they will prove invaluable.

## Enums

_See: [W3 Schools](https://www.w3schools.com/java/java_enums.asp), [Oracle](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html)_

Enums are useful for defining a fixed number of states or conditions without relying on sentinel integers or strings. In robotics, they're most helpful in developing state machines and an 'action' system to control subsystems.

## Lambdas and Functional Interfaces

_See: [W3 Schools](https://www.w3schools.com/java/java_lambda.asp), [Oracle](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html), [Baeldung](https://www.baeldung.com/java-8-lambda-expressions-tips)_

Explaining functional programming lies mostly beyond my abilities. I will venture to clear up some confusion I've seen regarding lambda expressions.

```java linenums="1"
class Main {
    public static void main(String[] args) {
        Runnable a = () -> someMethod();
        a.run(); // Hi there!

        Runnable b = Main::someMethod;
        b.run(); // Hi there!

        Runnable c = () -> someOtherMethod(17);
        c.run(); // The number is 17

        Runnable d = Main::someOtherMethod; // DOES NOT COMPILE
        // someOtherMethod() needs a parameter

        Runnable e = Main::someMethod(); // DOES NOT COMPILE
        // Class::method creates a method reference, and does not include '()'

        Runnable f = Main::someOtherMethod(17); // DOES NOT COMPILE
        // A method reference refers to the method directly, and does not
        // allow you to specify a parameter. Main::someOtherMethod is a valid
        // Consumer<Integer>.

        Runnable g = () -> Main::someMethod; // DOES NOT COMPILE
        // this expression is nonsensical, like
        // void f() {
        // "Why would a string be alone like this?";
        // }
    }

    public static void someMethod() {
        System.out.println("Hi there!");
    }

    public static void someOtherMethod(int i) {
        System.out.println("The number is " + i);
    }
}
```
