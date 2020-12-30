#input the year
y = int(input())
if y < 1918:
    ftext = "13.09.{}" if y & 3 else "12.09.{}"
elif y > 1918:
    ftext = "13.09.{}" if (y & 3) or (y % 400 and not y % 100) else "12.09.{}"
else:
    ftext = "26.09.{}"
# Print the full date of Day of the Programmer during year  in the format dd.mm.yyyy
print(ftext.format(y))