import java.util.List;
import java.util.Set;

enum FileType{
    CPP, HEADER
}

public class FileInfo {

    private String fileName;
    private FileType type;
    private List<String> directDependencyFile;
    private Set<String> allDependencyFile;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public List<String> getDirectDependencyFile() {
        return directDependencyFile;
    }

    public void setDirectDependencyFile(List<String> directDependencyFile) {
        this.directDependencyFile = directDependencyFile;
    }

    public Set<String> getAllDependencyFile() {
        return allDependencyFile;
    }

    public void setAllDependencyFile(Set<String> allDependencyFile) {
        this.allDependencyFile = allDependencyFile;
    }
}
