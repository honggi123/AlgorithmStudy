import java.util.*;

public class Main {
    
    static int MAX = 100000;
    static int min = Integer.MAX_VALUE;
    static int n,k;
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        k = scan.nextInt();
        
        bfs();
        System.out.println(min);
    }
    
    public static void bfs(){
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(n,0));
        boolean[] visited = new boolean[MAX+1];
        
        while(!que.isEmpty()){
            Node node = que.poll();            
           
            visited[node.x] = true;
            
            if(node.x == k){
                min = Math.min(min, node.time);
            }
                
            if(node.x *2 <= MAX && !visited[node.x *2]) que.add(new Node(node.x * 2, node.time));
            if(node.x +1 <= MAX && !visited[node.x +1]) que.add(new Node(node.x + 1, node.time + 1));
            if(node.x -1 >= 0 && !visited[node.x -1]) que.add(new Node(node.x - 1, node.time + 1));
        }
    }
    
    static class Node{
        int x;
        int time;
        
        Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
}