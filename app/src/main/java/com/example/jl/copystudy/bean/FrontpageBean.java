package com.example.jl.copystudy.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/1/21.
 *
 * 轮播图bean
 */

public class FrontpageBean implements Serializable {

    /**
     * data : [{"action":{"type":0},"data":[{"action":{"type":19,"value":"2102656296"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"林宥嘉","id":3926,"isExclusive":1,"name":"长大的童话","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/195/58370f164f6dc_9754208_1480003350.jpg","status":1},{"action":{"type":19,"value":"2102655589"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"任贤齐","id":3920,"isExclusive":1,"name":"朋友的酒","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/73/583515985d039_3695825_1479873944.jpg","status":1},{"action":{"type":19,"value":"2102654707"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":1800},"desc":"郁可唯","id":3909,"isExclusive":1,"name":"倒流","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/160/58325730a150a_8038592_1479694128.jpg","status":1},{"action":{"type":1,"value":"http://h.dongting.com/yule/app/music_buy.html?id=2102644381"},"desc":"圭贤","id":3853,"name":"我在等你","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/191/58233bde52e46_9583561_1478704094.jpg"},{"action":{"type":1,"value":"http://m.dongting.com/ali-entertain/buy/?album_id=2102411808"},"desc":"张艺兴","id":3890,"name":"张艺兴","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/80/581995338de95_4026804_1478071603.jpg"}],"desc":"海报","id":2881,"isNameDisplay":0,"name":"海报（阿里星球）","style":8},{"action":{"type":0},"data":[{"action":{"type":2},"id":2922,"name":"歌单","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/35/575e18b1477d7_1789891_1465784497.png"},{"action":{"type":25},"id":2923,"name":"排行榜","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/40/575e18b9804e1_2033035_1465784505.png"},{"action":{"type":26},"id":2924,"name":"歌手","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/118/575e18bf6a165_5919648_1465784511.png"}],"id":2916,"isNameDisplay":0,"name":"频道入口（阿里星球）","style":12},{"action":{"type":0},"data":[{"action":{"type":13},"desc":"根据你的口味推荐","id":2921,"name":"猜你喜欢"},{"action":{"type":6},"desc":"大家正在听的歌","id":2920,"name":"大家在听"}],"id":2918,"isNameDisplay":1,"name":"歌曲推荐","style":16},{"action":{"type":11},"data":[{"action":{"type":19,"value":"2102657093"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"王子强","id":3931,"isExclusive":0,"name":"如何再见","picUrl":"http://img.xiami.net/images/album/img21/23/583b98c6a5cb2_1194921_1480300742_4.jpg","status":1},{"action":{"type":19,"value":"2102657122"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"动力火车","id":3932,"isExclusive":1,"name":"跟自己合唱","picUrl":"http://img.xiami.net/images/album/img56/152/583ba4c853d9b_7640256_1480303816_4.jpg","status":1},{"action":{"type":19,"value":"2102657158"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"Far East Movement","id":3933,"isExclusive":0,"name":"On The Edge","picUrl":"http://img.xiami.net/images/album/img18/128/583d4d4b178f7_6437318_1480412491_4.jpg","status":1},{"action":{"type":19,"value":"2102658927"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"王金金","id":3934,"isExclusive":0,"name":"Crazy Girl","picUrl":"http://img.xiami.net/images/album/img22/662322/6623221480662322_4.png","status":1}],"id":2891,"isNameDisplay":1,"name":"新歌新碟","style":5},{"action":{"type":0},"data":[{"action":{"type":19,"value":"2413475"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":200},"desc":"陈奕迅","id":3851,"isExclusive":0,"name":"I Do","picUrl":"http://img.xiami.net/images/album/img35/135/21003914841474818220_4.jpg","status":1},{"action":{"type":19,"value":"2377462"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":2000},"desc":"田馥甄","id":3764,"isExclusive":1,"name":"日常","picUrl":"http://img.xiami.net/images/album/img23/78523/21003555471468309756_4.jpg","status":1},{"action":{"type":19,"value":"2364801"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":2000},"desc":"五月天","id":3765,"isExclusive":1,"name":"自传","picUrl":"http://img.xiami.net/images/album/img10/3110/21003372621469680510_4.jpg","status":1},{"action":{"type":19,"value":"2371839"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":1500},"desc":"EXO","id":3766,"isExclusive":1,"name":"EX'ACT (韩文版) \u2013 The 3rd Album","picUrl":"http://img.xiami.net/images/album/img41/102841/21003501001465545556_4.jpg","status":1},{"action":{"type":19,"value":"2370037"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":2000},"desc":"林宥嘉","id":3767,"isExclusive":1,"name":"今日营业中","picUrl":"http://img.xiami.net/images/album/img17/23517/21003477341466130905_4.png","status":1},{"action":{"type":19,"value":"2395820"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":500},"desc":"允儿","id":3768,"isExclusive":1,"name":"Blossom","picUrl":"http://img.xiami.net/images/album/img41/79241/21003738611470233011_4.jpg","status":1}],"id":2890,"isNameDisplay":1,"name":"手机唱片店","style":5},{"action":{"type":2},"data":[{"action":{"type":5,"value":"305481305"},"author":"阿里音乐","comments":87,"desc":"阿里音乐","id":2958,"listenCount":263188,"name":"听一首李宗盛","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/0/573178f19daf2_0_1462860017.png"},{"action":{"type":1,"value":"http://www.itlily.com/0ov4152728"},"desc":"阿里音乐","id":2909,"name":"清新独立的民谣","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/191/5811796ada327_9590906_1477540202.jpg"},{"action":{"type":5,"value":"308413381"},"author":"阿里音乐","comments":66,"desc":"阿里音乐","id":3057,"listenCount":147917,"name":"男神也唱歌","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/0/572d4f1e73738_0_1462587166.png"},{"action":{"type":5,"value":"308413511"},"author":"阿里音乐","comments":30,"desc":"阿里音乐","id":3312,"listenCount":152239,"name":"睡前造梦曲","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/0/56fa6c8fbb58b_0_1459252367.png"},{"action":{"type":5,"value":"305474636"},"author":"初夏 , 微凉","comments":57,"desc":"阿里音乐","id":3221,"listenCount":591558,"name":"好听唯美古风曲","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/0/571ae3ea5d0f6_0_1461380074.png"},{"action":{"type":5,"value":"307752035"},"author":"阿里音乐","comments":79,"desc":"阿里音乐","id":3270,"listenCount":365366,"name":"情歌还是老的好","picUrl":"http://3p.pic.ttdtweb.com/ranklist.ttpod.com/image_backend/cbe9f/f016f_1455504213184.png"}],"id":2884,"isNameDisplay":1,"name":"热门歌单","style":5},{"action":{"type":26},"data":[{"action":{"type":20,"value":"156520"},"desc":"韩国性感女神","id":2942,"name":"泰妍","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/0/570c5dfe13245_0_1460428286.jpg"},{"action":{"type":20,"value":"50530"},"desc":"香港乐坛歌神","id":3346,"name":"陈奕迅","picUrl":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/50530/7030798.jpg"},{"action":{"type":20,"value":"47"},"desc":"难忘香港经典歌后","id":3399,"name":"林忆莲","picUrl":"http://3p.pic.ttdtweb.com/3p.ttpod.com/singer/47/71026.jpg"}],"id":2938,"isNameDisplay":1,"name":"推荐艺人","style":5},{"action":{"type":2005},"data":[{"action":{"type":1,"value":"https://alimusic.dongting.com/markets/dongting/ArianaGrande"},"desc":"Ariana Grande转型之作《Dangerous Woman》实体专辑，59元包邮，买专辑获A妹限量版周边！","id":3819,"name":"【独家售卖】","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/84/57c52395a84c4_4208611_1472537493.jpg"},{"action":{"type":1,"value":"http://alimusic.xiami.com/markets/xiami/jzl-fish-TTPOD"},"desc":"梁静茹2016全新作品《不翼而飞》","id":2933,"name":"【音乐推荐】","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/155/579982077fcde_7766993_1469678087.jpg"},{"action":{"type":1,"value":"http://m.dongting.com/ali-entertain/buy/?album_id=2364801"},"desc":"五月天《作品9号》！预购用户独享视频故事～","id":3681,"name":"【独家音乐】","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/50/5785d97c1af06_2535681_1468389756.png"},{"action":{"type":1,"value":"http://m.dongting.com/ali-entertain/buy/?album_id=2377462"},"desc":"田馥甄首张数字专辑正式发行","id":3056,"name":"【独家音乐】","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/178/5785d8c2d867e_8938279_1468389570.jpg"},{"action":{"type":1,"value":"http://m.dongting.com/ali-entertain/buy/?album_id=2370037"},"desc":"林宥嘉《今日营业中》专辑正式售卖中～","id":3682,"name":"【独家音乐】","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/146/5785fd78eab7c_7336413_1468398968.png"},{"action":{"type":1,"value":"http://alimusic.dongting.com/markets/dongting/kfcbreakfast"},"desc":"《早，加油》完整版MV独家首播","id":3120,"name":"【独家策划】","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/48/576827a25000c_2446869_1466443682.jpg"}],"id":2893,"isNameDisplay":1,"name":"独家专区","style":2}]
     * version : 1485000900344
     */
    private long version;
    private List<DataBeanX> data;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public List<DataBeanX> getData() {
        return data;
    }

