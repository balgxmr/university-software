import numpy as np
import sympy as sp
import matplotlib.pyplot as plt

def graficar_funcion():

  # Graficar la funciones y los valores de xn ded cada iteracion
  x_vals= np.linspace(0,1.1,100)
  y_vals= funcion(x_vals)
  plt.figure(figsize=(10, 10))
  plt.plot(x_vals, y_vals, label='Función')
  
  plt.axhline(0, color="black", lw=2.5)
  plt.axhline(0, color="black", lw=0.5)
  for xn in valores_xn:
      plt.plot([xn, xn], [0, funcion(xn)], color='red', linestyle='--', linewidth=1) # Linea vertical 
      plt.plot([0, xn], [funcion(xn), funcion(xn)], color='green', linestyle='--', linewidth=1) # Linea horizontal
  

  for xn in valores_xn:
      # Calcullar la pendiente de la tangente en xn
      m= derivada_funcion(xn)
      # Calcular la ordenada al origen de la tangente
      b= funcion(xn)-m * xn
      # Definir los putnos para la linea tangente
      x_tangente= np.linspace(xn-0.5,xn+ 0.5, 100)
      y_tangente= m* x_tangente +b
      plt.plot(x_tangente, y_tangente, color='green', linewidth=1)
  
  plt.scatter(valores_xn, funcion(np.array(valores_xn)), color='blue', label='puntos xn', zorder=5)
  plt.scatter(raiz,0, color='red', label=f'Raiz: {raiz}', zorder=6)
  plt.xlabel('x')
  plt.ylabel('f(x)')
  plt.title('Grafica de la funcion y puntos xn de cada iteración')
  plt.legend()
  plt.grid(True)
  plt.show()




def newton_raphson(func, func_derivada, x0, tolerancia=1e-6, max_iter=100):

      iteracion =0 
      xn=x0
      tabla =[]
      valores_xn= []

      while iteracion < max_iter:
        fxn = func(xn)
        fdxn = func_derivada(xn)
        valores_xn.append(xn)

        if abs(fxn /fdxn) < tolerancia:
            return xn, tabla, valores_xn
        tabla.append([iteracion, xn, fxn, fdxn, fxn/ fdxn])

        xn= xn- fxn / fdxn
        iteracion += 1

      print("El metodo de Newton-Raphson convergió después de", max_iter, "iteraciones.")
      return None, tabla, valores_xn

# Ejemplo de uso
def funcion(x):
  return 2*x**3+x-2

def derivada_funcion(x):
  return 6*x**2+1

# Rango de valores para graficar la funcion
x_range= np.linspace(0,3,400)
y_range= funcion(x_range)

# Valores iniciales y ejecucion del metodo de newton-raphson
x0= 1
raiz, tabla, valores_xn= newton_raphson(funcion, derivada_funcion, x0)


print("La raiz encontrada es:", raiz)
print(tabulate(tabla, headers=["iteración","xn","f(xn)","f'(xn)","f(xn)/f'(xn)"], tablefmt="grid"))
graficar_funcion()