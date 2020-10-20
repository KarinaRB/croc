package lesson1014;

public class Song {
    /**
     * Класс создающий объекты песен
     */
    
    private String name;
    private String author;
    private String storage;
    
    /**
     * 
     * @param author автор песни
     * @param name название песни
     * @param storage место хранения песни
     */
    public Song(String author,String name, String storage){
        this.author=author;
        this.name=name;
        this.storage=storage;
    }
    
    /**
     * Метод,возвращающий автора песни
     * @return автор песни
     */
    public String getAuthor(){
        return(this.author);
    }
    
    /**
     * Метод, возвращающий название песни
     * @return название песни
     */
    public String getName(){
        return(this.name);
    }
    
    /**
     * Метод,возвращающий место хранение песни на русском язвке 
     * @return место хранения песни
     */
    public String getStorage(){
        String media="";
        switch(this.storage){
            case "CD":
                media="CD диск";
                break;
            case "vinyl":
                media="Виниловая пластинка";
                break;
            case "storageCard":
                media="Карта памяти";
                break;
        }
        return media;
    }
    
    /**
     * метод,возвращающий параметр хранения песни
     * @return место хранения песни
     */
    public String getMedia(){
        return this.storage;
    }
    
    /**
     * Метод возвращающий информацию о песне в виде строки
     * @return информацию о песне
     */
    public String getSong(){
        return(this.author+" - "+this.name+ " ("+ this.getStorage() +")");
    }
    
    /**
     * Метод сравнения двух объектов
     * @param obj сравниваемый объект
     * @return логическое зрачение сравнения
     */
    public boolean equals(Object obj) {
        if (this == obj) 
          return true;
        if (obj == null)
          return false;
        if (this.getClass() != obj.getClass())
          return false;
        Song other = (Song) obj;
        if (!this.author.equals(other.author))
          return false;
        if (!this.name.equals(other.name))
          return false;
        if (!this.storage.equals(other.storage))
          return false;
        return true;
    }

}
