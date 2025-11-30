package day3.parent;

public class Parent {
    protected int data = 100;
    private int secret = 50;

    public void showData() {
        showProtected();
        showSecret();
    }

    protected void showProtected() {
        System.out.println("Protected field value: " + data);
    }

    private void showSecret() {
        System.out.println("Secret is " + secret);
    }

    protected int getData() {
        return data;
    }

    private int getSecret() {
        return secret;
    }

    public void operation() {
        System.out.println(getData() + getSecret());
    }
}
