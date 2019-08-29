package sample.solver;

import java.util.LinkedList;
import java.util.List;

public class SolverLR2 {
    private static double START_VALUE = 0.5;
    private double c;
    private List<Double> res;


    public SolverLR2(double c) {
        this.c = c;
    }

    public List<Double> calculate() {
        res = new LinkedList<>();
        double exp = START_VALUE;
        while (true) {
            res.add(exp);
            if(c+exp>c){
                exp/=2;
            }else{
                break;
            }
        }
        return res;
    }


}
