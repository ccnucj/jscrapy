package cacher;

import com.oxf1.spider.TaskConfig;
import com.oxf1.spider.cacher.Cacher;
import com.oxf1.spider.cacher.impl.LocalDiskCacher;
import com.oxf1.spider.cacher.impl.MongoCacher;
import com.oxf1.spider.config.ConfigKeys;
import com.oxf1.spider.page.Page;
import com.oxf1.spider.request.HttpRequestMethod;
import com.oxf1.spider.request.Request;
import com.oxf1.spider.request.impl.HttpRequest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

/**
 * Created by cxu on 2015/9/19.
 */
public class CacherTest {
    private Page page;
    private Request request;

    @BeforeClass
    public void setup(){
        request = new HttpRequest("http://oxf1.com/test", HttpRequestMethod.HTTP_DELETE, null);
        page = new Page("this is html content, hahaha!");
        page.setRequest(request);
    }

    @DataProvider(name="dp")
    public Cacher[][] dataProvider(){
        return new Cacher[][]{
                {initLocalDiskCacher()} ,
                {initMongoCacher()}
        };
    }

    @Test(dataProvider = "dp")
    public void test(Cacher cacher){
        cacher.cachePage(page);
        Page pg = cacher.loadPage(request);
        assertNotNull(pg);
        cacher.close();
    }

    /**
     *
     * @return
     */
    private Cacher initMongoCacher(){
        TaskConfig taskConfig = new TaskConfig("task_id", "task_name");
        taskConfig.put(ConfigKeys.MONGODB_HOST, "localhost");
        taskConfig.put(ConfigKeys.MONGODB_PORT, 27017);
        taskConfig.put(ConfigKeys.MONGODB_CACHER_DB_NAME, "myspider_cacher");
        Cacher cacher = new MongoCacher(taskConfig);
        return cacher;
    }

    /**
     *
     * @return
     */
    private Cacher initLocalDiskCacher(){
        TaskConfig taskConfig = new TaskConfig("task_id", "test_name");
        Cacher cacher = new LocalDiskCacher(taskConfig);
        return cacher;
    }
}