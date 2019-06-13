package com.example.sparsh.RedisUrlShortener.Controller;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.routines.UrlValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.URLValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.awt.*;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/url")
public class UrlShortenerController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @GetMapping("/{id}")
    @ResponseBody
    public String getFullUrl(@PathVariable String id)
    {
        System.out.println("get");
        String url =  redisTemplate.opsForValue().get(id);
        System.out.print(url);
        if (url!=null)
            return url ;
        else {
            System.out.println("get exception");
            throw new RuntimeException("Url not found");
        }
    }

    @ResponseBody
    @PostMapping()
    public String addUrl(@RequestBody String url)
    {
        UrlValidator validator = new UrlValidator(new String[]{"http","https"});

        if (validator.isValid(url))
        {
            String id = Hashing.murmur3_32().hashString(url, StandardCharsets.UTF_8).toString();

            System.out.println("id generated successfully "+id);
            redisTemplate.opsForValue().set(id,url);

            System.out.println("id entered successfully "+id);
            return id ;
        }
        else
        {
            System.out.println("post exception");
            throw new RuntimeException("Url is not valid");
        }
    }
}
