import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum FileType{
    CPP, HEADER
}

public class FileInfo {

    public String fileName;
    public FileType type;
    public List<String> directDependencyFile;
    public List<String> dependencyLink;
    public Set<String> allDependencyFile;

    public FileInfo(String fileName) {
        this.fileName = fileName;
        if (fileName.endsWith(".h")){
            this.type = FileType.HEADER;
        }else {
            this.type =FileType.CPP;
        }
        this.directDependencyFile = new ArrayList<String>();
        this.dependencyLink = new ArrayList<String>();
        this.allDependencyFile = new HashSet<String>();
    }

    public void printDependencyLink()
    {
        for(String str: dependencyLink){
            System.out.println(fileName+"的依赖链："+str);
        }
    }

}
