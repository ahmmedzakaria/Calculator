package com.ahmmed.zakaria.calculator;


public class Calculator {
    private Double numberOne;
    private Double numberTwo;
    private Double result;
    private Double memory=0.0;

    boolean divideBtn=false;
    boolean multiplyBtn=false;
    boolean subtructBtn=false;
    boolean additionBtn=false;
    boolean powrBtn=false;
    boolean percentBtn=false;
    boolean rootBtn=false;
    boolean equalBtn=false;
    boolean btn=false;

    public Double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(Double numberOne) {
        this.numberOne = numberOne;
    }

    public Double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(Double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Double getMemory() {
        return memory;

    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }


}
