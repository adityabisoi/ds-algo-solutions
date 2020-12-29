// poisonousPlants function using stack
static int poisonousPlants(int[] p) {
    Stack<Pair> stack = new Stack<>();
    int cnt = 0;
    for (int i = p.length - 1; i >= 0; i--) {
        int temp = 0;
        while (!stack.empty() && p[i] < stack.peek().val) {
            temp++;
            Pair pair = stack.pop();
            temp = Math.max(temp, pair.count);
        }
        cnt = Math.max(cnt, temp);
        stack.push(new Pair(p[i], temp));
    }

    return cnt;

}