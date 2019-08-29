package sample.solver;

import javafx.util.Pair;

import java.util.*;

import static java.lang.Math.pow;

public class SolverLR1 {
    private int b;
    private int t;
    private int m;
    private List<Double> result;

    public SolverLR1(int b, int t, int m) {
        this.b = b;
        this.t = t;
        this.m = m;
    }

    public List<Double> calculate() {
        int N = (int) pow(2, m) - 1;
        Set<Double> result = new HashSet<>();
        int size = (int) pow(b, t);
        int[] bValue = initValue();
        for (int i = -N; i <= N; i++) {
            for (int j = 0; j < size; j++) {
                result.add(f(bValue, i));
                bValue = nextValue(bValue);
            }
            bValue = nextValue(initValue());
        }
        List<Double> rrr = new LinkedList(result);
        rrr.sort(Double::compareTo);
        this.result = rrr;
        return rrr;
    }


    public List<String> getViewResultList() {
        List<String> r = new LinkedList<>();
        for (int i = 0; i < result.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i).append(") ").append("x[").append(i).append("]=").append(result.get(i));
            r.add(sb.toString());
        }
        return r;
    }

    public List<LR1Result> getTableResult() {
        List<LR1Result> r = new LinkedList<>();
        for (int i = 0; i < result.size(); i++) {
            r.add(new LR1Result(i, "x[" + i + "]", result.get(i).toString()));
        }
        return r;
    }

    private int[] initValue() {
        int[] bValue = new int[t];
        for (int i = 0; i < t; i++) {
            bValue[i] = 0;
        }
        return bValue;
    }

    private int[] nextValue(int[] bValue) {
        bValue[0]++;
        for (int i = 0; i < bValue.length; i++) {
            if (bValue[i] == b) {
                bValue[i] = 0;
                if (i + 1 < bValue.length) {
                    bValue[i + 1]++;
                }
            }
        }

        return bValue;
    }

    private double f(int[] bValue, int N) {
        double sum = 0;
        for (int i = 0; i < bValue.length; i++) {
            sum += bValue[i] / pow(b, i + 1);
        }
        sum *= pow(b, N);
        return sum;
    }

    public class LR1Result {
        private Integer i;
        private String numberColumn;
        private String valueColumn;

        public LR1Result(Integer i, String numberColumn, String valueColumn) {
            this.i = i;
            this.numberColumn = numberColumn;
            this.valueColumn = valueColumn;
        }

        public Integer getI() {
            return i;
        }

        public String getNumberColumn() {
            return numberColumn;
        }

        public String getValueColumn() {
            return valueColumn;
        }
    }

}
