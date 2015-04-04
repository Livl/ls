package Ls;

import java.io.File;

public class ls {
    
    static void ls(String folderPath){
    File directory= new File(folderPath);    
        if(directory.isDirectory()){
            //String path= directory.getPath();
            //System.out.println(path);
//            String[] contains= directory.list();
//            for(int i=0;i<contains.length;i++){
//                System.out.println(contains[i]);
//            }
            
            for(String name: directory.list()) {
                System.out.println(name);
                
            }
        }
        else
            System.out.println("Niepoprawny format");
    }
    public static void main(String[] args) {
        ls(".");
    }
}
