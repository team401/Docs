---
title: Coding Standards
parent: Programming
has_children: false
layout: home
---

# Team 401 Code Standards

By default, we will follow the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html). Any deviations or additions will be detailed here, but follow this document when in doubt.

**Right now, this document is incomplete and unconfirmed. Its word is not law.**

## Spacing

We indent 4 spaces. End of sentence.

## Variable Naming

We do not use Hungarian prefixes (eg: `m_RobotContainer`). If you copy code from WPI's examples, rename the variables.


## Other Emphasized Items

* No single-line if/else blocks.
* One statement per line.
* One variable per declaration (Multi-declarations mess up the Gradle LSP).
* Separate reserved words and brackets (`()`) or curly brackets (`{}`) with a space.
* When necessary, use parentheses to group complex math expressions. Do not assume people know Java's precise order of operations.

## Formatting in VS Code

In order to automatically format a file, run `Format Document` in the command palette. The settings in `.vscode/settings.json` should match our specifications, but we can't guarantee this feature will cover everthing. Its primary use is in formatting code you copied from elsewhere, or if you made a series of mistakes.

## Formatting with Gradle

*TODO*

## Code Review

Expect reviewers to comment on your code style and readability. They may request seemingly meaningless changes to variable names and file formatting. You should follow these requests in stride; keep in mind that reviewers are not critisizing your intelligence, or the structure of your code. We just need all our code to **look the same**.