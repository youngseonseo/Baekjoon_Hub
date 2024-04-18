import sys

n,m = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))
start = 0
end = max(array)

while start <= end:
    result = 0
    mid = (start + end)//2
    for i in array:
        if i  > mid:
            result += i - mid
    if result >= m:
        start = mid + 1
    else:
        end = mid - 1

print(end)