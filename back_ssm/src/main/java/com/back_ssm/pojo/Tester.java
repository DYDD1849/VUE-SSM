package com.back_ssm.pojo;

public class Tester {
    private int testId;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    @Override
    public String toString() {
        return "Tester{" +
                "testId=" + testId +
                '}';
    }
}
