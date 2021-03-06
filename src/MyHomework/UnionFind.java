package MyHomework;

public class UnionFind {
    private int parent[];
    private int size[];
    private int n;
    private int setCount;

    public UnionFind(int _n) {
        parent = new int[_n];
        size = new int[_n];
        n = _n;
        setCount = _n;
    }

    int findset(int x) {
        if (parent[x] == x) return x;
        else {
            parent[x] = findset(parent[x]);
            return parent[x];
        }
    }

    Boolean unite(int x, int y) {
        x = findset(x);
        y = findset(y);
        if (x == y) return false;
        if (size[x] < size[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        size[x] += size[y];
        --setCount;
        return true;
    }

    Boolean connected(int x, int y) {
        return findset(x) == findset(y);
    }
}
