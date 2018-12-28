import java.util.Map;

public class FileDataBase {
    public static Map<String, FileInfo> cppDB;
    public static Map<String, FileInfo> headerDB;

    public static void insert(FileInfo fileInfo){
        if (fileInfo.type == FileType.CPP){
            cppDB.put(fileInfo.fileName,fileInfo);
        }else {
            headerDB.put(fileInfo.fileName,fileInfo);
        }
    }

    public static void generateDependencyLink(){
        for (FileInfo fileInfo : cppDB.values()) {
            String linkStr = fileInfo.fileName;
            traversalFileInfo(fileInfo,fileInfo,linkStr);
        }
    }

    private static void traversalFileInfo(FileInfo rootFileInfo, FileInfo fileInfo, String linkStr) {
        final String str =  linkStr;
        if(fileInfo.directDependencyFile.isEmpty()){
            rootFileInfo.dependencyLink.add(str);
            return;
        }

        for (String key:fileInfo.directDependencyFile)
        {
            linkStr = str+"——>"+key;
            rootFileInfo.allDependencyFile.add(key);
            traversalFileInfo(rootFileInfo,headerDB.get(key),linkStr);
        }
    }

}
