sum = 0
heights = {'Es': 21, 'Stair': 17}
for _ in range(4):
	t, h = map(str, input().split())
	sum += heights[t]*int(h)
print(sum)