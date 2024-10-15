def sherlockAndAnagrams(s):
    
    anagrams = 0
    slen = len(s)

    for i in range(slen):
        for j in range(i+1, slen):

            substr = ''.join(sorted(s[i:j]))
            sublen = len(substr)

            for x in range(i+1, slen):

                if x + sublen > slen:
                    break

                substr2 = ''.join(sorted(s[x:x+sublen]))

                if substr == substr2:
                    anagrams += 1

    return anagrams

for _ in range(int(input())):
    print(sherlockAndAnagrams(input()))