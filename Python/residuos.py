import matplotlib.pyplot as plt

# Datos proporcionados
dias = ['Jueves', 'Viernes', 'Sábado']
pesos_totales = [2, 1.5, 1.7]  # Pesos totales en kg para cada día
personas = 4  # Cantidad de personas en casa

# Calcular el peso por persona por día
pesos_por_persona = [peso / personas for peso in pesos_totales]

# Crear la gráfica de barras
plt.bar(dias, pesos_por_persona, color=['blue', 'orange', 'green'])
plt.title('Generación de residuos por persona por día')
plt.xlabel('Días')
plt.ylabel('Kilogramos por persona')
plt.ylim(0, 1)

# Mostrar la gráfica
plt.show()
