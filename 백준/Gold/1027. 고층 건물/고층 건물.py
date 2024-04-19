N = int(input())
building = list(map(int, input().split()))
INF = int(1e10)
def angle(i, h1, j, h2):
    return (h2-h1)/(j-i)

count = [0] * N


for i in range(N):
    standard_left = [INF] * N
    standard_right = [-INF] * N
    for j in range(i-1, -1, -1):
        left_angle = angle(i, building[i], j, building[j])

        if min(standard_left) > left_angle:
            standard_left[j] = left_angle
            count[i] += 1

        else:
            standard_left[j] = min(standard_left)
    for j in range(i+1, N):

        right_angle = angle(i, building[i], j, building[j])

        if max(standard_right) < right_angle:
            standard_right[j] = right_angle
            count[i] += 1
        else:
            standard_right[j] = max(standard_right)

print(max(count))