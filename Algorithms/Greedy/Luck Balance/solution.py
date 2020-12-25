#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):
    # sort the contests list from highest to lowest luck factor
    contests = sorted(contests, key=lambda contest: contest[0], reverse=True)
    luck = 0
    for contest in contests:
        if contest[1]:
            # if contest is important and you can still lose matches, lose (as luck factor is high)
            if k > 0:
                k -= 1
                luck += contest[0]
            # if contest is important and you can't lose anymore matches, win
            else:
                luck -= contest[0]
        # if contest is not important, lose
        else:
            luck += contest[0]
    return luck


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)

    fptr.write(str(result) + '\n')

    fptr.close()
