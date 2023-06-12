print("Hello!")

# Ask user fundamental info
name = input("Write your name: ")
age = input("Write your age: ")
birthday = input("Write your birthday date (DD-MM-YY): ")

# Print info
print("Your name is: " + name + "\nY'old: "  + age + "\nBirthday: " + birthday)

# Juices prices
juice = [1.99, # orange
         1.50, # apple
         1.00] # pear

# Random program
election = input("""What type of juice do you want?
    There are:
    1. Orange
    2. Apple
    3. Pear
    > """)

# to upper case
election = election.upper()
print(election)

if election == '1' or election == "ORANGE":
    print("Orange juice is $1.99")
    amount = input("How much juices do you want: ")
    x = 0
elif election == '2' or election == "APPLE":
    print("Apple juice is $1.50")
    amount = input("How much juices do you want: ")
    x = 1
elif election == '3' or election == "PEAR":
    print("Pear juice is $1.00")
    amount = input("How much juices do you want: ")
    x = 2
else:
    print("Option not available, aborting...")
    exit()

# convert to int because input is taken in str
total = int(amount) * juice[x]

# convert to str again because print concatenates str
# and not int
print("Your total is: $" + str(total))
print("Thanks for coming, have a great day!")