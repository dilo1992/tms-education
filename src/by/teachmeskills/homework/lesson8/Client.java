package by.teachmeskills.homework.lesson8;

import by.teachmeskills.homework.lesson8.exercise2.MedicalPlan;

public class Client {
    private MedicalPlan medicalPlan;
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public MedicalPlan getMedicalPlan() {
        return medicalPlan;
    }

    public void setMedicalPlan(MedicalPlan medicalPlan) {
        this.medicalPlan = medicalPlan;
    }

}
