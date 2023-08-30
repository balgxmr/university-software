#include <iostream>
#include <string>

using namespace std;

struct Estudiantes {
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
    cin >> dato;
    return dato;
}

int main(){
    Estudiantes estudiante1;

    string newPassword, newUsername;

    estudiante1.SetUsername(capturarDatos("username"));
    estudiante1.SetPassword(capturarDatos("password"));

    cout << "Username: " << estudiante1.GetUsername() << endl;
    cout << "Password: " << estudiante1.GetPassword() << endl;

    return 0;
}