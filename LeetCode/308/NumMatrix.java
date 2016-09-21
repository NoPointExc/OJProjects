public class NumMatrix {
    int[][] lSum;
    int[][] matrix;
    int wid = -1, len =-1;

    public NumMatrix(int[][] matrix) {
        wid = matrix.length;
        this.matrix = matrix;
        if(wid==0) 
            return;
        len = matrix[0].length;
        if(len ==0 )
            return;
        lSum = new int[wid][len];
        for(int i=0; i<wid; i++){
            for (int j=0; j<len ; j++ ) {
                lSum[i][j] = matrix[i][j];
                if(j>=1){
                    lSum[i][j] += lSum[i][j-1];
                }
            }
        }
    }

    public void update(int row, int col, int val) {
        if(wid ==0 || len ==0) 
            return;
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        
        for(int j=col;j<len;j++){
            lSum[row][j] += diff;
        }
            
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(wid ==0 || len ==0) 
            return 0;
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            int leftMost = col1-1>=0? lSum[i][col1-1]:0;
            sum += lSum[i][col2] - leftMost;
        }
        return sum;
    }

}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);