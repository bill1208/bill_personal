package com.java;

/**
 * Created by z00176928 on 2017/4/27.
 */
public class TryCatch {

    int name = 0;

    public static void main(String[] args) {
        TryCatch tc = new TryCatch();
        System.out.println(tc.f());
        System.out.println(tc.name);
    }

    public int f() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }

    public void g() {
        try {
            name = 1;
        } finally {
            name = 2;
        }
    }
}
