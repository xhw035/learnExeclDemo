import java.util.List;
import java.util.Map;

public class FileDataBase {
    public static Map<String, FileInfo> cppDB;
    public static Map<String, FileInfo> headerDB;

    public static void generateDependencyLink(){
        for (FileInfo fileInfo : cppDB.values()) {
            String linkStr = fileInfo.getFileName();
            traversalFileInfo(fileInfo,fileInfo,linkStr);
        }
    }

    private static void traversalFileInfo(FileInfo rootFileInfo, FileInfo fileInfo, String linkStr) {
        final String str =  linkStr;
        List<String> directDependencyFile = fileInfo.getDirectDependencyFile();
        if(directDependencyFile.isEmpty()){
            rootFileInfo.getDependencyLink().add(str);
            return;
        }
        linkStr = linkStr+"——>"+fileInfo.getFileName();
        for (String key:directDependencyFile)
        {
            traversalFileInfo(rootFileInfo,headerDB.get(key),linkStr);
        }
    }
}
