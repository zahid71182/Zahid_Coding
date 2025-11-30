import java.util.Scanner;

public class MatrixSum {

    static void MatSum() {
        System.out.println("==For addition/subtraction of 2 matrices, both matrices must be of same order==");
        Scanner Sc = new Scanner(System.in);

        int rows, col;
        System.out.print("Enter number of rows of Matrices: ");
        rows = Sc.nextInt();
        System.out.print("Enter number of columns of Matrices: ");
        col = Sc.nextInt();

        int[][] Mat1 = new int[rows][col];
        int[][] Mat2 = new int[rows][col];
        int[][] ResultantMat = new int[rows][col];

        // Input Matrix A
        System.out.println("\nEnter elements for Matrix A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("A[" + i + "][" + j + "] = ");
                Mat1[i][j] = Sc.nextInt();
            }
        }

        // Input Matrix B
        System.out.println("\nEnter elements for Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("B[" + i + "][" + j + "] = ");
                Mat2[i][j] = Sc.nextInt();
            }
        }

        // Add matrices
        System.out.println("\nResultant Matrix (A + B):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                ResultantMat[i][j] = Mat1[i][j] + Mat2[i][j];
                System.out.print(ResultantMat[i][j] + "\t");
            }
            System.out.println();
        }
        Sc.close();
    }

    public static void main(String[] args) {
        MatSum();
    }
}