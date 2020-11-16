package receipt;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReceiptLogger {

    public void receipt() throws IOException {

        String response = "Yes";
        Scanner scan = new Scanner(System.in);
        File diskFile = new File("Log.txt");



        FileWriter aFileWriter = new FileWriter(diskFile, true);
        BufferedWriter bw = new BufferedWriter(aFileWriter);
        PrintWriter p = new PrintWriter(bw);

        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        List<Double> total = new ArrayList<>();
        String format = String.format("%1$-25s %2$-10s %3$-20s ", "Market", "  Price" , "  Date");
        p.println("");
        p.println(format);
        while (response.equalsIgnoreCase("yes")) {


            System.out.println("Please Enter Market Name:");
            String market = scan.nextLine();

            System.out.println("Please enter your purchase price:");
            double price = scan.nextDouble();
            total.add(price);

            String formattedLogLine = String.format("%1$-25s %2$-10s %3$-20s ", market, "| $" + price, "| " + date);
            p.println(formattedLogLine);

            System.out.println("Do you want add more? (Yes/No)");
            response = scan.next();
            scan.nextLine();

            if(!response.equalsIgnoreCase("Yes")&& !response.equalsIgnoreCase("No")){
                System.out.println("Please enter Yes/No");
                response=scan.next();
                scan.nextLine();
            }
        }
        double totalPrice = 0;
        for (int i = 0; i < total.size(); i++) {
            totalPrice += total.get(i);
        }
        p.println("Total Price for Today's Shop: $" + totalPrice);
        bw.close();
        BufferedReader br = new BufferedReader(new FileReader("Log.txt"));

        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }


        br.close();

    }

}

