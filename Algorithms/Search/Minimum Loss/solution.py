def minimumLoss(prices):
    
    n = len(prices)
    minimum_loss = float('INF')
    
    # List of tuples of (price,index)
    price_index = []
    for index,price in enumerate(prices):
        price_index.append((price,index))
        
    # Sorting the tuple i.e. price_index
    price_index.sort(key = lambda x : (x[0],x[1]))
    
    for index in range(1,n):
        # Storing the current and the previous element values
        currentPrice,currentIndex = price_index[index]
        prevPrice,prevIndex       = price_index[index-1]
        
        # If the index of previous index is less than current index
        # If the price of previous index is more than or equal to current index
        if(currentIndex < prevIndex and currentPrice >= prevPrice):
            minimum_loss = min(minimum_loss,currentPrice - prevPrice)
        
    return minimum_loss
            
