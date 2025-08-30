
# Team 401 Code Standards

Code standards are a set of guidelines and rules that software teams adhere to when writing code. This ensures consistency throught all codebases. These standards make it easier for developers to collaborate, maintain, and understand code, ultimately improving the quality and reliability of software.

The [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) serves as a reference for developers working on Google projects. We will be using it as our baseline so by default, follow its rules. Any deviations or additions will be detailed here, but follow their document when in doubt.

**Right now, this document is incomplete and unconfirmed. Its word is not law.**

## Style Standards

### Spacing

We indent with 4 spaces.

### Symbol Naming

We do not use Hungarian prefixes/suffixes (eg: `m_RobotContainer`).  Instead, we follow cammel case convention (eg: `fluffyDog`). If you copy code from WPI's examples, rename the variables.

Try to name your variables as clearly as possible. Include exactly what they represent and what units they are in. Variable names should be relatively brief: instead of `distanceToTravelInMeters`, try `travelDistanceMeters`.

### Some Emphasized Items

* No single-line if/else blocks. (eg: No: `if (true) { completeAction() }`)
* One statement per line. (eg: No: `first(); second();`)
* One variable per declaration (Multi-declarations mess up the Gradle LSP). (eg: No: `int a, b = 5;`)
* Separate reserved words and brackets (`()`) or curly brackets (`{}`) with a space. (eg: No: `else{...}`, Yes: `else {...}`)
* When necessary, use parentheses to group complex math expressions. Do not assume people know Java's precise order of operations.

## FRC-specific guidelines

Commands can be named after nouns or verbs, but should not be confusing. A command that handles intaking in auto, but is not used in teleop or elsewhere, should be either named `AutoIntake`, or placed under folder marked for auto.

## Code Review

Expect reviewers to comment on your code style and readability. They may request seemingly meaningless changes to variable names and file formatting. You should follow these requests in stride; keep in mind that reviewers are not critisizing your your programming skills. We just need all our code to **look the same**.

## Installing a Formatter

Don't worry, you won't have to style everything yourself. Formatters are scripts that automatically format your code to conform with the given guidelines. They can be installed in different layers of the development stack.

### VS Code

In order to automatically format a file, you can run `Format Document` in the command palette. The settings in `.vscode/settings.json` should match our specifications, but we can't guarantee this feature will cover everthing. Its primary use is in formatting code you copied from elsewhere, or large sections of code that looks *wonky*.

### Gradle

*TODO:* Steps will be added on how to attach the formatter to `build.gradle`. Essentially, the formatter will run whenever the robot code is built.

### GitHub Actions

*TODO:* The GitHub repository will have an action to automatically format all code that is pushed to main. This does not mean that formatting should be disregarded on the individual's side though.
