# A single string that represents a time in 12-hour clock format 
ins = input().strip()

is_pm = ins[-2:].lower() == 'pm'
time_list = list(map(int, ins[:-2].split(':')))

if is_pm and time_list[0] < 12:
    time_list[0] += 12

if not is_pm and time_list[0] == 12:
    time_list[0] = 0
# print a new string representing the input time in 24 hour format
print(':'.join(map(lambda x: str(x).rjust(2, '0'), time_list)))