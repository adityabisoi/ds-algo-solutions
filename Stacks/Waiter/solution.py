#!/bin/python

#this utility is for checking the ith prime
def next_prime():
    prime = 1
    while True:
        prime += 1 
        is_prime = True
        for i in range(1,(prime/2)+1):
            if i!=1 and prime%i == 0: #if the number is divisible by any number from 2 to the number itself, then its not prime
                is_prime = False
                break
        if is_prime:
            yield prime

prime_generator = next_prime() #generating the prime numbers/pre=processing primes

N, Q = map(int, raw_input().split(" ")) #no. of plates (N) and the no. of iterations (Q)

all_plates = map(int, raw_input().split(" ")) #inputting plates

for i in range(Q): 
    prime = prime_generator.next() #generating prime numbers 
    
    all_plates.reverse() 
    temp = []
    while len(all_plates)!=0:
        plate = all_plates.pop() #popping each plate 
        if plate%prime == 0: # check whether the number written on the plate is divisible by the i-th prime.
            print plate #stacking the plate in B[i] or printing the plates on B piles
        else:
            temp.append(plate) #appending the other numbers not divisible by i-th prime in temp to be printed later
    all_plates = temp

    all_plates.reverse() #the process continues for the range 1,Q

all_plates.reverse()
    
print "\n".join(map(str,all_plates)) #printing A plates
