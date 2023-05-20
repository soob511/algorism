def solution(n):
    answer = 0
    for i in range(1,n+1):
        if n%2==0:
            if i%2==0:
                answer+=i*i
        else:
            if i%2==1:
                answer+=i
    return answer
  


def solution(n):
    answer = 0
    if n%2==0:
        for i in range(2,n+1,2):
            answer += i**2
    else:
        for i in range(1,n+1,2):
            answer+=i

    return answer
