# Defining the function to check for equal brackets
def brackets(expression):
    # Type of brackets used in string
    all_brackets = ['()', '{}', '[]']
    # Evaluating the expression and checking for brackets present in the given string
    while any(x in expression for x in all_brackets):
        for br in all_brackets:
            expression = expression.replace(br, '')
    # Returning the output
    return not expression

# Driver code

# Taking input from the user
input_string = input("Enter the brackets : ")
# Checking brackets for balancing
if brackets(input_string):
    print(input_string,"Brackets are balanced.")
else:
    print(input_string,"Brackets are not balanced.")
    
# Input
# Enter the brackets : ({{[]})
# Output
# Brackets are not balanced.
