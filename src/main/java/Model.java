import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Model {
    private final View view = new View();

    public void printPointMenu() {
        view.pointMenu();
    }

    public ArrayList<String> enterArr(ArrayList<String> array){
        Scanner iScanCommands = new Scanner(System.in);
        while (true) {
            String input = iScanCommands.nextLine();
            if (input.equals("n") | input.equals("т")) {
                break;
            }
            array.add(input);
        }
        return array;
    }


    public void reloadAnimals(String typeName, String genus, String nickName, ArrayList<String> commands, String birthDay, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            String stringComm = String.join(" ", commands);
            String text = typeName + ";" + genus + ";" + nickName + ";" + birthDay + ";"
                    + stringComm;
            assert text != null;
            writer.write(text);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            view.error();
            ex.getMessage();
        }
    }

    public void readerAnimals(String fileName) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String type = data[0];
                String genus = data[1];
                String name = data[2];
                String date = data[3];
                String skills = String.join(" ", data[4]);
                System.out.println("Тип животного=> " + type + "  Вид=>" + genus + "  Кличка=>"
                        + name + "  Дата рождения=>" + date + "  Команды=>" + skills);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Boolean findNameAnimal(String nickName, String fileName){
        boolean result = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            if(nickName.isEmpty()){
                view.emptyString();
            }
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                counter += 1;
                String[] data = line.split(";");
                String type = data[0];
                String genus = data[1];
                String name = data[2];
                String date = data[3];
                String skills = String.join(" ", data[4]);
                if(nickName.equals(name)) {
                    counter = 0;
                    System.out.println("Тип животного=> " + type + "  Вид=> " + genus + "  Кличка=> "
                            + name + "  Дата рождения=> " + date + "  Команды=> " + skills);
                    result = true;
                    break;
                }
            }
            if(counter !=0){
                view.noFindName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String[] arrayAnimal(String nickName, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            if(nickName.isEmpty()){
                view.emptyString();
            }
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String name = data[2];
                if(nickName.equals(name)) {
                    return data;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAnimal(String nickName, String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()){
                    String[] data = line.split(";");
                    String type = data[0];
                    String genus = data[1];
                    String name = data[2];
                    String date = data[3];
                    String skills = String.join(" ", data[4]);
                    if(!nickName.equals(name)) {
                        String file = "TempAnimals.txt";
                        ArrayList<String> newSkills = new ArrayList<>();
                        newSkills.add(skills);
                        reloadAnimals(type, genus, name, newSkills, date, file);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void reloadCounter(Integer count, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.append(String.valueOf(count));
            //writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            view.error();
            ex.getMessage();
        }
    }
    public Integer readerCount(String fileName) {

        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count = parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void cleanFile(String fileName) throws IOException {
        new FileOutputStream(fileName, false).close();
    }

    public void copyFile(File tempFile, File file) throws Exception{
        FileInputStream in = new FileInputStream(tempFile);
        FileOutputStream out = new FileOutputStream(file);
        try {

            int n;
            while ((n = in.read()) != -1) {
                out.write(n);
            }
        }
        finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
