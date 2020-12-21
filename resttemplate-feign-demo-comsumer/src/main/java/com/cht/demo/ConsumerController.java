package com.cht.demo;

import com.cht.PageResult;
import com.cht.Response;
import com.cht.demo.dto.DemoChildDto;
import com.cht.demo.dto.DemoDto;
import com.cht.dto.OrderDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;

@RestController
public class ConsumerController {

    @Resource
    private ChtTestFeignClient chtTestFeignClient;

    @GetMapping(value = "/ttt1")
    public Response<PageResult<OrderDto>> ttt1() throws ParseException {

        DemoDto demoDto = new DemoDto();
        demoDto.setName("haha");
        demoDto.setBlackTime(new Date());
        DemoChildDto demoChildDto = new DemoChildDto();
        demoChildDto.setAge(11);
        demoDto.setAgeDto(demoChildDto);
        Response<PageResult<OrderDto>> w =
                chtTestFeignClient.ttt1("token", demoDto, "aaa", null, "yyy");
        return w;
    }
}
