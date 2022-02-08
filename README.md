# java-source-formatter-review

[![Java CI](https://github.com/jabrena/java-source-formatter-review/actions/workflows/build.yml/badge.svg)](https://github.com/jabrena/java-source-formatter-review/actions/workflows/build.yml)

Review of different maven plugins to format java source code

```
export MAVEN_OPTS=" --add-exports jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED \
--add-exports jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED \
--add-exports jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED \
--add-exports jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED \
--add-exports jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED "

mvn clean verify
```
