package day3;

import day3.child.*;
import day3.parent.*;
import day3.utils.*;

public class Main {

    public static void main(String[] args) {
        Parent p = new Parent();
        p.showData();


        Child c = new Child();
        c.showData();

        Utils u = new Utils();
        Utils.showData();
        u.doubleData();
    }
    
}
