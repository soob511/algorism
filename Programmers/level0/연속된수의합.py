def solution(num, total):
    answer = []
    if total >num:
        for i in range (0,101):
            sum = 0
            for j in range (i,i+num):
                sum+=j
            if sum == total:
                for j in range (i,i+num):
                    answer.append(j)
    else:
        for i in range (-100,101):
            sum = 0
            for j in range (i,i+num):
                sum+=j
            if sum == total:
                for j in range (i,i+num):
                    answer.append(j)
    return answer


def solution(num, total):
    if num % 2 == 1:
        return list(range(total//num-num//2, total//num+num//2+1))
    else:
        return list(range(total//num-num//2+1, total//num+num//2+1))
