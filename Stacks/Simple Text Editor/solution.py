#!/bin/python

s = ""
stack = []

q = int(raw_input())

for i in xrange(q):
    line = raw_input()
    command = line[0]
  
    if command == '1':
        value = line.split(' ')[1]
        s += value
        stack.append(dict(command=1, value=value))
    elif command == '2':
        k = int(line.split(' ')[1])
        value = s[len(s) - k: len(s)]
        s = s[: len(s) - k]
        stack.append(dict(command=2, value=value))
    elif command == '3':
        k = int(line.split(' ')[1])
        print s[k-1]
    else:
        action = stack.pop()
        if action['command'] == 1:
            #erase value
            s = s[:len(s) - len(action['value'])]
        elif action['command'] == 2:
            #append value
            s += action['value']