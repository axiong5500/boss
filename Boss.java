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

    private static String cookie_ = "wd_guid=615434d9-c540-48c4-b828-c86776ad4a29; historyState=state; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1642749724,1643257536,1643339273,1643342381; warlockjssdkcross=%7B%22distinct_id%22%3A%2218214a4625284d-09f7d36e1dc0a-26021a51-2073600-18214a462535cf%22%2C%22first_id%22%3A%22%22%2C%22props%22%3A%7B%7D%2C%22device_id%22%3A%2218214a4625284d-09f7d36e1dc0a-26021a51-2073600-18214a462535cf%22%7D; _bl_uid=smlkU6g9umd5qgy4kqjso0wr6j8a; _9755xjdesxxd_=32; YD00951578218230%3AWM_TID=cIjQNeKcuOtERAEAFULADYfqwpP3qgwq; lastCity=101280600; YD00951578218230%3AWM_NI=KMSTwT1ePBPvYCezJpg5Z%2Ft80s6rXWji4WpRwqm6dpiyNNTMquq3af9UfntNShCrsw8Ed0Y%2FGPBaSYGD%2FhzWkhrGKqDNNgGzcLhh3A%2FhyYrq%2Bu%2FA995knsxEm2eRHgYjeVg%3D; YD00951578218230%3AWM_NIKE=9ca17ae2e6ffcda170e2e6ee90b43db19683acd9728f968fa3d85b939f8bb1d842a7b78598ae7983ee98b6d52af0fea7c3b92a89939db5f660f3bba0a3d37e9b9dab9bc97ca5eb96d0f734f4adfa93db5daab7fcb8f35ab5afa3d7e77caba782afd747b3abbfd4e46efb8baa8ff74691b88d93f27dfc9bacd1dc2585908e82d253859ce189f95da9b8bea8ca7b88928288c672a194a889b24bedb8b7baf17be9abe1a2bc33f7b5a294fb4fafeeabb3cb6d9bb6abb7e637e2a3; wbg=0; gdxidpyhxdE=ZkpMOZNv1zWQoNHt0EyaQfR8oHjyXyTUP6jvQz8K5jgX1%5CXD1TI8LaXtlMeXI6%2B3LrNqNaWNAZTUBNhouhRCQSyUXH7Asi%2FIMDLNP2yus4odQX8HBIH2gW%5C8eQ6V%2B3Y%2BJJ1lKDKs%2FYJavZqVMt1vG89vlwZ2waf81womm2t1mO5ajhC1%3A1670406976806; wt2=Dau022YIRe5XTtoPdLMPM34PTzDTHEgqwDYCnfgeOvzt491NYHJ9W07zRiV1YO2Atr00asyNIlFylRIWHDPfKUA~~; __zp_seo_uuid__=d5bed4cf-55e6-43d2-b9c6-82e3d1b1080f; __g=-; __l=r=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3Df3kHbnX9SkP_0xTbb2YR1c7K4dFzZhRxrhioAtLREsrsUGg8-FhbcbOCedYWyiTG%26wd%3D%26eqid%3D8dee53860003b0890000000463929c88&l=%2Fwww.zhipin.com%2Fweb%2Fgeek%2Fjob%3Fquery%3D%25E8%2585%25BE%25E8%25AE%25AF%25E5%25A4%2596%25E5%258C%2585%26city%3D101280600&s=3&friend_source=0&s=3&friend_source=0; __zp_stoken__=9bd6eEDMvSm0iXQw8Uxd6UTlmW1N2QXVuPUcLS00mZzk2FRhffzIteCZZVQFTAEV%2FF0w1FlE8RFU2XWVkHDFBPiElTHQHcmJtXQc5KyMzdy8vK3pHHRQZFnEJZT9ydRw%2FVXUHdyBDRVwKRxY%3D; geek_zp_token=V1Q9wuF-b721hgXdNuzxQYKS615D7Qxw~~; __c=1670552718; __a=51688369.1638164869.1670231246.1670552718.1151.22.311.456";

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
