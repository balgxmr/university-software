import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import root_scalar

def obtener_funcion():
    funcion_str = input("Ingrese la función (en términos de 'x'): ")
    try:
        funcion = eval("lambda x: " + funcion_str)
        return funcion
    except:
        print("Error: La función ingresada no es válida.")
        return None

# Valores-intervalos que utilizamos [(-5, -4), (-10, -5)]
def obtener_intervalos():
    intervalos_str = input("Ingrese los intervalos como una lista de tuplas, por ejemplo, [(-5, -4), (-3, -2), ...]: ")
    try:
        intervalos = eval(intervalos_str)
        return intervalos
    except:
        print("Error: Los intervalos ingresados no son válidos.")
        return None

def encontrar_raices(func, intervalos):
    raices = []
    for intervalo in intervalos:
        raiz = root_scalar(func, bracket=intervalo).root
        if raiz is not None:
            raices.append(raiz)
    return raices

def graficar_funcion(func):
    x = np.linspace(-10, 10, 1000)
    y = func(x)
    plt.plot(x, y, label='Función')
    plt.grid(True)
    plt.axhline(0, color='black', lw=2.5)
    plt.axvline(0, color='black', lw=0.5)
    plt.legend()
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.title('Gráfico de la función')
    plt.show()

def main():
    funcion = obtener_funcion()
    if funcion is None:
        return
    intervalos = obtener_intervalos()
    if intervalos is None:
        return
    graficar_funcion(funcion)

if __name__ == "__main__":
    main()
