#include "Q5.h"
#include <thread>
#include <string>
#include <iostream>
#include <stdlib.h>
#include <vector>
#include <map>
#include <cstdlib>
#include <mutex>
#include <windows.h>
#include <ctime>

using namespace std;

static int nextID;
map<int, string> finalGrade;
mutex gmutex;

class student {
private:
    string name[32] = { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","AA","AB","AC","AD","AE","AF" };
public:
    string Name;
    int ID, Midterm, Project, Final;
    string Grade;

public:
    student() {
        nextID++;
        ID = nextID;
        Name = name[ID - 1];
        setGrade();
    }

public:
    void setGrade() {
        srand(ID);
        Midterm = (rand() % 51) + 50;
        Project = (rand() % 51) + 50;
        Final = (rand() % 51) + 50;
    }

    string getName() {
        return this->Name;
    }

    void setName(string Name) {
        this->Name = Name;
    }

    string getGrade() {
        return this->Grade;
    }

    void setGrade(string Grade) {
        this->Grade = Grade;
    }

    int getID() {
        return this->ID;
    }

    void setID() {
        this->ID = ID;
    }

    int getMidterm() {
        return this->Midterm;
    }

    void setMidterm() {
        this->Midterm = Midterm;
    }

    int getProject() {
        return this->Project;
    }

    void setProject() {
        this->Project = Project;
    }

    int getFinal() {
        return this->Final;
    }

    void setFinal() {
        this->Final = Final;
    }


};

vector<student> Students;

void grader() {
    for (int i = 0; i < 6; i++) {
        Sleep(4950);
        for (auto std : Students) {
            cout << "Name: " << std.getName() << " ID: " << std.getID() << " Midterm: " << std.getMidterm() << " Project: " << std.getProject() << " Final: " << std.getFinal() << " Grade: " << std.getGrade() << endl;
        }
    }
}

string calculateGrade(student std) {
    double score = 0.3 * std.getMidterm() + 0.3 * std.getProject() + 0.4 * std.getFinal();
    if (score >= 90) return "A";
    else if (score >= 80) return "B";
    else if (score >= 70) return "C";
    else if (score >= 60) return "D";
    else return "F";
}

void studentThread() {
    gmutex.lock();
    student std;
    cout << "Thread-" << GetCurrentThreadId() << " completed!" << endl;
    std.setGrade(calculateGrade(std));
    Students.push_back(std);
    Sleep(1000);
    gmutex.unlock();
}

//void GraderThread() {
//    grader gd;
//}

int main() {
    clock_t startTime, endTime;
    startTime = clock();

    thread* p[32];

    thread gt(grader);

    for (int i = 0; i < 32; i++) {
        p[i] = new thread(studentThread);
    }

    for (int i = 0; i < 32; i++) {
        p[i]->join();

    }
    gt.join();

    endTime = clock();
    cout << "Time: " << (double)(endTime - startTime) / CLOCKS_PER_SEC << "s" << endl;

    return 0;
}