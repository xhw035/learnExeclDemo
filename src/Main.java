import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        testExcel2003NoModel();
    }

    public static void  testExcel2003NoModel() {
        File directory = new File("");//设定为当前文件夹
        try{
            System.out.println("当前路径：" + directory.getAbsolutePath());//获取绝对路径
        }catch(Exception e){}

        File srcFile1 = new File("./execl/test1.xls");
        File srcFile2 = new File("./execl/test2.xlsx");
        InputStream in1 = null;
        InputStream in2 = null;
        InputStream in3 = null;
        try {
            in1 = new FileInputStream(srcFile1);
            in2 = new FileInputStream(srcFile1);
            in3 = new FileInputStream(srcFile2);
            SimplelListener listener1 = new SimplelListener();
            ModelListener listener2 = new ModelListener();

            // 1.没有映射模型
            ExcelReader excelReader1 = new ExcelReader(in1, ExcelTypeEnum.XLS, null, listener1);
            excelReader1.read();

            // 2.有映射模型
            ExcelReader excelReader2 = new ExcelReader(in2, ExcelTypeEnum.XLS, null, listener2);
            // 第二个参数为表头行数，按照实际设置
            excelReader2.read(new Sheet(1, 1, RowInfo.class));

            // 3.读2007
            ExcelReader excelReader3 = new ExcelReader(in3, ExcelTypeEnum.XLSX, null, listener2);
            excelReader3.read(new Sheet(1, 0, RowInfo.class));
        } catch (Exception e) {

        } finally {
            try {
                in1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
