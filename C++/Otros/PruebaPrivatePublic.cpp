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

string capturarDatos(string msg){
    string dato;
    cout << "Introduce tu " << msg << ": ";
    getline(cin, dato);
    return dato;
}

int capturarDatos(int msg){
    int dato;

    if (msg == 1){
        cout << "Enter your age: ";
    } else if (msg == 2) {
        cout << "Enter your ID: ";
    }

    cin >> dato;
    return dato;
}

int main(){
    static int NUM_ESTUDIANTES = 100;
    vector<Students> studentsList;

    for(int i = 0; i < NUM_ESTUDIANTES; i++){
        Students student;

        cout << "STUDENT #" << i + 1 << endl;

        int newAge;
        student.age = (capturarDatos(1));

        string newName;
        student.name = capturarDatos("name");

        string newUsername;
        student.SetUsername(capturarDatos("username"));

        string newPassword;
        student.SetPassword(capturarDatos("password"));

        studentsList.push_back(student);
    }

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