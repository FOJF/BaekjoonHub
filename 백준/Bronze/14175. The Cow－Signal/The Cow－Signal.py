M, N, K = map(int, input().split())

for _ in range(M):
	s = input()
	print('\n'.join(''.join([c * K for c in s]) for _ in range(K)))