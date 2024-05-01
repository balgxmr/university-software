import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import root_scalar

def funcion (x):
    return x**10-1

def graficar_funcion(func):
    x_vals = np.linspace(a, b, 100)
    y_vals = funcion(x_vals)

    plt.figure(figsize=(8, 6))
    plt.plot(x_vals, y_vals, label='Función')
    plt.grid(True)
    plt.axhline(0, color='black', lw=2.5)
    plt.axvline(0, color='black', lw=0.5)
    plt.legend()
    plt.scatter(raiz, 0, color="red", label="Punto")
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.title('Gráfico de la función')
    plt.show()


def biseccion(funcion,a,b,tolerancia=1e-8, max_iter=100):
    if funcion(a) * funcion(b)>=0:
        print("la funcion no cumple")
        return None 
    print ("{:^10} | {:^10} | {:^10} | {:^10} | {:^10} | {:^10} | {:^15} ".format ("interacion", "a", "b","Xr", "f(Xa)", "f(Xr)", "aprox.Rel"))
    print("-"*90)

    iteracion = 0
    Xr_anterior = 0 
    aprox_rel = 1
    while aprox_rel > tolerancia and iteracion < max_iter:
        Xr = (a+b) / 2 
        f_a = funcion(a)
        f_Xr = funcion(Xr)
        aprox_rel = abs ((Xr - Xr_anterior)/Xr)

        print("{:^10} | {:^10.6f} | {:^10.6f} | {:^10.6} | {:^10.6f} | {:^10.6f} | {:^10.6f} ".format(iteracion, a, b, Xr, f_a, f_Xr, aprox_rel))
        
        if f_Xr == 0:
            return Xr #Encontramos la raiz exacta 
        elif f_Xr * f_a < 0:
            b = Xr
        else:
            a = Xr
        
        Xr_anterior = Xr #Actualiza Xr_anterior 
        iteracion += 1
    print("-" * 90)
    return (a + b)/2
    
#intervalo inicial 
a = 0
b = 1.4
raiz= biseccion(funcion,a,b)
if raiz is not None:
    print("\nAproximacion de la raiz", raiz)
else: 
    print("No se pudo encontrar la raiz con el metodo de bisección")

graficar_funcion(funcion)