# Sample if statement
x = 0
y = 10

if(3 == x):
  if(10 == y):
    print('Correct numbers!')
elif(0 == x):
  print('X is not correct!')
else:
  print('Nah!')


# Sample try/except
astr = 'Hello Manu'
try:
  istr = int(astr)
except:
  istr = -1
print('First', istr)

astr = '123'
try:
  istr = int(astr)
except:
  istr = -1
print('Second', istr)


# Sample try/except using input
rawstr = input('Enter a number: ')
try:
  ival = int(rawstr)
except:
  ival = -1

if ival > 0:
  print('Nice work. Your number is:', ival)
else:
  print('Err: Not a number.')