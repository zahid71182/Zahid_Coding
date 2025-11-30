#include <iostream>

using namespace std;

void MatrixAddition()
{
    int rows, cols;
    cout << "=== For Addition OR Subtraction of Matrices, both matrices must be of same order ===" << "\n";
    cout << "=== Define length of both Matrices ===" << "\n";
    cout << "Enter No. of rows: ";
    cin >> rows;
    cout << "Enter No. of cols: ";
    cin >> cols;

    int A[rows][cols];
    int B[rows][cols];
    int sum[rows][cols];

    cout << "Enter Elements of Matrix A: " << endl;
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            cout << "A[" << i << "][" << j << "] = ";
            cin >> A[i][j];
        }
    }

    cout << "Enter Elements of Matrix B: " << endl;
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            cout << "B[" << i << "][" << j << "] = ";
            cin >> B[i][j];
        }
    }

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            sum[i][j] = A[i][j] + B[i][j];
        }
    }

    cout << "\n=== Sum of Matrices (A + B) ===" << endl;
    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            cout << sum[i][j] << "\t";
        }
        cout << "\n";
    }
}

int main()
{
    MatrixAddition();
    cout << "Programme End Successfully" << endl;
    return 0;
}