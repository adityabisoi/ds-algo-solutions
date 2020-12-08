#!/bin/python


def next_prime():
    prime = 1
    while True:
        prime += 1
        is_prime = True
        for i in range(1,(prime/2)+1):
            if i!=1 and prime%i == 0:
                is_prime = False
                break
        if is_prime:
            yield prime

prime_generator = next_prime()

N, Q = map(int, raw_input().split(" "))

all_plates = map(int, raw_input().split(" "))

for i in range(Q):
    prime = prime_generator.next()
    
    all_plates.reverse()
    temp = []
    while len(all_plates)!=0:
        plate = all_plates.pop()
        if plate%prime == 0:
            print plate
        else:
            temp.append(plate)
    all_plates = temp

    all_plates.reverse()

all_plates.reverse()
    
print "\n".join(map(str,all_plates))