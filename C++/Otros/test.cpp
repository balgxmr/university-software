#include <iostream>

using namespace std;

int main()
{
    char nombre[50];
    int edad, mes;

    cout << "Ingresa tu nombre: ";
    // cin.ignore(); // Ignore any characters left in the input buffer (like the clear method on C, removes last letter or newline)
    cin.getline(nombre, 50); // Read the full line, including the spaces (similar to fgets on C)

    while (true)
    {
        cout << "Ingresa tu edad: ";
        cin >> edad;
        if (edad > 0 && edad < 150)
            break;

        cout << "Valor invalido!";
    }

    while (true)
    {
        cout << "Ingresa tu mes de nacimiento (en numero, 1-12): ";
        cin >> mes;

        if (mes > 0 && mes <= 12)
            break;

        cout << "Valor inválido!\n";
    }

    cout << "Tu nombre es: " << nombre << endl;
    cout << "Tienes: " << edad << " anios" << endl;
    cout << "Tu mes de nacimiento es: ";

    switch (mes)
    {
    case 1:
        cout << "Enero";
        break;

    case 2:
        cout << "Febrero";
        break;

    case 3:
        cout << "Marzo";
        break;

    case 4:
        cout << "Abril";
        break;

    case 5:
        cout << "Mayo";
        break;

    case 6:
        cout << "Junio";
        break;

    case 7:
        cout << "Julio";
        break;

    case 8:
        cout << "Agosto";
        break;

    case 9:
        cout << "Septiembre";
        break;

    case 10:
        cout << "Octubre";
        break;

    case 11:
        cout << "Noviembre";
        break;

    case 12:
        cout << "Diciembre";
        break;

    default:
        break;
    }

    return 0;
}