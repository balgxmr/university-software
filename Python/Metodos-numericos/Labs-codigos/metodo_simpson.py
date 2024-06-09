# Método de simpson

import math

def simpson_1_3(x, y):
    n = len(x)
    h = x[1] - x[0]  # Asumiendo que los puntos están igualmente espaciados
    area = 0
    for i in range(n):
        if i == 0 or i == n - 1:
            area += y[i]
        elif i % 2 != 0:
            area += 4 * y[i]
        else:
            area += 2 * y[i]
    area = area * h / 3
    return area

# Pedir al usuario que ingrese los puntos x
print("Ingrese los puntos x separados por coma:")
x_input = input().split(',')
x = [float(x) for x in x_input]

# Pedir al usuario que ingrese los puntos y
print("Ingrese los puntos y separados por coma:")
y_input = input().split(',')
y = [float(y) for y in y_input]

# Verificar que la cantidad de puntos x e y coincida
if len(x) != len(y):
    print("La cantidad de puntos x e y no coincide. Por favor, ingrese la misma cantidad de puntos para x e y.")
else:
    # Calcular la altura
    altura = max(y) - min(y)
    # Calcular el área bajo la curva utilizando el método de Simpson 1/3
    area = simpson_1_3(x, y)
    print("El área bajo la curva es:", area)
