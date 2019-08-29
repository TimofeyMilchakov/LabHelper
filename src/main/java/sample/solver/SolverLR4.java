package sample.solver;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.pow;

public class SolverLR4 {
    private double x;
    private double N;
    private List<String> result;

    public SolverLR4(double x, double n) {
        this.x = x;
        N = n;
    }

    public void calculate() {
        int size =1;
        while (pow(x,size)/factorial(size)>=N){
            size++;
        }

        result = new LinkedList<>();
        result.add("simple = " + simpleExp(size, x) + " \n");
        result.add("simple = " + nextLevelExp(size, x) + " \n");
    }

    public List<String> getResult() {
        return result;
    }

    private double nextLevelExp(int i, double val) {
        int real = (int) val;
        double img = val - real;
        return simpleExp(i, real) * simpleExp(i, img);
    }


    private double simpleExp(int i, double val) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return val + simpleExp(0, val);
        }
        return simpleExp(i - 1, val) + pow(val, i) / factorial(i);
    }

    private double factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }


}
