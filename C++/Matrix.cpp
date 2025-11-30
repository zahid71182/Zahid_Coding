#include <iostream>

using namespace std;

void matrix(void)
{
    int rows, cols, rows1, cols1;

    cout << "=== For First Matrix ===" << "\n";

    cout << "Enter No. of rows: ";
    cin >> rows;
    cout << "Enter No. of col: ";
    cin >> cols;

    int A[rows][cols];
    int sum[rows][cols];

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            cin >> A[i][j];
        }
    }

    cout << "=== For Second Matrix ===" << "\n";

    cout << "Enter No. of rows: ";
    cin >> rows1;
    cout << "Enter No. of col: ";
    cin >> cols1;

    int B[rows1][cols1];

    for (int k = 0; k < rows1; k++)
    {
        for (int l = 0; l < cols1; l++)
        {
            cin >> B[k][l];
        }
    }
    char choice;
    cin >> choice;
    if (choice == '+')
    {
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                sum[i][j] = A[i][j] + B[i][j];
            }
        }
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    cout << sum[i][j] << " ";
                }
            }
        }
    }
    int main()
    {
        matrix();
        cout << "End" << endl;
        return 0;
    }