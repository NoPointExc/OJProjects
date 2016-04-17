#bash!/bin/bash
FILE_NAME=$1
# if [ -d "&FILE_NAME" ]; then
	
# 	echo 'File &FILE_NAME already exist:'
# 	exit 0
	# options=("Y" "N")
	# select opt in "${options[@]}" 
	# do 
	# 	case $opt in
	# 		Y ) 
	# 			rm -rf &FILE_NAME
	# 			;;
		
	# 		*) 
	# 			exit 0
	# 			;;
	# 	esac
# fi
mkdir $FILE_NAME
cp ~/OJProjects/codeJam/zyg/* ~/OJProjects/codeJam/$FILE_NAME
echo "DOWNLOAD INPUT FILES BY HANDS, good luch"