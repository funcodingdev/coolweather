package com.hasee.coolweather.gson;

import com.google.gson.annotations.SerializedName;

public class Basic {
    //由于JSON中一些字段可能不太适合直接作为Java字段来命名，
    // 所以使用@SerializedName("")来让JSON字段和java字段建立映射
    @SerializedName("city")
    public String cityName;
    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
