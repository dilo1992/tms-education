package by.teachmeskills.homework.lesson8.exercise2;

public class Dentist extends Doctor {

    @Override
    public void heal(Client client) {
        System.out.println("I thread teeth  " + client.getName());
    }
}
