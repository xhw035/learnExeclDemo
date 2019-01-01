import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileDataBase {
    public static Map<String, FileInfo> cppDB = new HashMap<>();
    public static Map<String, FileInfo> headerDB = new HashMap<>();

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
            findRepeatHeaderFiles(fileInfo);
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

    public static void findRepeatHeaderFiles(FileInfo fileInfo){
        String dependencyLinkStr = "";
        for(String str: fileInfo.dependencyLink){
            dependencyLinkStr += " | " + str;
        }

        for(String headerFile: fileInfo.allDependencyFile){
            int count = dependencyLinkStr.split(headerFile).length - 1;
            if (count >=2){
                fileInfo.repeatHeaderFiles.put(headerFile,new ArrayList<>());
            }
        }

        for(String str: fileInfo.dependencyLink){
            for (String headerFile : fileInfo.repeatHeaderFiles.keySet()) {
                if (str.contains(headerFile)) {
                    fileInfo.repeatHeaderFiles.get(headerFile).add(str);
                }
            }
        }

    }
}
