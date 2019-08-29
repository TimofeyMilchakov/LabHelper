package sample.solver;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

public class SolverLR3 {

    private int N;
    private List<String> result;

    public SolverLR3(int n) {
        N = n;
    }

    public List<String> calculate() {
        result = new LinkedList<>();
        int nAbs = abs(N);
        for (int i = 1; i <= nAbs; i++) {
            double dx = calculateDouble(i);
            float x = calculateFloat(i);
            result.add(" dx= " + dx + "; x-dx=" + (x - dx) + "; (x-dx)/dx=" + ((x - dx) / dx) + " \n");
        }

        return result;
    }


    public List<String> getResult() {
        return result;
    }

    private double calculateDouble(int i) {
        if (i == 0) {
            return N >= 0 ? 0 : 1;
        }
        return calculateDouble(i - 1) + 1d / N;
    }

    private float calculateFloat(int i) {
        if (i == 0) {
            return N >= 0 ? 0 : 1;
        }
        return calculateFloat(i - 1) + 1f / N;
    }
}
