# @param {Character[][]} board
# @return {Void} Do not return anything, modify board in-place instead.
def solve(board)
	#visit the out-range
	x=board.length
	if x<=1
		return
	end
	y=board[0].length
	if y<=1
		return
	end
	for i in 0...x
		visit board, i , 0
		visit board, i, y-1
	end
	for i in 1...y
		visit board , 0 , i
		visit board, x-1, i
	end
	
	for i in 0 ...x
		for j in 0...y
			if board[i][j]=='V'
				board[i][j]='X'
			end
		end
	end
end

def visit (board,i,j)
	x=board.length
	y=board[0].length
	if i<x && i>=0 && j>=0 && j<y && board[i][j]=='O'
		board[i][j]='V'
		visit board, i-1, j
		visit board, i+1, j
		visit board, i, j-1
		visit board, i, j+1	
	end
end


#------test------

def printAll board
	for lin in board
		for chr in lin
			print "#{chr}, "
		end
		puts "\n"
	end
end

#board=[['X','X','X','O'],['X','X','O','O'],['X','O','X','X'],['X','X','X','X']]
board=[[]]
solve board
#visit board, 3 , 0
printAll board

