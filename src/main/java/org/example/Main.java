package org.example;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        double[][] matrix = /*{
                            {1,6,0},
                            {0,6,0},
                            {0,0,1}};*/


                {{0,0,	 0,	0,	0,	0},
                        {0,5,	 6,	5,	7,	3},
                        {0,1,	 2,	3,	1,	2},
                        {0,6,	 5,	4,	3,	2},
                        {0,11,12,	3,	4,	5},
                        {0,1,	21,	2,	2,	3}};

        double[][] L = new double[matrix.length][matrix[1].length];
        double[][] R = new double[matrix.length][matrix[1].length];
        System.out.println("X: "+matrix.length+" "+L.length+" "+R.length);
        System.out.println("Y: "+matrix[1].length+" "+L[1].length+" "+R[1].length);

        for (int i=0; i< matrix[1].length; i++) {

            for (int j = 0; j < matrix.length; j++) {
            L[j][i]=0;
            R[j][i]=0;
            }
            R[i][i]=matrix[i][i];
            L[i][i]=1;
        }



        for (int i=1; i< matrix[1].length; i++){

            for (int j=1; j<matrix.length;j++){
                double sum1 =0;
                double sum2 =0;
                if(j<i){


                    for(int k=0;k<=j;k++){
                        sum1 = sum1+L[i][k]*R[k][j];
                    }
                    L[i][j]= (matrix[i][j]-sum1)/ R[j][j];

                }
                if(i<=j){

                    for(int k=0;k<i;k++){
                        sum2 = sum2+L[i][k]*R[k][j];
                    }
                    R[i][j]=(matrix[i][j]-sum2)/L[i][i];

                }
            }
        }


        for(int i =0;i< matrix[1].length;i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("********************************");
        for(int i =0;i< matrix[1].length;i++){
            System.out.println(Arrays.toString(L[i]));
        }
        System.out.println("********************************");
        for(int i =0;i< matrix[1].length;i++){
            System.out.println(Arrays.toString(R[i]));
        }
    }
}