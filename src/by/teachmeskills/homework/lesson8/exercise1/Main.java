package by.teachmeskills.homework.lesson8.exercise1;

public class Main {
    public static void main(String[] args) {
        FirstPhone firstPhone = new FirstPhone();
        SecondPhone secondPhone = new SecondPhone();
        ThirdPhone thirdPhone = new ThirdPhone();
        firstPhone.print();
        secondPhone.print();
        thirdPhone.print();

        firstPhone.getNumber();
        secondPhone.getNumber();
        thirdPhone.getNumber();

        firstPhone.recieveCall("David",3);

        secondPhone.sendMessage(12,25,96,108,20);

    }
}
