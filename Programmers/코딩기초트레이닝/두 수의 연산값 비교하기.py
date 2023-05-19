def solution(a, b):
    answer = 2*a*b
    a,b = str(a),str(b)
    answer1 = int(a+b)
    return max(answer,answer1)
  
 def solution(a, b):
    return max(int(str(a) + str(b)), 2 * a * b)
