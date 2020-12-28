import sys

#Driver code
if __name__ == '__main__':
    
    #input n = attendees, m = topics and known/unknown topics string
    N, M = list(map(int, sys.stdin.readline().split()))
    T = [int(sys.stdin.readline(), 2) for _ in range(N)]
    
    max_topics, num_teams = 0, 0
    
    # all possible teams of 2 participants
    # 0 means participant not know the topic and 1 means know the topic
    # in pairing of team if atleast anyone know the topic, then team also know the topic 
    for i in range(len(T) - 1):
        for j in range(i + 1, len(T)):
            # OR operation between two participants
            # count if it is 1 i.e team know the topic
            topics = bin(T[i] | T[j]).count('1')
            
            # count number of teams whoever also know the maximum topics
            if(topics == max_topics):
                num_teams += 1
            # update maximimum number of topics known by a team
            if(topics > max_topics):
                max_topics = topics
                num_teams = 1
    
                # display result
    print(max_topics)
    print(num_teams)

