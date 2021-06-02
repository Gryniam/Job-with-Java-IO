import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IFile {
    public IFile() {
    }

    String line = "-----------------------------------------------------------------------------------";
    String columns = "|    id    |      Ім'я        |      Прізвище       |      Вік      |     Зріст    |";
    String newline = System.getProperty("line.separator");

    void WriteInFile() {
        int change = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Добавити значення в таблицю= 1\nАвтоматично заповнити таблицю=2\nВиберіть варіант: ");
        change = s.nextInt();
        if (change < 1 || change > 2) {
            change = 2;
        }

        List<Model> mod = new ArrayList<>();

        if (change == 1) {
            String nname;
            String ppriz;
            double vvik;
            int zrist;
            int id = 1;

            int iter;
            Scanner inn = new Scanner(System.in);
            System.out.println("Cкільки рядків бажаєте заповнити?: ");
            iter = inn.nextInt();

            Scanner in = new Scanner(System.in);
            for (int i = 0; i < iter; i++) {
                System.out.println("Введіть ім'я: ");
                nname = in.next();
                System.out.println("Введіть прізвище: ");
                ppriz = in.next();
                System.out.println("Введіть вік: ");
                vvik = in.nextDouble();
                System.out.println("Введіть зріст: ");
                zrist = in.nextInt();
                mod.add(new Model(id, vvik, zrist, nname, ppriz));
                id++;
            }
            in.close();
            id = 1;
        } else if (change == 2) {
            mod.add(new Model(1, 18, 185, "Владислав", "Гриньків"));
            mod.add(new Model(2, 20, 182, "Михайло", "Павлюк"));
            mod.add(new Model(7, 19, 192, "Ярослав", "Лучинський"));
            mod.add(new Model(4, 18, 184, "Олексій", "Решетнік"));
            mod.add(new Model(5, 17, 193, "Максим", "Максимчук"));
            mod.add(new Model(6, 36, 160, "Леві", "Аккерман"));
            mod.add(new Model(3, 32, 189, "Наруто", "Узумакі"));
            mod.add(new Model(8, 207, 164, "Тарас", "Шевченко"));
            mod.add(new Model(9, 132, 175, "Адольф", "Гітлер"));
            mod.add(new Model(10, 16, 155, "Юлія", "Парфанович"));
        }
        mod.sort(Model::Sort);

        try {
            Writer f = new FileWriter("Text.txt", true);
            f = new OutputStreamWriter(new FileOutputStream("Text.txt"), StandardCharsets.UTF_8);
            f.write(line + newline);
            f.write(columns + newline);
            f.write(line + newline);
            for (int i = 0; i < mod.toArray().length; i++) {
               // f.write("|" + "\t\t" + mod.get(i).getId() + " |" + "\t\t" + mod.get(i).getName() + " |" + "\t\t\t" + mod.get(i).getPriz() + " |" + "\t\t\t" + mod.get(i).getAge() + " |" + "\t\t" + mod.get(i).getHeight() + " |" + newline + line + newline);
                f.write(String.format("%8s | %20s | %15s | %10s | %15s|", mod.get(i).getId(), mod.get(i).getName(), mod.get(i).getPriz(), mod.get(i).getAge(), mod.get(i).getHeight())+newline+line+newline);
            }
            f.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readfromFile() {
        try {
            BufferedReader b = new BufferedReader(new InputStreamReader(new FileInputStream("Text.txt"), "UTF-8"));
            b.read();
            int reader;
          /* reader = b.read();
          while(reader != -1){
              System.out.print((char)reader);
          }*/
           /* while(b.read() != -1){
              System.out.print((char)b.read());
          }*/
            while ((reader = b.read()) != -1) {
                System.out.print((char) reader);
            }

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
