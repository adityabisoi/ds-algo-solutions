# Defining the function to check for equal brackets
def brackets(expression):
    all_brackets = ['()', '{}', '[]']
    while any(x in expression for x in all_brackets):
        for br in all_brackets:
            expression = expression.replace(br, '')
    return not expression

# Driver code
input_string = input("Enter the brackets : ")
if brackets(input_string):
    print(input_string,"Brackets are balanced.")
else:
    print(input_string,"Brackets are not balanced.")
    
# Output
# Enter the brackets : ({{[]})
# Brackets are not balanced.
