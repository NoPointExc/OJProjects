#!user/bin/ruby
require 'fileutils'
# mkdir $FILE_NAME
# cp ./zyg/* ./$FILE_NAME
# cd ./$FILE_NAME
# echo "DOWNLOAD INPUT FILES BY HANDS, good luch"

fileName=ARGV[0] 
FileUtils.mkdir_p fileName
