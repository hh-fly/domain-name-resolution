package com.rinlink.dnr.controller;

import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DNSAnalyze {

    @GetMapping("find")
    public Object getIp(@RequestParam(name = "ip") String name) {
        Map<String,Object> res = new HashMap<>();
        try {
            InetAddress[] inetadd = InetAddress.getAllByName(name);
            res.put("count",InetAddress.getAllByName(name).length);
            List<String> list =new ArrayList<>();
            for (InetAddress inetAddress : inetadd) {
                list.add(inetAddress.getHostAddress());
            }
            res.put("list",list);
            return res;
        } catch (UnknownHostException e) {
            res.put("count",0);
            res.put("list","获取IP地址失败！没有对应的IP！");
        }
        return res;
    }
}
