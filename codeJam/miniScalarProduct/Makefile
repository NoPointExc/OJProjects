#get a list of all input files 
IN:= $(shell find . -name '.out')


.PHONY: all
all:
	-@javac *.java

.PHONY: clean test

clean: 
	-@rm *.out
	-@rm *.class

run: 
	-@java Solution

