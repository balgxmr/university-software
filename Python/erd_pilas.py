# Haga un programa que permita ingresar hasta 20 elementos
# en una pila, y que despues, esta vaya sumando todos los
# elementos hasta que no quede ningun elemento en la pila.

pila = [] # Create an empty list to store the values

for i in range(20):
    temp = int(input("Ingrese el elemento {}: ".format(i + 1)))
    pila.append(temp)  # Add the grade to the list
    print(pila)

x = len(pila) - 1 # total of elements in the array 
                  # (minus 1, arrays start from 0)
sum_total = 0

while x > 0:
    cima = pila[x]
    suma = pila[x-1] + cima
    pila[x-1] = suma
    sum_total = suma
    pila.pop() # clears the last element of the array
    x -= 1

# clears the last element in the array due to while not being able to
pila.pop()
# i can use pila.clear() too, to remove all the elements of the array
# instead of removing one by one in the while using .pop(), but the way 
# of "stack" gets lost (not really, but well, according to our class)

print("Arr: " + str(pila))
print("Total: " + str(sum_total))