import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class RowInfo extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String fileName;

    @ExcelProperty(index = 1)
    private String errorType;

    @ExcelProperty(index = 2)
    private String info;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFileName() {
        return fileName;
    }

    public String getErrorType() {
        return errorType;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "RowInfo{" +
                "fileName='" + fileName + '\'' +
                ", errorType='" + errorType + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
