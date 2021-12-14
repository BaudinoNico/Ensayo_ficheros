import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    private static File arch= new File ( "counters");
    private static Scanner in = new Scanner(System.in);
    private static Map<String,String> mapa; //= new HashMap<String,String>();

    public static void main(String[] args) throws IOException {
        int adm=0,doc=0;
        String texto;
        texto = "";

        if (arch.exists()){
            String adm1,doc1;
            FileReader lector= new FileReader(arch);
            BufferedReader bLector= new BufferedReader(lector);
            adm=Integer.parseInt(bLector.readLine())-10;
            doc=Integer.parseInt(bLector.readLine())-10;
            System.out.println(adm+'\n');
            System.out.println(doc+'\n');
        } else {
            FileWriter fwescribir= new FileWriter(arch);
            BufferedWriter bwescribir= new BufferedWriter (fwescribir);
            bwescribir.write(String.valueOf(adm));
            bwescribir.newLine();
            bwescribir.write(String.valueOf(doc));
            bwescribir.flush();
            bwescribir.close();
        }

        Leer();

        for(Object key : mapa.keySet()) {
            System.out.println(key);
        }

        mapa.put("Prueba6","6");
        //mapa.put("Prueba2","2");
        //mapa.put("Prueba3","3");
        //mapa.put("Prueba4","4");

        for(Object key : mapa.keySet()) {
            System.out.println(key);
        }

        Guardar();
    }

    public static void Guardar() {
        try {
            FileOutputStream guardado = new FileOutputStream("pruebaG.ser");
            ObjectOutputStream out = new ObjectOutputStream(guardado);
            out.writeObject(mapa);
            out.close();
            guardado.close();
            System.out.println("Serialized data is saved in pruebaG.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public static void Leer() {
        try {
            FileInputStream fileIn = new FileInputStream("pruebaG.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            mapa = (Map<String,String>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
          //  return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        //    return;
        }


    }

}
