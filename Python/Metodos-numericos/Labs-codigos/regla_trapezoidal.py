# Regla trapezoidal

def trapezoid_area(x, y):
    """
    Calcula el área bajo la curva utilizando la regla del trapecio múltiple.
    Args:
        x (list): Lista de valores de x.
        y (list): Lista de valores de y correspondientes a los valores de x.
    Returns:
        float: Área bajo la curva.
    """
    n = len(x)
    area = 0.0
    for i in range(n - 1):
        x1 = x[i]
        x2 = x[i + 1]
        y1 = y[i]
        y2 = y[i + 1]
        height = abs(x2 - x1)
        trapezoid_area = (y1 + y2) * height / 2
        area += trapezoid_area
    return area

# Solicitar al usuario que ingrese los puntos x e y
x_values = []
y_values = []
print("Ingrese los puntos x e y (ingrese 'q' para salir):")
while True:
    x_input = input("x: ")
    if x_input.lower() == 'q':
        break
    y_input = input("y: ")
    if y_input.lower() == 'q':
        break
    try:
        x_value = float(x_input)
        y_value = float(y_input)
        x_values.append(x_value)
        y_values.append(y_value)
    except ValueError:
        print("Entrada inválida. Inténtalo de nuevo.")

# Calcular el área bajo la curva
area = trapezoid_area(x_values, y_values)
print(f"El área bajo la curva es: {area}")