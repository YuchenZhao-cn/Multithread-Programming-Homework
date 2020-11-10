#include <iostream>
#include <malloc.h>
using namespace std;

int main()
{
    int nrows = 5; 
	int ncols = 10; 
	int row; 
	char a[4] = {'a', 'b', 'c', 'd'};
	char* ptr = a;
	
	int **rowptr;
	for (row = 0; row < nrows; row++) 
	{ 
		rowptr = (int**)malloc(ncols * sizeof(int)); 
		if (rowptr[row] == NULL) { 
			cout << "Failure to allocate for row[" << row << "]" << endl; 
			exit(0); 
		} 
		for (int i = 0; i < ncols; i++){
			rowptr[row][i] = i;
			cout << rowptr[row][i] << " ";
		}
		cout << endl;
    return 0;
	}
}
