require "pp"
# @param {Character[][]} board
# @return {Void} Do not return anything, modify board in-place instead.
def solve(board)
	if board==nil || board.length<=1 || board[0].length<=1
		return
	end

	stack=[]
	#scan out reange
	x=board.length
	y=board[0].length
	
	for i in 0...x
		for j in [0,y-1]
			loc=[i,j]
			if isO(board,loc)
				#board[i][j]='X'
				stack.push loc
			end
		end
	end
	
	for j in 1...y-1
		for i in [0,x-1]
			loc=[i,j]
			if isO(board,loc)
				#board[i][j]='X'
				stack.push loc
			end
		end 	
	end
	#pp stack	
	while !stack.empty? do
		nxt=stack.pop
		toCheck=[ [nxt[0]-1,nxt[1]] , [nxt[0]+1,nxt[1]], [nxt[0],nxt[1]-1] , [nxt[0],nxt[1]+1] ]
		
		for loc in toCheck
			if isO(board, loc)
				#board[loc[0],loc[1]]='X'
				stack.push loc
			end
		end

	end
	
	for i in 0...x
		for j in 0...y
			if board[i][j]=='V'
				board[i][j]='O'
			elsif board[i][j]=='O'
				board[i][j]='X'
			end
		end
	end    
end

#board=[[]]
#loc=[]
# return board@loc == 'O'
def isO(board,loc)
	#pp loc
	
	if loc[0]<0 || loc[0]>=board.length || loc[1]<0 || loc[1]>=board[0].length
		#puts "loc out range"	
		return false
	end
	#print "board[i,j]=#{board[0,1]}\n"	
	if board[loc[0]][loc[1]] == 'O'
		board[loc[0]][loc[1]]='V'
		return true
	end
	return false 		
end

board=[['X','X','O','O'],['X','X','O','O'],['X','O','X','X'],['X','X','X','X']]
#board=[[]]
pp board
solve board
puts "======solve===="
pp board
