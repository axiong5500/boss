package cn.tablego.project.springboot.business;

import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: Boss
 * @Description:
 * @Author lianyixiong
 * @Date 2022/12/13
 * @Version 1.0
 */
public class Boss {

    private static String request_url = "https://www.zhipin.com/wapi/zpgeek/search/joblist.json" +
            "?scene=1" +
            "&query=%E8%BD%AF%E4%BB%B6%E6%B5%8B%E8%AF%95%E5%B7%A5%E7%A8%8B%E5%B8%88" +
            "&city=101280600" +
            "&experience=" +
            "&degree=" +
            "&industry=" +
            "&scale=" +
            "&stage=" +
            "&position=" +
            "&salary=" +
            "&multiBusinessDistrict=" +
            "&page=3" +
            "&pageSize=30";

    private static String cookie_ = "";

    private static String user_agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36";

    public static void main(String[] args) {
        String result =  HttpUtil.createGet(request_url)
                .header("cookie",cookie_)
                .header("user-agent", user_agent)
                .execute().body();
        System.out.println(result);
        JSONObject jsonObject =  JSONObject.parseObject(result);
        Integer response_code = jsonObject.getInteger("code");
        String response_message = jsonObject.getString("message");

        String response_zpData = jsonObject.getString("zpData");
        JSONObject zpData_jsonObject =  JSONObject.parseObject(response_zpData);
        Integer all_count = zpData_jsonObject.getInteger("resCount");
        String response_zpData_jobList = zpData_jsonObject.getString("jobList");
        JSONArray jobList_arr = JSONArray.parseArray(response_zpData_jobList);
        for (int i = 0; i < jobList_arr.size(); i++) {
            JSONObject json_ = jobList_arr.getJSONObject(i);
            String jobName = json_.getString("jobName");//岗位
            String salaryDesc = json_.getString("salaryDesc");//薪资
            String bossOnline = json_.getBoolean("bossOnline") ? "在线" :"不在线";//在线状态
            String areaDistrict = json_.getString("areaDistrict");//地区
            System.out.println(jobName+","+salaryDesc+","+bossOnline+","+areaDistrict);
        }

    }
}
