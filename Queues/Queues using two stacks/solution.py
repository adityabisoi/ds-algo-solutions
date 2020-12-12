ENQUEUE = 1         # Assign values to variables
DEQUEUE = 2
PRINT = 3

def read_command():
    parts = input().strip().split(' ')          # Taking input
    cmd = int(parts[0])
    
    if len(parts) == 1:
        return (cmd, None)
    try:
        arg = int(parts[1])
    except ValueError:              # Handle error
        arg = parts[1]
        
    return cmd, arg

class Stack:                    # Create Stack class and define its methods
    def __init__(self):
        self._l = []
        
    def push(self, data):
        self._l.append(data)
        
    def pop(self):
        return self._l.pop()
    
    def __len__(self):
        return len(self._l)
    
    def top(self):
        if self._l:
            return self._l[-1]
        return None

class Queue:                    # Create Queue class and define its methods
    def __init__(self):
        self._head = Stack()
        self._tail = Stack()
    
    def enqueue(self, data):
        self._tail.push(data)
    
    def dequeue(self):
        if self._head:
            return self._head.pop()
            
        return self._tail_to_head().pop()
    
    def peek(self):
        if self._head:        
            return self._head.top()
            
        return self._tail_to_head().top()
    
    def _tail_to_head(self):
        while self._tail:
            self._head.push(self._tail.pop())          
            
        return self._head

    
def main():
    
    q = Queue()

    n_commands = int(input().strip())
    for _ in range(n_commands):
        command, arg = read_command()
        if command == ENQUEUE:
            q.enqueue(arg)
        elif command == DEQUEUE:
            q.dequeue()
        elif command == PRINT:
            print(q.peek())
            
        
if __name__ == '__main__':
    main()
