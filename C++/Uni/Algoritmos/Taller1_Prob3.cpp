#include <iostream>
#include <cmath>

int main () {
    int cantDiscos = 0;

    std::cout << "Ingrese la cantidad de discos: ";
    std::cin >> cantDiscos;

    int cantMov = pow(2, cantDiscos) - 1;

    std::cout << cantMov;
}

/*
entero cantidadDiscos; 
imprimir "Ingrese la cantidad de discos";
leer cantidadDiscos;
entero cantidadMovimientos = 2^cantidadDiscos - 1;
imprimir cantidadMovimientos;
*/