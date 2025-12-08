N, M = map(int, input().split())

lectures = list(map(int, input().split()))

l, r = 1, 1000000000
answer = r

while l <= r:
	mid = (l + r) // 2
	
	cnt = 1
	size = 0

	for lec in lectures:
		size += lec
		if size > mid:
			size = lec
			cnt += 1
		if lec > mid:
			cnt = 1000000000
			break

	if cnt > M:
		l = mid + 1
	else:
		answer = min(answer, mid)
		r = mid - 1

print(answer)