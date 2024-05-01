import sympy as sp
from tabulate import tabulate

# Ejemplo de uso
def funcion(x):
  return 2*x**3+x-2

def derivada_funcion(x):
  return 6*x**2+1

def newton_raphson(func, func_derivada, x0, tolerancia=1e-6, max_iter=100):
  
  iteracion = 0
  xn = x0
  tabla = []

  while iteracion < max_iter:
    fxn = func(xn)
    fdxn = func_derivada(xn)
    if abs(fxn / fdxn) < tolerancia:
      return xn, tabla
    tabla.append([iteracion, xn, fxn, fdxn, fxn / fdxn])
    
    xn = xn - fxn / fdxn
    iteracion += 1

  print("El método de Newton-Raphson no convergió después de: ", max_iter, " iteraciones.")
  return None, tabla

x0 = 1
raiz, tabla = newton_raphson(funcion, derivada_funcion, x0)
if raiz is not None:
  print("La raíz encontrada es: ", raiz)
  print(tabulate(tabla, headers=["iteracion", "xn", "f(xn)", "f(xn)/f'(xn)"], tablefmt="grid"))