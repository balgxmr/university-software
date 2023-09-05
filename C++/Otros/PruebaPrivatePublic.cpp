#include <iostream>
#include <string>
#include <vector>

using namespace std;

struct Students {
    private:
        string username;
        string password;
        
    public:
        int age;
        string name;
        string phoneNumber;

        void SetPassword(string newPassword){
            this->password = newPassword;
        }

        void SetUsername(string newUsername){
            this->username = newUsername;
        }

        string GetUsername(){
            return this->username;
        }

        string GetPassword(){
            return this->password;
        }
};

int main(){
    static int NUM_ESTUDIANTES = 2;
    vector<Students> studentsList;

    for(int i = 0; i < NUM_ESTUDIANTES; i++){
        Students student;

        cout << "STUDENT #" << i + 1 << endl;

        int newAge;
        cout << "Enter your age: ";
        cin >> newAge;
        cin.ignore();  // Limpia el carácter de nueva línea del búfer

        student.age = newAge;

        string newName;
        cout << "Enter your name: ";
        cin.ignore();
        getline(cin, newName);
        student.name = newName;

        string newUsername;
        cout << "Enter your username: ";
        getline(cin, newUsername);
        student.SetUsername(newUsername);

        string newPassword;
        cout << "Enter your password: ";
        getline(cin, newPassword);
        student.SetPassword(newPassword);

        string newPhoneNumber;
        cout << "Enter your phone number: ";
        getline(cin, newPhoneNumber);
        student.phoneNumber = newPhoneNumber;

        studentsList.push_back(student);
    }

    cout << "--------------------------\n";
    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
        cout << "Student " << i + 1 << ":\n";
        cout << "Username: " << studentsList[i].GetUsername() << endl;
        cout << "Password: " << studentsList[i].GetPassword() << endl;
        cout << "Age: " << studentsList[i].age << endl;
        cout << "Name: " << studentsList[i].name << endl;
        cout << "Phone Number: " << studentsList[i].phoneNumber << endl;
        cout << "--------------------------\n";
    }

    return 0;
}