package leetCode_70;

/**
 * 利用矩阵快速幂算法来解决问题(时间复杂度: logn)
 * @author dimdark
 * @date 2017-08-23
 * @time 11:03 AM
 */
public class SolutionThree {

    class Matrix {
        int[][] m;
        int col;
        int row;
        Matrix(){
            m = new int[2][2];
            col = row = 2;
        }
        Matrix(int a, int b, int c, int d) {
            m = new int[2][2];
            col = row = 2;
            m[0][0] = a; m[0][1] = b;
            m[1][0] = c; m[1][1] = d;
        }
        Matrix unit() {
            return new Matrix(1, 0, 0, 1);
        }
        Matrix pow(Matrix base, int n) {
            Matrix rst = unit();
            while(n != 0) {
                if((n&1) == 1)  rst = multiple(rst, base);
                base = multiple(base, base);
                n >>= 1;
            }
            return rst;
        }
        Matrix multiple(Matrix x, Matrix y) {
            Matrix rst = new Matrix();
            rst.row = x.row;
            rst.col = y.col;
            for(int i = 0; i < x.row; ++i) {
                for(int j = 0; j < y.col; ++j) {
                    for(int k = 0; k < x.row; ++k) {
                        rst.m[i][j] += x.m[i][k] * y.m[k][j];
                    }
                }
            }
            return rst;
        }
    }

    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;
        Matrix target = new Matrix(1, 1, 1, 0);
        target = target.pow(target, n-1);
        return target.m[0][0] + target.m[0][1];
    }

}
