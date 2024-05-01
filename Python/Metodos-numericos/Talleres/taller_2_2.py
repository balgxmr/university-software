import numpy as np
import matplotlib.pyplot as plt
from scipy.optimize import root_scalar

def biseccion(funcion,a,b,tole, max_iter=100):
    if funcion(a) * funcion(b)>=0:
        print("La funcion no cumple") # Cuando dentro del intervalo no se encuentra la raiz o no tiene raiz 
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


def obtener_funcion(): # para obtener la funcion del usuario 
  funcion_str = input("Ingrese la función (Ej: en términos de 'x**10-1'): ")
  try:
      funcion = eval("lambda x: " + funcion_str)
      return funcion
  except:
      print("Error: La función ingresada no es válida.")
      return None


def obtener_intervalos():
    # para obtener los intervalos del usuario 
    try:
        x = float(input("Ingrese x: "))
        y = float(input("Ingrese y: "))
        intervalo = (x, y)
        return intervalo
    except ValueError:
        print("Error: El intervalo ingresado no es válido.")
        return None

def obtener_tolerancia():
  #En esta función se obtiene la tolerancia
    try:
        tolerancia = input("ingrese la tolerancia en formato de 1e-XX (X es el numero a ingresar)")
        return tolerancia
    except:
        print("La tolerancia no cumple con el formato")
        return None

#Tolerancia

 

#obtener la funcion de los usuarios 
funcion=obtener_funcion()

#intervalo inicial 
a,b = obtener_intervalos()
#Obtener tolerancia
tole = obtener_tolerancia()

raiz= biseccion(funcion,a,b)
if raiz is not None:
    print("\nAproximacion de la raiz", raiz)
else: 
    print("No se pudo encontrar la raiz con el metodo de bisección")

def graficar_funcion(func):
  x = np.linspace(a, b, 100)
  y = func(x)
  plt.plot(x, y, label='Función')
  plt.grid(True)
  plt.axhline(0, color='black', lw=3.5)
  plt.axvline(0, color='black', lw=1.5) #lw es el grosor
  plt.legend()
  plt.xlabel('x')
  plt.ylabel('f(x)')
  plt.title('Graficaaaa ')
  plt.show()

def main():
  graficar_funcion(funcion)

if __name__ == "__main__":
  main()