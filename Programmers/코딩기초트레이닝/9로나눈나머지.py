def solution(number):
    answer = 0
    str(number)
    for i in number:
        answer+=int(i)
    return answer%9
