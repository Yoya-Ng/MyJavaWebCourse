package mvc.model;

public class BMIModel {

    private int h;
    private int w;
    private double bmi;

    public BMIModel(int height, int whight) {
        this.h = height;
        this.w = whight;
    }

    public double getBmi() {
        bmi = w / Math.pow(h/100, 2);
        return bmi;
    }

}
