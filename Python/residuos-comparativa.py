import matplotlib.pyplot as plt

# Datos proporcionados por ti
dias = ['Jueves', 'Viernes', 'Sábado']
pesos_totales = [2, 1.5, 1.7]  # Pesos totales en kg para cada día
personas = 4  # Cantidad de personas en casa
pesos_por_persona = [peso / personas for peso in pesos_totales]  # Residuos por persona por día

# Datos del escenario medio (kg/hab*d) de la tabla proporcionada
escenario_medio = [1.37, 1.39, 1.41]  # Valores del escenario medio para los tres días

# Crear la gráfica
plt.bar(dias, pesos_por_persona, color='blue', label='Generación de residuos en mi hogar')  # Datos tuyos
plt.plot(dias, escenario_medio, color='green', marker='o', label='Escenario Medio (realista)')  # Escenario medio

# Añadir títulos y etiquetas
plt.title('Comparativa de generación de residuos por persona en el hogar con los escenarios')
plt.xlabel('Días')
plt.ylabel('Residuos (kg/persona/día)')
plt.ylim(0, 1.7)

# Mostrar leyenda
plt.legend()

# Mostrar la gráfica
plt.show()
