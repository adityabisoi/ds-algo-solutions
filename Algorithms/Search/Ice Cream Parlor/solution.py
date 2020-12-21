def main():
    # Loop through for each test.
    for _ in range(int(input())):
        dollars = int(input())
        numFlavors = int(input())
        flavors = [int(i) for i in input().split()]

        # Determine the correct indexes.
        index1, index2 = -1, -1
        for i in range(numFlavors):
            for j in range(numFlavors):
                if (i != j) and (flavors[i] + flavors[j] == dollars):
                    index1 = i + 1
                    index2 = j + 1
                    break
            if index1 != -1 and index2 != -1:
                break
                
        # Print the answer.
        print(str(index1) + " " + str(index2))
        
if __name__ == "__main__":
    main()