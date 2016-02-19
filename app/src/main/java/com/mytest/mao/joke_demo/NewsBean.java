package com.mytest.mao.joke_demo;

import java.util.List;

/**
 * Created by mao on 2016/1/26.
 */
public class NewsBean {

    /**
     * result : [{"ctime":"2016-01-26 02:50","title":"中国人在老挝遇爆炸 2人遇难1人受伤","description":"中国人在老挝遇爆炸 2人遇难1人受伤...","picUrl":"","url":"http://news.sohu.com/20160126/n435816457.shtml"},{"ctime":"2016-01-26 03:26","title":"华盛顿继续因雪\u201c停摆\u201d 联邦政府与众议院关门","description":"华盛顿继续因雪\u201c停摆\u201d 联邦政府与众议院关门...","picUrl":"","url":"http://news.sohu.com/20160126/n435817554.shtml"},{"ctime":"2016-01-26 04:10","title":"委内瑞拉等15国欠会费将失联大投票权","description":"委内瑞拉等15国欠会费将失联大投票权...","picUrl":"","url":"http://news.sohu.com/20160126/n435818844.shtml"},{"ctime":"2016-01-26 04:33","title":"韩媒：与美国核武库相比 朝鲜核武器像儿童玩具","description":"韩媒：与美国核武库相比 朝鲜核武器像儿童玩具...","picUrl":"","url":"http://news.sohu.com/20160126/n435819617.shtml"},{"ctime":"2016-01-26 04:41","title":"关塔那摩囚犯含冤13年被释放","description":"关塔那摩囚犯含冤13年被释放...","picUrl":"","url":"http://news.sohu.com/20160126/n435819797.shtml"},{"ctime":"2016-01-26 06:00","title":"英公司让难民佩手环领食物 被批是赤裸裸的歧视","description":"英公司让难民佩手环领食物 被批是赤裸裸的歧视...","picUrl":"http://photocdn.sohu.com/20160126/Img435817555_ss.jpg","url":"http://news.sohu.com/20160126/n435823578.shtml"},{"ctime":"2016-01-26 06:04","title":"日本捕获417公斤重的金枪鱼 可做3千人份生鱼片","description":"日本捕获417公斤重的金枪鱼 可做3千人份生鱼片...","picUrl":"http://photocdn.sohu.com/20160126/Img435819798_ss.jpeg","url":"http://news.sohu.com/20160126/n435823627.shtml"},{"ctime":"2016-01-26 06:05","title":"阮晋勇不参选越共总书记 现任总书记阮富仲或连任","description":"阮晋勇不参选越共总书记 现任总书记阮富仲或连任...","picUrl":"http://photocdn.sohu.com/20160126/Img435823579_ss.jpeg","url":"http://news.sohu.com/20160126/n435823646.shtml"},{"ctime":"2016-01-26 06:59","title":"欧洲刑警组织公布新版IS计划 欧洲仍是恐袭目标","description":"欧洲刑警组织公布新版IS计划 欧洲仍是恐袭目标...","picUrl":"http://photocdn.sohu.com/20160126/Img435823628_ss.jpeg","url":"http://news.sohu.com/20160126/n435824395.shtml"},{"ctime":"2016-01-26 07:07","title":"阿根廷门多萨省山体滑坡3000名旅客滞留高山","description":"阿根廷门多萨省山体滑坡3000名旅客滞留高山...","picUrl":"http://photocdn.sohu.com/20160126/Img435824396_ss.jpg","url":"http://news.sohu.com/20160126/n435825826.shtml"}]
     * error_code : 0
     * reason : Succes
     */

    private int error_code;
    private String reason;
    /**
     * ctime : 2016-01-26 02:50
     * title : 中国人在老挝遇爆炸 2人遇难1人受伤
     * description : 中国人在老挝遇爆炸 2人遇难1人受伤...
     * picUrl :
     * url : http://news.sohu.com/20160126/n435816457.shtml
     */

    private List<ResultEntity> result;

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(List<ResultEntity> result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public String getReason() {
        return reason;
    }

    public List<ResultEntity> getResult() {
        return result;
    }

    public static class ResultEntity {
        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCtime() {
            return ctime;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public String getUrl() {
            return url;
        }
    }
}
