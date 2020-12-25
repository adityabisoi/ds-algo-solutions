import sys

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

print(minUnfairness);