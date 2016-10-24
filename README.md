sql-beautifier
================

A standalone SQL/JSON formatting tool that uses Hibernate's `BasicFormatterImpl`, `DDLFormatterImpl` and GSON for JSON.

Inspired by http://stackoverflow.com/questions/312552/looking-for-an-embeddable-sql-beautifier-or-reformatter

## How to use

1. clone this repo
1. `mvn clean package`
1. `cd target`
1. (For DMLs) `java -jar sql-beautifier.jar ../src/test/resources/dml.sql`
1. (For DDLs) `java -jar sql-beautifier.jar -d ../src/test/resources/ddl.sql`
1. (For JSONs) `java -jar sql-beautifier.jar -j ../src/test/resources/sample.json`

## Notes

This command can consume STDIN instead of a file. If you omit filename from arguments, It starts reading input from STDIN instead.

## jEdit notes

There are jEdit macros (*.bsh in this repo) that would be very useful.
