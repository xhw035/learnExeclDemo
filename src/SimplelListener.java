import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class SimplelListener extends AnalysisEventListener{

    public void invoke(Object object, AnalysisContext context) {
        System.out.println("当前行："+context.getCurrentRowNum());
        System.out.println(object);
    }

    public void doAfterAllAnalysed(AnalysisContext context) {
        //解析结束销毁不用的资源
    }

}