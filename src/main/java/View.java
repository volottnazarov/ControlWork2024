import java.util.ArrayList;

public class View {
    public void hello(){
        System.out.println("***** Добро пожаловать в наш зверинный питомник! *****");
        System.out.println("======================================================");
    }

    public void pointMenu(){
        System.out.println("Выберите пункт меню");
        System.out.println("======================================================");
        System.out.println("1. Завести новое животное");
        System.out.println("2. Новые команды животного");
        System.out.println("3. Просмотр всех животных (+количество)");
        System.out.println("4. Удалить животное");
        System.out.println("5. Выход");
        System.out.println("======================================================");
    }
    public void error(){
        System.out.println("Ошибка! ");
    }
    public void enterNumberMenu(){
        System.out.println("Введите номер пункта меню от 1 до 5: ");
    }
    public void enterDigitNumberMenu(){
        System.out.println("Введите число, соответствующее пункту меню от 1 до 5:");
    }
    public void noClassAnimals(){
        System.out.println("Возможно что наш питомник не поддерживает данный класс животных.");
        System.out.println("Обратитесь в администрацию.");
    }
    public void newAnimals(){
        System.out.println("***** Новые команды животного *****");
    }
    public void enterNewAnimal(){
        System.out.println("***** Животное добавлено ***** ");
    }
    public void findAnimals(){
        System.out.println("***** Найти животное *****");
    }
    public void showAllAnimals(){
        System.out.println("***** Посмотреть всех (Количество) *****");
    }
    public void learnComm(){
        System.out.println("Хотите обучить новым командам введите 'y'', если нет нажмите 'ENTER' ");
    }
    public void newCommands(){
        System.out.println("Введите новые команды через 'Enter', по окончании введите 'n'");
    }
    public void oldSkills(ArrayList<String> skills){
        System.out.println("Список команд: " + skills);
    }
    public void newSkills(ArrayList<String> skills){
        System.out.println("Обновленный список команд: " + skills);
    }
    public void totalAnimals(int total){
        System.out.println("------------------------------------------------------");
        System.out.println("Всего в питомнике " + total + " животное(-ых)");
        System.out.println("-------------------------------------------------------");
    }
    public void deleteAnimals(){
        System.out.println("***** Удалить животное *****");
    }
    public void enterAnimalsType(){
        System.out.println("Введите тип животного (например: домашние, вьючные):");
    }
    public void enterGenusType(){
        System.out.println("Введите вид животного (например: осёл, кошка): ");
    }
    public void enterNickname(){
        System.out.println("Введите кличку животного");
    }

    public void enterCommandsText(){
        System.out.println("Введите команды выполняемые животным через ENTER, по окончании введите 'n' ");
    }
    public void enterBirthDay(){
        System.out.println("Введите дату рождения: ");
    }
    public void emptyString(){
        System.out.println("Вы ввели пустое значение!");
    }
    public void noFindName(){
        System.out.println("С таким именем животное не найдено!");
    }
    public void enterDeleteName(){
        System.out.println("Введите кличку животного, которого хотите удалить: ");
    }
    public void animalDeleteComplete(String name){
        System.out.println("Животное с именем " + name + " удалено");
    }
    public void goodbye(){
        System.out.println("******** До встречи! *********");
    }

}
