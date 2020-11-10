#include <iostream>
using namespace std;

int main() {
	int myInt1 = 5;
	int myInt2 = 10;
	int* myPointer1 = &myInt1;
	int* myPointer2 = &myInt2;
	int myInt3;
	cout << "-----Origin-----" << endl;
	cout << "myInt1: " << myInt1 << "\nmyInt2: " << myInt2 << endl;
	myInt3 = *myPointer1;
	*myPointer1 = *myPointer2;
	*myPointer2 = myInt3;
	cout << "-----After-----" << endl;
	cout << "myInt1: " << myInt1 << "\nmyInt2: " << myInt2 << endl;

	cout << "----------" << endl;
	cout << "-----Origin-----" << endl;
	cout << "myInt1: " << myInt1 << "\nmyInt2: " << myInt2 << endl;
	int& a = myInt1;
	int& b = myInt2;
	myInt3 = a;
	a = b;
	b = myInt3;
	cout << "-----After-----" << endl;
	cout << "myInt1: " << myInt1 << "\nmyInt2: " << myInt2 << endl;

}

