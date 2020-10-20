package lesson1014;
import java.util.Scanner;
import java.util.ArrayList;

public class Lesson1014 {
    
    public static String media="";  //переменная,хранящая информацию о носителе
    public static String player=""; //переменная, хранящая информацию о проигрывателе
    public static ArrayList<Song> playList = new ArrayList<>(); //лист,хранящий песни
    public static String playNow[]= {"","",""}; //массив,хранящий информацию о проигрываемых песнях
    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in,"cp1251");
        start();
    }
    
    
    public static void start(){ //метод запуска программы
        Scanner in=new Scanner(System.in,"cp1251");
        System.out.printf("Введите код команды:\n"
                + "1 - Выбрать проигрыватель\n"
                + "2 - Выбрать носитель\n"
                + "3 - Запись, удаление и просмотр песен\n"
                + "4 - Просмотреть все песни\n"
                + "5 - Включить песню на проигрывателе\n"
                + "6 - Посмотреть песни, которые играют сейчас\n"
                + "7 - Завершить\n\n");
        int command1=in.nextInt();
        String name, author;
        switch (command1) {
            case 1:
                choosePlayer();
                break;
            case 2:
                chooseCase();
                break;
            case 3:
                System.out.println("Введите код команды:\n"
                        + "1 - Записать новую песню на носитель\n"
                        + "2 - Удалить песню с носителя\n"
                        + "3 - Просмотреть все песни на носителе\n\n");
                int command4=in.nextInt();
                switch(command4){
                    case 1:
                        if(media==""){ 
                            System.out.println("Не выбран носитель");
                            break;
                        }
                        System.out.print("Введите автора песни: ");
                        author=in.next();
                        System.out.print("Введите название песни: ");
                        name=in.next();
                        playList.add(new Song(author, name, media));
                        break;
                    case 2:
                        if(media==""){
                            System.out.println("Не выбран носитель");
                            break;
                        }
                        System.out.print("Введите автора песни: ");
                        author=in.next();
                        System.out.print("Введите название песни: ");
                        name=in.next();
                        Song song=new Song(author, name, media);
                        boolean removeSong=false;
                        for(int i=0; i<playList.size(); i++) {
                            if(song.equals(playList.get(i))){
                                playList.remove(i);
                                removeSong=true;
                                break;
                            }
                        }
                        if(!removeSong){
                            System.out.println("Такая песня не найдена");
                        }
                        break;
                    case 3:
                        int cnt=0;
                        for(int i=0; i<playList.size(); i++) {
                            if(playList.get(i).getMedia().equals(media)){
                                System.out.println(playList.get(i).getSong());
                                cnt++;
                            }
                        }
                        if(cnt==0)System.out.println("Песен на носителе не найдено.");
                        break;
                    default:
                        System.out.println("Неверно введена команда");
                        break;
                    }
                break;
            case 4:
                for(Song s : playList) {
                    System.out.println(s.getSong());
                }
                if(playList.isEmpty())System.out.println("Ещё нет записанных песен");
                break;
            case 5:
                switch(player){
                    case "storageCard":
                        if(playMusic(0)){
                            System.out.println("На MP3 проигрывателе играет песня "+playNow[0]);
                        }
                        break;
                    case "CD":
                        if(playMusic(1)){
                            System.out.println("На CD проигрывателе играет песня "+playNow[1]);
                        }
                        break;
                    case "vinyl":
                        if(playMusic(2)){
                            System.out.println("На виниловой вертушке играет песня "+playNow[2]);
                        }
                        break;
                    default:
                        System.out.println("Проигрыватель не выбран");
                        break;
                }
                break;
            case 6:
                System.out.println("Введите код команды:\n"
                        + "1 - Все проигрыватели\n"
                        + "2 - Выбранный проигрыватель\n\n");
                int command5=in.nextInt();
                if(command5==1){
                    int cnt=0;
                    if(!playNow[0].equals("")){
                        System.out.println("В MP3 плеере играет "+ playNow[0]);
                        cnt++;
                    }
                    if(!playNow[1].equals("")){
                        System.out.println("В CD проигрывателе играет "+ playNow[1]);
                        cnt++;
                    }
                    if(!playNow[2].equals("")){
                        System.out.println("В виниловой вертушке играет "+ playNow[2]);
                        cnt++;
                    }
                    if(cnt==0)System.out.println("Сейчас ничего не играет");
                }else if(command5==2){
                    if (player.equals(""))System.out.println("Не выбран проигрыватель");
                    if(!playNow[typeOf(player)].equals("")){
                        System.out.println("На данном проигрывателе играет "+playNow[typeOf(player)]);
                    }
                }else{
                    System.out.println("Введена неверная команда");
                }
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Введена неверная команда.");
                start();
        }
        start();
    }
    
    public static void choosePlayer(){  //метод выбора проигрывателя
        Scanner in=new Scanner(System.in);
        System.out.printf("Выберете проигрывающее устройство:\n"
                + "1 - MP3 плеер\n"
                + "2 - CD проигрыватель\n"
                + "3 - Виниловая вертушка\n"
                + "4 - Назад\n\n");
        int command2=in.nextInt();
        switch(command2){
            case 1:
                player="storageCard";
                break;
            case 2:
                player="CD";
                break;
            case 3:
                player="vinyl";
                break;
            case 4:
                start();
                break;
            default:
                System.out.println("Неверно введена команда.");
                choosePlayer();
        }
    }
    
    public static void chooseCase(){    //метод выбора носителя
        Scanner in=new Scanner(System.in);
        System.out.printf("Выберете носитель:\n"
                + "1 - Карта памяти\n"
                + "2 - CD диск\n"
                + "3 - Виниловая пластинка\n"
                + "4 - Назад\n\n");
        int command3=in.nextInt();
        switch(command3){
            case 1:
                media="storageCard";
                break;
            case 2:
                media="CD";
                break;
            case 3:
                media="vinyl";
                break;
            case 4:
                start();
                break;
            default:
                System.out.println("Неверно введена команда");
                chooseCase();
                break;
        }
    }
    
    public static int typeOf(String player){    //метод,определяющий тип проигрывателя
        switch(player){
            case "storageCard":
                return 0;
            case "CD":
                return 1;
            case "vinyl":
                return 2;
        }
        return -1;
    }
    
    public static boolean playMusic(int type){  //метод, воспроизводящий песни
        Scanner in=new Scanner(System.in,"cp1251");
        System.out.print("Введите автора песни: ");
        String author=in.next();
        System.out.print("Введите название песни: ");
        String name=in.next();
        Song song=new Song (author, name, player);
        if(playList.contains(song)){
            playNow[type]=author+" - "+name;
            return true;
        }else{
            System.out.println("Такой песни нет на подходящем носителе");
            return false;
        }
    }
    
}
