#imports
import sys

#input number of elements in an array and the number of elements to select
N = int(sys.stdin.readline());
K = int(sys.stdin.readline());
S = [0] * N;

for iN in range(N):
    S[iN] = int(sys.stdin.readline());

S.sort()

minUnfairness = S[iN-1];
for iN in range(N-K):
    minUnfairness = min(
        minUnfairness,
        S[iN + K - 1] - S[iN]
    );
# print the minimum possible unfairness
print(minUnfairness);