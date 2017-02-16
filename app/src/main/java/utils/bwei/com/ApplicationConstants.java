package utils.bwei.com;

/**
 * 姓名:胡文帅
 * 时间:2017/2/16
 * 邮箱：
 * 备注：
 */

public class ApplicationConstants {
    private static int pageSize = 5;
    public static final String APP_KEY = "a0f19c0e92c82045c9cc4f7e716e6c33";
    public static final String URL_PICTURE = "http://japi.juhe.cn/joke/content/list.from?key="+APP_KEY;

    public static  String getUrl(int currentPage){
        String url=URL_PICTURE + "&page="+currentPage+"&pagesize="+pageSize+"&sort=asc&time="+"1418816972";
        return  url;
    }
}
