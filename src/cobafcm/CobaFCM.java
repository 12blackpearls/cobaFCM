
package cobafcm;
import java.util.*;
public class CobaFCM {

    public static void main(String[] args) {
        int m, n, w = 2, c, iter = 0, maxx;
        double temp = 0, temps = 0, tempz = 0;
        double x = 0, y = 0, error;
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan jumlah data : ");
        n = in.nextInt();
        System.out.println("Masukkan jumlah atribut : ");
        m = in.nextInt();
        System.out.println("Masukkan jumlah cluster : ");
        c = in.nextInt();
        System.out.println("Masukkan batas error : ");
        error = in.nextDouble();
        System.out.println("Masukkan jumlah iterasi maksimal : ");
        maxx = in.nextInt();
        double arr[][] = new double[n][m];
        double arrs[][] = new double[n][c];
        double arra[][] = new double[c][m];
        double array[][] = new double[n][m];
        double arrays[]= new double[n];
        double arrz[] = new double[n];
        double iters[] = new double[100];
        double cent, center, tempor = 0;
        System.out.println("array data");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = in.nextFloat();
            }
        }
        while(iter == 0 || ((Math.abs(x-y) > error) && iter < maxx)) {
            y = x; tempz = 0;
            if(iter == 0) {
                System.out.println("array random");
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < c; j++) {
                        arrs[i][j] = in.nextFloat();
                    }
                }
            } else {
                tempor = 0;
                for(int i = 0; i < n; i++) {
                    arrz[i] = 0;
                    for(int j = 0; j < c; j++) {
                        tempor = 0;
                        for(int k = 0; k < m; k++) {
                            tempor = tempor + Math.pow(arr[i][k]-arra[j][k],2);
                        }
                        tempor = Math.pow(tempor,-1/(w-1));
                        arrs[i][j]= tempor;
                        arrz[i] = arrz[i] + tempor;
                        //System.out.println("tempor "+tempor);
                    }
                }
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < c; j++) {
                        arrs[i][j] = arrs[i][j] / arrz[i];
                    }
                }
//                System.out.println("hayoo");
//                for(int i = 0; i < n; i++) {
//                    for(int j = 0; j < c; j++) {
//                        System.out.println(arrs[i][j]);
//                    }
//                }
            }
            //tentukan pusat cluster
            for(int k = 0; k < c; k++){
                cent = 0; center = 0;
                for(int i = 0; i < n; i++) {
                    arrays[i] = Math.pow(arrs[i][k], w);
                    cent = cent + arrays[i];
                    for(int j = 0; j < m; j++) {
                        array[i][j] = arr[i][j] * arrays[i];
                    }
                }
                //System.out.println("cent "+cent);
                for(int i = 0; i < m; i++) {
                    center = 0;
                    for(int j = 0; j < n; j++) {
                        center = center + array[j][i];
                    }
                    //System.out.println("center "+center);
                    arra[k][i] = center / cent;
                }
    //            for(int i = 0; i < n; i++) {
    //                cent = cent + arrays[i];
    //                for(int j = 0; j < m; j++) {
    //                    center = center + array[i][j];
    //                }
    //            }
            }
    //        System.out.println("pusat cluster");
    //        for(int i = 0; i < c; i++) {
    //            for(int j = 0; j < m; j++) {
    //                arra[i][j] = in.nextFloat();
    //            }
    //        }
            for(int i = 0; i < n; i++) {
                //System.out.println("i "+(i+1));
                temps = 0;
                for(int k = 0; k < c; k++){
                    //System.out.println("k "+(k+1));
                    temp = 0;
                    for(int j = 0; j < m; j++) {
                        //System.out.println("j "+(j+1));
                        temp = temp + Math.pow((arr[i][j]-arra[k][j]),2);
                    }
                    //temps = temp;
                    //temp = 0;
                    temps = temps + (temp * Math.pow(arrs[i][k],2));
                }
                tempz = tempz + temps;
                //System.out.println("tempz" + tempz);
            }
            x = tempz;
            iters[iter] = tempz;
            //System.out.println(tempz);
            iter++;
        }
        for(int i = 0 ; iter > 0; iter--) {
            System.out.println("Iterasi " + (i+1) + " : " +iters[i]);
            i++;
        }
    }
    
}
