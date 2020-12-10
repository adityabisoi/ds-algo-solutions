def round_off(ls2):  # Function for the algorithm to obtain the desired output
    final_grade = []
    for value in ls2:  # iterating in the list to read every student's marks
        reminder = value % 5  # calculating remainder
        if value < 38:
            final_grade.append(value)
        elif reminder >= 3:  # If remainder is greater than equal to 3 it will get round off
            # like 73 has remainder 3 hence it will get rounded off to 75
            value += 5-reminder # the desired value will be get Ex 73 remainder 3 value = 73+(5-3)=75
            final_grade.append(value)
        else:
            final_grade.append(value)  # Grade that are not likely to round off will be stored as it is
    return final_grade  # returns a list of the final upgrade grade


while True:
    # A while loop to for a valid
    # input from a user
    number_students = int(input("Enter number of students(1 to 60): "))
    if number_students > 60 or number_students < 1:
        print("Please Enter number (1 to 60) ")
    else:
        break
ls = []  # empty list to store marks
while number_students > 0:
    # Taking input n times form
    # the user where n is number
    # of students
    number = int(input("Enter marks (0 to 100): "))
    if number > 100 or number < 0:  # if a number is out of range
        print("Please enter marks (0 to 100)")
        continue
    ls.append(number)  # storing the marks in empty list
    number_students -= 1
grades = round_off(ls)  # Calling the function
for mark in grades:  # with for loop printing marks of each student
    print(mark)
