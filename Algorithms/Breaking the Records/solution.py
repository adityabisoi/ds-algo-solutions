def breaking_records(score):             # A function to accept list of scores
    highest_score = score[0]             # default highest record
    lowest_score = score[0]              # default lowest record
    count_highest = 0                    # Number of times highest record broke
    count_lowest = 0                     # Number of times lowest record broke
    for items in score:                  # for loop to iterate in the list
        if items > highest_score:        # if a score is higher than default
            count_highest += 1           # Number of times highest record broke increases
            highest_score = items        # this new record will be our default
        elif items < lowest_score:       # if a score is lower than default
            count_lowest += 1            # Number of times lowest record broke increases
            lowest_score = items         # this new record will be our default
        else:                            # if none is happening then
            continue                     # continue with the loop
    return count_highest, count_lowest   # return the desired value


if __name__ == '__main__':
    n = int(input())                     # number of matches

    scores = list(map(int, input().rstrip().split())) # scores of 'n' matches stored in a list

    result = breaking_records(scores)                 # storing the result of a function in a variable

    print(' '.join(map(str, result)))                 # printing the desired result
