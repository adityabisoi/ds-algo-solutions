#include <iostream>
using namespace std;

int mod(int a);

int main()
{
	const int MAX_SIZE = 102;
	int rows, cols,price,i,j;
	int mat[MAX_SIZE][MAX_SIZE];

	cin >> rows >> cols;

	//we surround the matrix with 0s
	for (i = 0; i < rows + 2; i++)
	{
		mat[i][0] = 0;
		mat[i][cols+1] = 0;
	}
	for (i = 0; i < cols + 2; i++)
	{
		mat[0][i] = 0;
		mat[rows+1][i] = 0;
	}

	//We read the values
	for (i = 1; i <= rows; i++)
		for (j = 1; j <= cols; j++)
			cin >> mat[i][j];

	//We compute up and down views.
	price = (rows * cols)* 2;

	//We compute from left to right view and from behind to infront view
	for (int i = 0; i < rows+1; i++)
	{
		for (int j = 0; j < cols+1; j++)
		{
			price += mod(mat[i][j] - mat[i][j+1]);
			price += mod(mat[i][j] - mat[i+1][j]);
		}
	}

	cout << price << endl;

	return 0;
}

int mod(int a)
{
	if (a < 0)
		a = -a;
	return a;
}
