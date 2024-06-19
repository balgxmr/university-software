def simpson_3_8(x, y):
    n = len(x) - 1
    h = (x[-1] - x[0]) / n
    area = y[0] + y[-1]
    
    sum_3 = 0
    sum_rest = 0
    
    for i in range(1, n):
        if i % 3 == 0:
            sum_3 += y[i]
        else:
            sum_rest += y[i]
    
    area += 3 * sum_rest + 2 * sum_3
    area *= 3 * h / 8
    
    return area

x = [2, 4, 6, 8, 10, 12, 14]
y = [6, 4, 2, 1, 2, 6, 14]

area = simpson_3_8(x, y)
print("El área bajo la curva es:", area)
