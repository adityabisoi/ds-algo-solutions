ins = input().strip()

is_pm = ins[-2:].lower() == 'pm'
time_list = list(map(int, ins[:-2].split(':')))
 