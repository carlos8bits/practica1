/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 *
 * @author jhon
 */
public class Permutar {

    private int[] a;
    private BigInteger numLeft;
    private BigInteger total;

    public Permutar(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("No ha ingresado caracteres");
        }
        a = new int[n];
        total = getFactorial(n);
        reset();
    }
    
    public void hola ()
    {}

    public ArrayList<String> Permutacion(String hilera) {
        ArrayList<String> result = new ArrayList<String>();
        char[] elements = hilera.toCharArray();
        StringBuffer permutation;
        while (hasMore()) {
            permutation = new StringBuffer();
            int[] indices;
            indices = getNext();
            for (int i = 0; i < indices.length; i++) {
                permutation.append(elements[indices[i]]);
            }
            result.add(permutation.toString());
        }
        return result;
    }

    

    public void reset() {
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        numLeft = new BigInteger(total.toString());
    }

    public BigInteger getNumLeft() {
        return numLeft;
    }

    public BigInteger getTotal() {
        return total;
    }

    public boolean hasMore() {
        return numLeft.compareTo(BigInteger.ZERO) == 1;
    }

    private static BigInteger getFactorial(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            fact = fact.multiply(new BigInteger(Integer.toString(i)));
        }
        return fact;
    }

    public int[] getNext() {

        if (numLeft.equals(total)) {
            numLeft = numLeft.subtract(BigInteger.ONE);
            return a;
        }

        int temp;

// Find largest index j with a[j] < a[j+1]
        int j = a.length - 2;
        while (a[j] > a[j + 1]) {
            j--;
        }

// Find index k such that a[k] is smallest integer
// greater than a[j] to the right of a[j]
        int k = a.length - 1;
        while (a[j] > a[k]) {
            k--;
        }

// Interchange a[j] and a[k]
        temp = a[k];
        a[k] = a[j];
        a[j] = temp;

// Put tail end of permutation after jth position in increasing order
        int r = a.length - 1;
        int s = j + 1;

        while (r > s) {
            temp = a[s];
            a[s] = a[r];
            a[r] = temp;
            r--;
            s++;
        }

        numLeft = numLeft.subtract(BigInteger.ONE);
        return a;
    }
}
//public static void main(String[] args) {
//int[] indices;
//String[] elements = { "a", "b", "c", "d" };
//permutaciones x = new permutaciones(elements.length);
//StringBuffer permutation;
//while (x.hasMore()) {
//permutation = new StringBuffer();
//indices = x.getNext();
//for (int i = 0; i < indices.length; i++) {
//permutation.append(elements[indices[i]]);
//}
//System.out.println(permutation.toString());
//}
//
//}

