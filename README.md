sql-beautifulier
================

A standalone SQL formatting tool that uses Hibernate's `BasicFormatterImpl` and `DDLFormatterImpl`.

Inspired by http://stackoverflow.com/questions/312552/looking-for-an-embeddable-sql-beautifier-or-reformatter

## How to use

1. clone this repo
1. `mvn clean package`
1. `cd target`
1. (For DMLs) `java -jar sql-beautifulier.jar ../src/test/resources/dml.sql`
1. (For DDLs) `java -jar sql-beautifulier.jar -d ../src/test/resources/ddl.sql`

## Notes

This command can consume STDIN instead of a file. If you omit filename from arguments, It starts reading SQL from STDIN instead.
