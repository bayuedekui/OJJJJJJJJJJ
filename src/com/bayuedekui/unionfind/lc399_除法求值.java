package com.bayuedekui.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class lc399_除法求值 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = equations.size();
        UnionFind uf = new UnionFind(equations);
        for (int i = 0; i < len; i++) {
            List<String> list = equations.get(i);
            uf.union(list.get(0), list.get(1), values[i]);
        }

        int resLen = queries.size();
        double[] res = new double[resLen];
        Map<String, Double> weight = uf.getWeight();
        Map<String, String> parent = uf.getParent();
        System.out.println(weight);
        System.out.println(parent);
        for (int i = 0; i < resLen; i++) {
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);
            boolean flag = parent.containsKey(x) && parent.containsKey(y);
            if (flag && uf.isConn(x, y)) {
                res[i] = weight.get(x) / weight.get(y);
            } else {
                res[i] = -1d;
            }
        }
        return res;

    }

    public class UnionFind {
        private Map<String, String> parent;
        private Map<String, Double> weight;

        public UnionFind(List<List<String>> equations) {
            parent = new HashMap<>();
            weight = new HashMap<>();
            for (List<String> list : equations) {
                parent.put(list.get(0), list.get(0));
                parent.put(list.get(1), list.get(1));
                weight.put(list.get(0), 1d);
                weight.put(list.get(1), 1d);
            }

        }

        public String find(String x) {
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x)));
                weight.put(x, weight.get(x) * weight.get(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(String x, String y, double value) {
            String rootx = find(x);
            String rooty = find(y);

            if (!rootx.equals(rooty)) {
                parent.put(rootx, rooty);
                weight.put(rootx, weight.get(rooty) * value / weight.get(rootx));
            }
        }

        public boolean isConn(String x, String y) {
            return find(x).equals(find(y));
        }

        public Map<String, String> getParent() {
            return parent;
        }

        public Map<String, Double> getWeight() {
            return weight;
        }

    }
}
