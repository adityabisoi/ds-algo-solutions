#!/bin/python3

import sys

numbers = "0123456789"
lower_case = "abcdefghijklmnopqrstuvwxyz"
upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
special_characters = "!@#$%^&*()-+"

def minimumNumber(n, password):
    res1 = max(0, 6 - n)
    res2 = 0
    if not any(c in password for c in lower_case):
        res2 += 1
    if not any(c in password for c in upper_case):
        res2 += 1
    if not any(c in password for c in numbers):
        res2 += 1
    if not any(c in password for c in special_characters):
        res2 += 1
    return max(res1, res2)

if __name__ == "__main__":
    n = int(input().strip())
    password = input().strip()
    answer = minimumNumber(n, password)
    print(answer)