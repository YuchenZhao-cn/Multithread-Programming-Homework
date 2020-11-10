#include <iostream>
#include <string>
#include <sstream>
using namespace std;

struct movies_t {
  string title;
  int year;
};

struct friends_t {
    string name;
    string email;
    movies_t favorite_movie;
};

int main ()
{
	string mystr;
	
	friends_t afriend;
	friends_t* pfriend;
	pfriend = &afriend;
	
	movies_t amovie = pfriend->favorite_movie;
	movies_t* pmovie;
	pmovie = &amovie; 
	
	cout << "Enter name: ";
	getline (cin, pfriend->name);
	cout << "Enter email: ";
	getline (cin, pfriend->email);
	cout << "Enter movie's' title: ";
	getline (cin, pmovie->title);
	cout << "Enter movie's year: ";
	getline (cin, mystr);
	(stringstream) mystr >> pmovie->year;
	
	cout << "\nYou have entered:\n";
	cout << "name: " << pfriend->name << "\nemail: " << pfriend->email << "\nfavorite movie's title: " << pmovie->title << "\nfavorite movie's year: " << pmovie->year <<endl;

	return 0;
}
