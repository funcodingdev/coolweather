package com.hasee.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.hasee.coolweather.db.City;
import com.hasee.coolweather.db.County;
import com.hasee.coolweather.db.Province;
import com.hasee.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    /*
     * 解析和处理服务器返回的省级数据
     * */
    public static boolean handleProvinceResponse(String response) {
        try {
            if (!TextUtils.isEmpty(response)) {
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0; i < allProvince.length(); i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * 解析和处理服务器返回的市级数据
     * */
    public static boolean handleCityResponse(String response, int provinceId) {

        try {
            if (!TextUtils.isEmpty(response)) {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
     * 解析和处理服务器返回的县级数据
     * */
    public static boolean handleCountyResponse(String response, int cityId) {
        try {
            if (!TextUtils.isEmpty(response)) {
                JSONArray allcounties = new JSONArray(response);
                for (int i = 0; i < allcounties.length(); i++) {
                    JSONObject countyObject = allcounties.getJSONObject(i);
                    County county = new County();
                    county.setCountryName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    * 将返回的JSON的数据解析成Weather实体类
    * */
    public static Weather handleWeatherResponse(String reponse){
        try {
            JSONObject jsonObject = new JSONObject(reponse);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            Log.d("json", "handleWeatherResponse: "+weatherContent);
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
