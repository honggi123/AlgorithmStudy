import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Node implements Comparable<Node>{
    int end;
    int weight;
    
    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Node o){
        return weight - o.weight;
    }
}
 
public class Main {
    static int N, E;
    static ArrayList<ArrayList<Node>> list; 
    static int[] dist; 
    static boolean[] check; 
    static final int INF = 200000000;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
 
        list = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];
 
        Arrays.fill(dist, INF);
 
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        
        for (int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int sum1 = 0;
        sum1 += dijkstra(1, v1);
        sum1 += dijkstra(v1, v2);
        sum1 += dijkstra(v2, N);
        
        int sum2 = 0;
        sum2 += dijkstra(1, v2);
        sum2 += dijkstra(v2, v1);
        sum2 += dijkstra(v1, N);
        
        int ans = 0;
        if(sum1 >= INF && sum2 >= INF){
            ans = -1;
        } else { 
           ans = Math.min(sum1, sum2);
        }
            
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int dijkstra(int start, int end){
        Arrays.fill(check, false);
        Arrays.fill(dist ,INF);
        
        check = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;
       
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(check[now.end]) continue;
            check[now.end] = true;
            
            for(Node node: list.get(now.end)){
                if(dist[node.end] > dist[now.end] + node.weight){
                    dist[node.end] = dist[now.end] + node.weight;
                    pq.add(new Node(node.end, dist[now.end] + node.weight));
                }
            }
        }
       return dist[end];
    }
}
