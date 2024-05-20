import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import fsolve

def graficar_funcion():
    funcion = input("Ingrese la función (use x como variable): ")
    x_min = float(input("Ingrese el valor mínimo del intervalo: "))
    x_max = float(input("Ingrese el valor máximo del intervalo: "))
    
    def f(x):
        return eval(funcion)

    x = np.linspace(x_min, x_max, 400)
    y = f(x)
    
    # Calculando la raíz
    raiz = fsolve(f, x_min)[0]
    print(f"La raíz aproximada es: {raiz}")

    plt.figure(figsize=(8, 6))
    plt.plot(x, y)
    plt.axhline(0, color='black', lw=0.5)
    plt.axvline(raiz, color='red', linestyle='--', label='Raíz')
    plt.plot(raiz, f(raiz), 'ro')
    plt.title(f"Gráfica de la función: {funcion}")
    plt.xlabel("x")
    plt.ylabel("y")
    plt.grid(True)
    plt.legend()
    plt.show()

graficar_funcion()
