def solution(a, b, c):
    answer = 0
    if a!=b and b!=c and c!=a:
        return a+b+c
    elif a==b and b==c and c==a:
        return (a+b+c) * (a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c)
    else: return (a+b+c) * (a*a+b*b+c*c)
    
    def solution(a, b, c):
    answer = 0
    if a!=b and b!=c and c!=a:
        return a+b+c
    elif a==b and b==c and c==a:
        return (a+b+c) * (a**2+b**2+c**2)*(a**3+b**3+c**3)
    else: return (a+b+c) *  (a**2+b**2+c**2)
