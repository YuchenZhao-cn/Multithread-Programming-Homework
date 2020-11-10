#include <iostream>
using namespace std;

int main()
{
	int x = 5;
	int* ptr1 = &x;
	cout << "x: " << x << "\n&x: " << &x << "\nptr1: " << ptr1 << "\n*ptr1: " << *ptr1 << endl;
	int* ptr2 = ptr1;
	cout << "----------" << endl;
	cout << "x: " << x << "\n&x: " << &x << "\nptr1: " << ptr1 << "\n*ptr1: " << *ptr1 << "\nptr2: " << ptr2 << "\n*ptr2: " << *ptr2 << endl;
	*ptr1 = 9;
	cout << "----------" << endl;
	cout << "x: " << x << "\n&x: " << &x << "\nptr1: " << ptr1 << "\n*ptr1: " << *ptr1 << "\nptr2: " << ptr2 << "\n*ptr2: " << *ptr2 << endl;
	*ptr2 = 15;
	cout << "----------" << endl;
	cout << "x: " << x << "\n&x: " << &x << "\nptr1: " << ptr1 << "\n*ptr1: " << *ptr1 << "\nptr2: " << ptr2 << "\n*ptr2: " << *ptr2 << endl;
	int arr[4] = { 4, 12, 8, 6 };
	ptr1 = arr;
	cout << "----------" << endl;
	for (int i = 0; i < 4; i++) {
		cout << "---" << i << "---" << endl;
		cout << "ptr1: " << ptr1 << "\n*ptr1: " << *ptr1 << "\n&arr: " << &arr << "\narr[" << i << "]: " << arr[i] << "\nptr2: " << ptr2 << "\n*ptr2: " << *ptr2 << endl;
		ptr1++;
	}
	return 0;
}
