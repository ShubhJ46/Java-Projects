package day3.child;

import day3.parent.Parent;

public class Child extends Parent {
    void showParentData() {
        System.out.println("Parent's data: " + super.getData());
    }

    // void showParentSecret() {
    //     System.out.println("Parent's secret: " + super.getSecret());
    // }

    @Override
    public void showData() {
        super.showData();
    }

    @Override
    protected void showProtected() {
        super.showProtected();
    }

    // @Override
    // private void showSecret() {
    //     super.showSecret();
    // }
}
