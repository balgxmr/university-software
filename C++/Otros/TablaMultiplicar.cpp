#include <iostream>
#include <limits>

using namespace std;

void imprimirTabla (int num) {
    for(int i = 0; i <= 12; ++i){
        cout << num << " * " << i << " = " << num*i << endl;
    }
}

int main () {
    int numero;

    while(true){
        cout << "Introduce el numero: ";
        if (cin >> numero && numero >= 0) { // verificar que es un entero y mayor o igual a 0
            imprimirTabla(numero);

            char x;

            cout << "Desea mostrar la tabla de otro numero? (s/n): ";
            cin >> x;

            if (x == 'n' || x == 'N') {
                break;
            }

            // Limpiar pantalla
            system("cls");
        } else {
            // El input no fue un numero
            cout << "Entrada no válida. Por favor, ingrese un número." << endl;
            // Limpiar el búfer de entrada para evitar bucles infinitos
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
    }
}