import java.util.Scanner;

public class SimulasiSort {
    int angkaMin,angkaMax;
    static int[] data=new int[5];
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
       	 int pilihMenu=0;

    	 while (pilihMenu!=6){
            System.out.print ( "\nSelamat Datang di Program Simulasi \n"
            + "Menu:\n"
            + "1. Random Data \n"
            + "2. Simulasi Bubble Sort - Ascending \n"
            + "3. Simulasi Selection Sort - Ascending\n"
            + "4. Simulasi Bubble Sort - Descending\n"
            + "5. Simulasi Selection Sort - Descending\n"
            + "6. Keluar \n"
            + "Masukan Pilihan Anda:");
            
            pilihMenu=in.nextInt();

            switch (pilihMenu){
                case 1:

                randomData();
                break;
                case 2:
                BubbleSort();
                break;
                case 3:
                selectionSort();
                break;
                case 4:
                BubbleSort(false);
                break;
                case 5:
                selectionSort(false);
                break;
                case 6:

                break;
    	    }
    	 }
    }

     static void randomData(){
    	 System.out.print ( "Batas Bawah:");
    	 int angkaMin=in.nextInt();
    	 System.out.print ( "Batas Atas:");
    	 int angkaMax=in.nextInt();
    	 for (int i=1;i<=5;i++){
    	    data[i-1]=(int)(angkaMin + (int) (Math.random() * (angkaMax - angkaMin + 1)));
    	 }

    	 printData();
     }

     static void BubbleSort(){
    	 BubbleSort(true);
     }

     static void BubbleSort(boolean asc){
    	 for (int i=1;i<data.length;i++){
        	 System.out.print("Pass "+ i+ "\n");
    	     for (int j=0;j<data.length-i;j++ ){
                selectBySort(asc,j);
                printData();
             }
         System.out.print("\n Result of Pass "+ i+ "\n");
         printData();
    	 }

     }

     static void selectBySort(boolean asc, int index){
    	 if (asc){
            if (data[index]>data[index+1])
            swap(index,index+1);
    	 }
    	 else{
            if (data[index]<data[index+1])
            swap(index,index+1);
    	 }

     }

     static void swap(int index1, int index2 ){
    	 int iTemp;
    	 iTemp=data[index1];
    	 data[index1]=data[index2];
    	 data[index2]=iTemp;
     }

     static void selectionSort(){
    	 selectionSort(true);
     }

     static void selectionSort(boolean asc){
    	 for (int i=0;i<data.length-1;i++){
    	     System.out.print("\n Pass "+ (i+1) + "\n");
    	     int currentMin=data[i];
             int currentMinIdx=i;
    	     for (int j=i+1;j<data.length;j++){
    	        if (asc){
    	            if (currentMin>data[j]){
    	                currentMin=data[j];
    	                currentMinIdx=j;
    	            }
    	        }
    	        else{
    	            if (currentMin<data[j]){
    	                currentMin=data[j];
    	                currentMinIdx=j;
    	            }
    	        } 
    	        printData();
    	     }

    	     if (currentMinIdx!=i){
    	        data[currentMinIdx]=data[i];
    	        data[i]=currentMin;
    	     }

    	 System.out.print("\n Result of Pass "+ (i+1)+ "\n");
    	 printData();
    	 }
     }

   	 static void printData(){
    	 for (int i=0;i< data.length ;i++){
    	    System.out.print(data[i]+ " ");
    	 }
    	 System.out.print("\n");
    }
}