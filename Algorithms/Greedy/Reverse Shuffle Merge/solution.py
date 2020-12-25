# imports
from collections import defaultdict
# input the string 
S = input()
S = S[::-1]
count = defaultdict(int)
for c in S:
    count[c] += 1
need = {}
for c in count:
    need[c] = count[c] / 2
solution = []
i = 0
# Output the string which is the lexicographically smallest valid S
while len(solution) < len(S) / 2:
    min_char_at = -1
    while True:
        c = S[i]
        if need[c] > 0 and (min_char_at < 0 or c < S[min_char_at]):
            min_char_at = i
        count[c] -= 1
        if count[c] < need[c]:
            break
        i += 1
    for j in range(min_char_at+1, i+1):
        count[S[j]] += 1
    need[S[min_char_at]] -= 1
    solution.append(S[min_char_at])
    i = min_char_at + 1
print(''.join(solution))