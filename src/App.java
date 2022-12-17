import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String name = "", nim = "";

        int numberInput = 0;

        Scanner scanner = new Scanner(System.in);

        boolean isNameHasValid = false, isNimHasValid = false, isNumberIsValid = false;

        Scanner nameScanner = new Scanner(System.in);
        do {
            System.out.print("Masukkan Nama Anda [1...25] : ");
            String tempName = nameScanner.nextLine();

            if (validateLengthName(tempName)) {
                isNameHasValid = true;
                name = tempName;
            }
        } while (!isNameHasValid);

        do {
            System.out.print("Masukkan Nim Anda [harus 10 karakter] : ");
            String tempNim = scanner.nextLine();

            if (validateLengthNim(nim)) {
                isNimHasValid = true;
                nim = tempNim;
            }
        } while (!isNimHasValid);

        System.out.printf("Registrasi sukses...\nSelamat datang [%s : %s]..", name, nim);


        String isUserWantToRetry = "Y";

        while(isUserWantToRetry.equals("Y")){
            do {
                System.out.print("\nMasukkan Sembarang Angka [5...20] : ");
                int tempNumberInput = scanner.nextInt();

                if(validateLengthNumberInput(tempNumberInput)){
                    isNumberIsValid = true;
                    numberInput = tempNumberInput;
                }

                showOddNumber(numberInput);
                System.out.println("\n");
                showEvenNumber(numberInput);
                System.out.println("\n");
                showFibonacciNumber(numberInput);
                System.out.println("\n");

            } while (!isNumberIsValid);

            System.out.print("Anda ingin mengulang [y/t] ");
            Scanner wantToRetryScanner = new Scanner(System.in);
            isUserWantToRetry = wantToRetryScanner.nextLine().toUpperCase(Locale.ROOT);
        }
    }

    static boolean validateLengthName(String keyword) {
        return keyword.length() >= 1 && keyword.length() <= 25;
    }

    static boolean validateLengthNim(String nim) {
        return nim.length() <= 10;
    }

    static boolean validateLengthNumberInput(int number) {
        return number <= 20 && number >= 5;
    }

    static void showOddNumber(int numberInput){
        System.out.println(numberInput + " Bilangan Ganjil");
        int sumGanjil = 0;
        for (int angka = 1; angka <= numberInput * 2; angka++) {
            if (angka % 2 == 1) {
                System.out.print(angka + " ");
                sumGanjil = sumGanjil + angka;
            }
        }
        System.out.printf("\nHasil Penjumlahan = " + sumGanjil);
    }

    static void showEvenNumber(int numberInput){
        System.out.println(numberInput + " Bilangan Genap");
        int sumGenap = 0;
        for (int angka = 1; angka <= numberInput * 2; angka++) {
            if (angka % 2 == 0) {
                System.out.print(angka + " ");
                sumGenap = sumGenap + angka;
            }
        }
        System.out.printf("\nHasil Penjumlahan = " + sumGenap);
    }

    static void showFibonacciNumber(int numberInput){
        System.out.println(numberInput + " Bilangan Fibonacci");
        int past = 0, current = 1, fibonacci, angka, sumFibonacci = 0;
        for (angka = 0; angka <= numberInput; angka++) {
            System.out.print(current + " ");
            fibonacci = past + current;
            past = current;
            current = fibonacci;
            sumFibonacci = sumFibonacci + past;
        }
        System.out.printf("\nHasil Penjumlahan = " + sumFibonacci);
    }
}
