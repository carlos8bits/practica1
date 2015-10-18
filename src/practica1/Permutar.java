/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

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
    public Permutar()
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

    public String RamdonHilera(int n, String objHilera) {
        char[] cHilera = new char[objHilera.length()];
        StringBuffer random = new StringBuffer();
        cHilera = objHilera.toCharArray();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
             
            int randomNum = rand.nextInt(n + 1) ;
            random.append(cHilera[randomNum]);
            
        }
        return random.toString();

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

    public static BigInteger getFactorial(int n) {
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

// Busca el mayor  j con  a[j] < a[j+1]
        int j = a.length - 2;
        while (a[j] > a[j + 1]) {
            j--;
        }

// Busca el indice k de manera que  a[k] es el menor 
// mayor que  a[j] 
        int k = a.length - 1;
        while (a[j] > a[k]) {
            k--;
        }

// intercambia a[j] y a[k]
        temp = a[k];
        a[k] = a[j];
        a[j] = temp;

// Coloca la permutacion despues de la posicion j 
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
