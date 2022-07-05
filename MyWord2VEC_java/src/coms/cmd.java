package coms;

import java.io.IOException;
import java.io.InputStream;

public class cmd {

    public static void main(String[] args) {
        try {
            String cmdString = "cmd /k start jupyter notebook";
            Runtime.getRuntime().exec( cmdString );
//            cmdString = "cmd /k notepad";
//            Runtime.getRuntime().exec( cmdString );
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        Runtime run = Runtime.getRuntime();
        try{
            Process process = run.exec("cmd.exe /k strat" + "calc");

            InputStream in = process.getInputStream();

            while(in.read() != -1)  {
                System.out.println(in.read());
            }
            in.close();
            process.waitFor();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
