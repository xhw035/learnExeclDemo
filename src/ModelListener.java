import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;


public class ModelListener extends AnalysisEventListener<RowInfo> {


    public void invoke(RowInfo row, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        //System.out.println(row);
        System.out.println(row.getFileName());
        System.out.println(row.getErrorType());
        System.out.println(row.getInfo());
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        //解析结束销毁不用的资源
    }

}