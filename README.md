[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sftwnd_crayfish_common_textual&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sftwnd_crayfish_common_textual) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=sftwnd_crayfish_common_textual&metric=coverage)](https://sonarcloud.io/summary/new_code?id=sftwnd_crayfish_common_textual) [![TravisCI-build](https://app.travis-ci.com/sftwnd/crayfish-common-textual.svg?branch=master)](https://app.travis-ci.com/github/sftwnd/crayfish-common-textual/logscans) [![License](https://img.shields.io/github/license/sftwnd/crayfish-common-textual)](https://github.com/sftwnd/crayfish-common-textual/blob/master/LICENSE)
# Crayfish Common Textual

Utilities to simplify work with Textual information

## Camel Case

### camelCase

Convert text string to camel case

```java
assertEquals("LetterIsSoBigLetter", CamelCase.lowerCamelCase(" letter isSo Big letter  "));
```

### lowerCamelCase

First symbol of CamelCase text will be changed to lowercase

```java
assertEquals("someText", CamelCase.lowerCamelCase("SomeText"));
```

or for supplier:

```java
assertEquals("illegalArgumentException", CamelCase.lowerCamelCase(IllegalArgumentException.class::getSimpleName));
```

### upperCamelCase

First symbol of CamelCase text will be changed to uppercase

```java
assertEquals("SomeText", CamelCase.upperCamelCase("someText"));
```
or for supplier:

```java
assertEquals("SomethingWrong", CamelCase.upperCamelCase(() -> "somethingWrong"));
```

---
Copyright © 2017-2024 Andrey D. Shindarev. All rights reserved.
