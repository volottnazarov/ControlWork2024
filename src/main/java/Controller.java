import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Controller {

    private final View view = new View();
    private final Model model = new Model();
    private final Counter counter = new Counter();

    public void helloMenu(){
        view.hello();
    }

    public void cycleNaviMenu() throws Exception {
        Scanner iScanne = new Scanner(System.in);
        boolean exit = false;
        String fileCount = "Counter.txt";
        String fileAnimals = "Animals.txt";
        String fileTemp = "TempAnimals.txt";
        while (!exit) {
            model.printPointMenu();
            view.enterNumberMenu();
            if(iScanne.hasNextInt()){
                int menuNum = iScanne.nextInt();
                if (menuNum >= 1 && menuNum <= 5) {

                    switch (menuNum) {
                        case 1:
                            view.newAnimals();
                            Scanner iScanGenus = new Scanner(System.in);
                            view.enterGenusType();
                            String genus = iScanGenus.nextLine();
                            Scanner iScanTypeName = new Scanner(System.in);
                            view.enterAnimalsType();
                            String typeName = iScanTypeName.nextLine();
                            Scanner iScanName = new Scanner(System.in);
                            view.enterNickname();
                            String nickname = iScanName.nextLine();
                            ArrayList<String> skills = new ArrayList<>();
                            view.enterCommandsText();
                            model.enterArr(skills);
                            Scanner iScanBirthDay = new Scanner(System.in);
                            view.enterBirthDay();
                            String birthDay = iScanBirthDay.nextLine();
                            if(genus.equals("собака")){
                                try{
                                    ArrayList<String> skillsDog = new ArrayList<>();
                                    skillsDog.addAll(skills);
                                    Dogs dogs = new Dogs(typeName, nickname, skillsDog, birthDay);
                                    view.enterNewAnimal();
                                    System.out.println(dogs);
                                    model.reloadAnimals(dogs.getTypeName(), genus, dogs.getNickname(),
                                            skillsDog, dogs.getBirthday(), fileAnimals);
                                    counter.totalCount(model.readerCount(fileCount));
                                    counter.add();
                                    model.reloadCounter(counter.resultCount(), fileCount);
                                } catch (Exception e){
                                    e.printStackTrace();
                                }

                            } else if (genus.equals("верблюд")) {
                                try {
                                    ArrayList<String> skillsCamel = new ArrayList<>();
                                    skillsCamel.addAll(skills);
                                    Camel camel = new Camel(typeName, nickname, skillsCamel, birthDay);
                                    view.enterNewAnimal();
                                    System.out.println(camel);
                                    model.reloadAnimals(camel.getTypeName(), genus, camel.getNickname(),
                                            skillsCamel, camel.getBirthday(), fileAnimals);
                                    counter.totalCount(model.readerCount(fileCount));
                                    counter.add();
                                    model.reloadCounter(counter.resultCount(), fileCount);
                                } catch (Exception e){
                                    e.printStackTrace();
                                }
                            } else {
                                view.error();
                                view.noClassAnimals();
                            }
                            break;
                        case 2:
                            view.findAnimals();
                            Scanner findName = new Scanner(System.in);
                            view.enterNickname();
                            String name = findName.nextLine();
                            model.findNameAnimal(name, fileAnimals);
                            view.learnComm();
                            Scanner enterWorld = new Scanner(System.in);
                            String world = enterWorld.nextLine();
                            if(world.equals("y") |  world.equals("н")) {
                                try {
                                    ArrayList<String> newSkills = new ArrayList<>();
                                    view.newCommands();
                                    model.enterArr(newSkills);
                                    String[] animals = model.arrayAnimal(name, fileAnimals);
                                    ArrayList<String> oldSkills = new ArrayList<>(List.of(animals[4]));
                                    newSkills.addAll(oldSkills);
                                    view.oldSkills(oldSkills);
                                    view.newSkills(newSkills);
                                    if (animals[1].equals("собака")) {
                                        String findGenus = "собака";
                                        Dogs dogs = new Dogs(animals[0], animals[2], newSkills, animals[3]);
                                        System.out.println(dogs);
                                        model.reloadAnimals(dogs.getTypeName(), findGenus, dogs.getNickname(),
                                                newSkills, dogs.getBirthday(), fileTemp);
                                        model.deleteAnimal(dogs.getNickname(), fileAnimals);
                                        model.cleanFile(fileAnimals);
                                        File tempFile = new File(fileTemp);
                                        File file = new File(fileAnimals);
                                        model.copyFile(tempFile, file);
                                        model.cleanFile(fileTemp);
                                    } else if (animals[1].equals("верблюд")) {
                                        String findGenus = "верблюд";
                                        Camel camel = new Camel(animals[0], animals[2], newSkills, animals[3]);
                                        System.out.println(camel);
                                        model.reloadAnimals(camel.getTypeName(), findGenus, camel.getNickname(),
                                                newSkills, camel.getBirthday(), fileTemp);
                                        model.deleteAnimal(camel.getNickname(), fileAnimals);
                                        model.cleanFile(fileAnimals);
                                        File tempFile = new File(fileTemp);
                                        File file = new File(fileAnimals);
                                        model.copyFile(tempFile, file);
                                        model.cleanFile(fileTemp);
                                    }

                                } catch (Exception e) {
                                    e.printStackTrace();
                                    view.error();
                                }
                            }
                            break;

                        case 3:
                            view.showAllAnimals();
                            view.totalAnimals(counter.totalCount(model.readerCount(fileCount)));
                            model.readerAnimals(fileAnimals);
                            view.totalAnimals(counter.totalCount(model.readerCount(fileCount)));
                            break;
                        case 4:
                            boolean exitDel = false;
                            while (!exitDel){
                                view.deleteAnimals();
                                Scanner findDelName = new Scanner(System.in);
                                view.enterDeleteName();
                                String deleteName = findDelName.nextLine();
                                if(model.findNameAnimal(deleteName, fileAnimals)){
                                    model.deleteAnimal(deleteName, fileAnimals);
                                    model.cleanFile(fileAnimals);
                                    File tempFile = new File(fileTemp);
                                    File file =new File(fileAnimals);
                                    model.copyFile(tempFile, file);
                                    model.cleanFile(fileTemp);
                                    view.animalDeleteComplete(deleteName);
                                    counter.totalCount(model.readerCount(fileCount));
                                    counter.out();
                                    model.reloadCounter(counter.resultCount(), fileCount);
                                    exitDel = true;
                                }
                            }
                            break;
                        case 5:
                            view.goodbye();
                            exit = true;
                            break;
                    }
                } else {
                    view.error();
                    view.enterNumberMenu();
                }
            } else {
                view.error();
                view.enterDigitNumberMenu();
                iScanne = new Scanner(System.in);
            }

        }
    }

}
