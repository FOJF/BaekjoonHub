N, M = map(int, input().split())
data = list(map(int, input().split()))
data.sort()

picked = []

def bt(picked, data, M) :
	if len(picked) == M :
		for p in picked :
			print(p, end=" ")
		print()
		return

	for d in data :
		if not d in picked :
			picked.append(d)
			bt(picked, data, M)
			picked.pop()

bt(picked, data, M)
