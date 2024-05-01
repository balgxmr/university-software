import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import root_scalar

def funcion(x):
  return np.sin(x)

def graficar_funcion(func):
  x = np.linspace(-5, 5, 100)
  y = func(x)
  plt.plot(x, y, label='Función')
  plt.grid(True)
  plt.axhline(0, color='black', lw=2.5)
  plt.axvline(0, color='black', lw=0.5)
  plt.legend()
  plt.scatter(0, 0, color="red", label="Punto")
  plt.xlabel('x')
  plt.ylabel('f(x)')
  plt.title('Gráfico de la función')
  plt.show()

def main():
  graficar_funcion(funcion)

if __name__ == "__main__":
  main()