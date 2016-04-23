#bash!/bin/bash
DIR_NAME=$1

# mkdir $FILE_NAME
# cp ./zyg/* ./$FILE_NAME
# cd ./$FILE_NAME
# echo "DOWNLOAD INPUT FILES BY HANDS, good luch"

if [ ! -d $DIR_NAME ]; then
    mkdir $DIR_NAME
fi
cp ./zyg/* ./$DIR_NAME
cd ./$DIR_NAME
echo "DOWNLOAD INPUT FILES BY HANDS, good luch"