    public void setData(List<DataBeanX> data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * action : {"type":0}
         * data : [{"action":{"type":19,"value":"2102656296"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"林宥嘉","id":3926,"isExclusive":1,"name":"长大的童话","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/195/58370f164f6dc_9754208_1480003350.jpg","status":1},{"action":{"type":19,"value":"2102655589"},"albumRightKey":{"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0},"desc":"任贤齐","id":3920,"isExclusive":1,"name":"朋友的酒","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/73/583515985d039_3695825_1479873944.jpg","status":1},{"action":{"type":19,"value":"2102654707"},"albumRightKey":{"buy":false,"buyFlag":true,"count":-1,"dmsg":"","price":1800},"desc":"郁可唯","id":3909,"isExclusive":1,"name":"倒流","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/160/58325730a150a_8038592_1479694128.jpg","status":1},{"action":{"type":1,"value":"http://h.dongting.com/yule/app/music_buy.html?id=2102644381"},"desc":"圭贤","id":3853,"name":"我在等你","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/191/58233bde52e46_9583561_1478704094.jpg"},{"action":{"type":1,"value":"http://m.dongting.com/ali-entertain/buy/?album_id=2102411808"},"desc":"张艺兴","id":3890,"name":"张艺兴","picUrl":"http://pic.xiami.net/images/trade/ams_homepage/80/581995338de95_4026804_1478071603.jpg"}]
         * desc : 海报
         * id : 2881
         * isNameDisplay : 0
         * name : 海报（阿里星球）
         * style : 8
         */

        private ActionBean action;
        private String desc;
        private int id;
        private int isNameDisplay;
        private String name;
        private int style;
        private List<DataBean> data;

        public ActionBean getAction() {
            return action;
        }

        public void setAction(ActionBean action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsNameDisplay() {
            return isNameDisplay;
        }

        public void setIsNameDisplay(int isNameDisplay) {
            this.isNameDisplay = isNameDisplay;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStyle() {
            return style;
        }

        public void setStyle(int style) {
            this.style = style;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class ActionBean {
            /**
             * type : 0
             */

            private int type;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class DataBean {
            /**
             * action : {"type":19,"value":"2102656296"}
             * albumRightKey : {"buy":false,"buyFlag":false,"count":-1,"dmsg":"","price":0}
             * desc : 林宥嘉
             * id : 3926
             * isExclusive : 1
             * name : 长大的童话
             * picUrl : http://pic.xiami.net/images/trade/ams_homepage/195/58370f164f6dc_9754208_1480003350.jpg
             * status : 1
             */

            private ActionBeanX action;
            private AlbumRightKeyBean albumRightKey;
            private String desc;
            private int id;
            private int isExclusive;
            private String name;
            private String picUrl;
            private int status;

            public ActionBeanX getAction() {
                return action;
            }

            public void setAction(ActionBeanX action) {
                this.action = action;
            }

            public AlbumRightKeyBean getAlbumRightKey() {
                return albumRightKey;
            }

            public void setAlbumRightKey(AlbumRightKeyBean albumRightKey) {
                this.albumRightKey = albumRightKey;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getIsExclusive() {
                return isExclusive;
            }

            public void setIsExclusive(int isExclusive) {
                this.isExclusive = isExclusive;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public static class ActionBeanX {
                /**
                 * type : 19
                 * value : 2102656296
                 */

                private int type;
                private String value;

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }

            public static class AlbumRightKeyBean {
                /**
                 * buy : false
                 * buyFlag : false
                 * count : -1
                 * dmsg :
                 * price : 0
                 */

                private boolean buy;
                private boolean buyFlag;
                private int count;
                private String dmsg;
                private int price;

                public boolean isBuy() {
                    return buy;
                }

                public void setBuy(boolean buy) {
                    this.buy = buy;
                }

                public boolean isBuyFlag() {
                    return buyFlag;
                }

                public void setBuyFlag(boolean buyFlag) {
                    this.buyFlag = buyFlag;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public String getDmsg() {
                    return dmsg;
                }

                public void setDmsg(String dmsg) {
                    this.dmsg = dmsg;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }
            }
        }
    }
}
