package utils.bwei.com;

/**
 * 姓名:胡文帅
 * 时间:2017/2/16
 * 邮箱：
 * 备注：
 */

public class ApplicationConstants {


    //新闻地址的拼接
    public static final String URL_PICTURE = "http://c.m.163.com/nc/article/headline/";

    public static  String getUrl(String key, int start,int end){
        String url=URL_PICTURE +key+"/"+start+"-"+end+".html";
        return  url;
    }


    //视频的地址拼接
    public static final String URL_VIDEO = "http://c.3g.163.com/nc/video/list/";

    public static  String getVideoUrl(String key, int start,int end){
        String url=URL_VIDEO +key+"/n/"+start+"-"+end+".html";
        return  url;
    }
}
