package com.bayuedekui.unionfind;

import java.util.HashMap;
import java.util.*;

public class lc721_账户合并 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // 采用并查集：将email进行连接起来，两条记录，有交集的email就是同一个人的，
        // 将email进行编号起来
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToIdx = new HashMap<>();

        int emailIdx = 0;
        // 进行emailToIdx和emailToName的填充
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                emailToName.put(acc.get(i), name);
                emailToIdx.put(acc.get(i), emailIdx++);
            }
        }

        UnionFind uf = new UnionFind(emailIdx);
        // 进行并查集的union
        for (List<String> acc : accounts) {
            int size = acc.size();
            // 所有的都和每个列表中的第一个进行并
            String firstEmail = acc.get(1);
            int firstEmailIdx = emailToIdx.get(firstEmail);
            for (int i = 2; i < size; i++) {
                int nextEmailIdx = emailToIdx.get(acc.get(i));
                uf.union(firstEmailIdx, nextEmailIdx);
            }
        }

        // 用一个idxToEmail存储父节点的idx以及对应email
        Map<Integer, List<String>> idxToEmail = new HashMap<>();
        for (String email : emailToIdx.keySet()) {
            int idx = emailToIdx.get(email);
            int fatherIdx = uf.find(idx);
            List<String> tmpEmails = idxToEmail.getOrDefault(fatherIdx, new ArrayList<>());
            tmpEmails.add(email);
            idxToEmail.put(fatherIdx, tmpEmails);
        }

        List<List<String>> res = new ArrayList<>();
        // 进行结果的生成
        for (List<String> ems : idxToEmail.values()) {
            Collections.sort(ems);
            String name = emailToName.get(ems.get(0));
            List<String> subRes = new ArrayList<>();
            subRes.add(name);
            subRes.addAll(ems);
            res.add(subRes);
        }
        return res;

    }

    class UnionFind {
        private Map<Integer, Integer> parent;

        public UnionFind(int n) {
            parent = new HashMap<>();
            for (int i = 0; i <= n; i++) {
                parent.put(i, i);
            }
        }

        public int find(int x) {
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);

            if (rootx != rooty) {
                parent.put(rootx, rooty);
            }
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }

}
