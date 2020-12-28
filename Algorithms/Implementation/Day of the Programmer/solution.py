y = int(input())
if y < 1918:
    ftext = "13.09.{}" if y & 3 else "12.09.{}"
elif y > 1918:
    ftext = "13.09.{}" if (y & 3) or (y % 400 and not y % 100) else "12.09.{}"
else:
    ftext = "26.09.{}"
print(ftext.format(y))