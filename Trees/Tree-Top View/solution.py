def topView(root):
    # Initialize the level
    this_level = [(root, 0)]
    scores = {}
    while this_level:
        # Basically iterate over the nodes on a single level
        for _ in range(len(this_level)):
            node, score = this_level.pop(0)
            # Skip empty nodes
            if not node:
                continue
            # Store the score if it's a new one!
            if score not in scores:
                scores[score] = node.info
            # Add the node children to the next level
            this_level.extend(
                [(node.left, score - 1),
                (node.right, score + 1)])

    # Sort the scores and print their values 
    # (By default the sort is on the tuple first element: the score)
    for _, value in sorted(list(scores.items())):
        print(value, end=' ')