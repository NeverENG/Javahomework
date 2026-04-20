import random
def generate():
    n =1000000
    numbers = [random.randint(1,100)for _ in range(n)]
    with open('random_numbers.txt','w') as f:
        f.write('\n'.join(map(str,numbers)))
generate()