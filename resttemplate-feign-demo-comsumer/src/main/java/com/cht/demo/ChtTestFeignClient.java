package com.cht.demo;

import com.cht.PageResult;
import com.cht.Response;
import com.cht.demo.dto.DemoDto;
import com.cht.dto.OrderDto;
import com.cht.rst.feign.ChtFeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * RouteReadFeignClient
 */
@ChtFeignClient(name = "test-api1", url = "http://localhost:8081")
public interface ChtTestFeignClient {

    @PostMapping(value = "/{bbb}/ttt1")
    Response<PageResult<OrderDto>> ttt1(@RequestHeader("token") String token,
                                        @RequestBody DemoDto demoDto,
                                        @RequestParam("aaa") String aaa,
                                        @RequestParam("ccc") String ccc,
                                        @PathVariable("bbb") String bbb);

//    @PostMapping(value = "/ttt2")
//    Response<PageResult<RouteBlackDto>> ttt2();
//
//    @PostMapping(value = "/ttt3")
//    Response<PageResult<RouteBlackDto>> ttt3(@RequestBody Demo2Dto demoDto);
//
//    @PostMapping(value = "/ttt4")
//    Response<RouteBlackDto> ttt4();
//
//    @PostMapping(value = "/ttt5")
//    Response<LinkedHashMap> ttt5(@RequestBody Demo2Dto demoDto);
//
//    @PostMapping(value = "/ttt6")
//    Response<List<RouteBlackDto>> ttt6(@RequestBody Demo2Dto demoDto);
//
//    @PostMapping(value = "/ttt7")
//    Response<PageResult<FareComputeVO>> ttt7();
//
//    @PostMapping(value = "/ttt8")
//    Response<Demo2Dto> ttt8(@RequestBody Demo2Dto demoDto);

}
