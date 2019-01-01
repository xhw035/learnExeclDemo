import java.util.*;

enum FileType{
    CPP, HEADER
}

public class FileInfo {

    public String fileName;
    public FileType type;
    public List<String> directDependencyFile;
    public List<String> dependencyLink;
    public Set<String> allDependencyFile;
    public Map<String,List<String>> repeatHeaderFiles;

    public FileInfo(String fileName) {
        this.fileName = fileName;
        if (fileName.endsWith(".h")){
            this.type = FileType.HEADER;
        }else {
            this.type =FileType.CPP;
        }
        this.directDependencyFile = new ArrayList<>();
        this.dependencyLink = new ArrayList<>();
        this.allDependencyFile = new LinkedHashSet<>();
        this.repeatHeaderFiles = new HashMap<>();
    }

    public void printDependencyLink()
    {
        for(String str: dependencyLink){
            System.out.println(fileName+"的依赖链："+str);
        }
        System.out.println();
    }

    public void printAllDependencyFile()
    {
        for(String str: allDependencyFile){
            System.out.println(fileName+"直接或者间接依赖的头文件："+str);
        }
        System.out.println();
    }

    public void printRepeatHeaderFiles()
    {
        for(Map.Entry<String, List<String>> entry: repeatHeaderFiles.entrySet()){
            System.out.println(fileName+"重复包含："+entry.getKey()+": ");
            for(String str:entry.getValue()){
                System.out.println("    "+str);
            }
            System.out.println();
        }
        System.out.println();
    }

}
