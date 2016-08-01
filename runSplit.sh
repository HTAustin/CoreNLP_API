#!/bin/bash
FILES=/Users/haotianzhang/Project/20ng
for f in $(find $FILES -type f)
do
  	# take action on each file. $f store current file name
  	java -cp .:* Document2Sentences $f /Users/haotianzhang/Project/stanford-corenlp-full-2015-12-09/output/
 	# echo $f
done