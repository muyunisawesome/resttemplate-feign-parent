package com.cht.provider;

import com.cht.PageResult;
import com.cht.Response;
import com.cht.provider.dto.DemoDto;
import com.cht.dto.OrderDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class ProviderController {


    @PostMapping(value = "/{bbb}/ttt1")
    public Response<PageResult<OrderDto>> ttt(@RequestBody DemoDto demoDto,
                                              @RequestParam("aaa") String aaa,
                                              @PathVariable("bbb") String bbb, HttpServletRequest request) {
        String token = request.getHeader("token");

        OrderDto orderDto = new OrderDto();
        orderDto.setUuid(aaa);
        orderDto.setName(bbb);
        orderDto.setName2(demoDto.getName());
        orderDto.setMobile(token);
        orderDto.setTime(new Date());
        List<OrderDto> list = Arrays.asList(orderDto);
        PageResult<OrderDto> objectPageResult = new PageResult<>();
        objectPageResult.setList(list);
        objectPageResult.setCurrPage(1);
        objectPageResult.setPageSize(10);
        objectPageResult.setTotalCount(1);
        return Response.createSuccess(objectPageResult);
    }

//    @PostMapping(value = "/ttt2")
//    public Response<PageResult<RouteBlackDto>> ttt2() {
//        RouteBlackDto routeBlackDto = new RouteBlackDto();
//        routeBlackDto.setUuid("11111");
//        routeBlackDto.setBlackTime(new Date());
//        List<RouteBlackDto> list = Arrays.asList(routeBlackDto);
//        PageResult<RouteBlackDto> objectPageResult = new PageResult<>();
//        objectPageResult.setList(list);
//        objectPageResult.setCurrPage(1);
//        objectPageResult.setPageSize(10);
//        objectPageResult.setTotalCount(1);
//        return Response.createSuccess(objectPageResult);
//    }
//
//    @PostMapping(value = "/ttt3")
//    public Response<PageResult<RouteBlackDto>> ttt3(@RequestBody DemoDto demoDto) {
//        RouteBlackDto routeBlackDto = new RouteBlackDto();
//        routeBlackDto.setUuid(demoDto.getName());
//        routeBlackDto.setBlackTime(new Date());
//        List<RouteBlackDto> list = Arrays.asList(routeBlackDto);
//        PageResult<RouteBlackDto> objectPageResult = new PageResult<>();
//        objectPageResult.setList(list);
//        objectPageResult.setCurrPage(1);
//        objectPageResult.setPageSize(10);
//        objectPageResult.setTotalCount(1);
//        return Response.createSuccess(objectPageResult);
//    }
//
//    @PostMapping(value = "/ttt4")
//    public Response<RouteBlackDto> ttt4() {
//        RouteBlackDto routeBlackDto = new RouteBlackDto();
//        routeBlackDto.setBlackTime(new Date());
//        routeBlackDto.setXxx1(new BigDecimal(9.55));
//        return Response.createSuccess(routeBlackDto);
//    }
//
//    @PostMapping(value = "/ttt5")
//    public Response<Map> ttt5(@RequestBody DemoDto demoDto) {
//        Map<String, String> test = new HashMap<>();
//        test.put("ww", "www");
//        test.put("xx", "xxx");
//        return Response.createSuccess(test);
//    }
//
//    @PostMapping(value = "/ttt6")
//    public Response<List<RouteBlackDto>> ttt6(@RequestBody DemoDto demoDto) {
//        return Response.createError("服务内部异常");
//    }
//
//    @PostMapping(value = "/ttt7")
//    public Response<PageResult<FareComputeVO>> ttt7() {
//        FareComputeVO fareComputeVO = new FareComputeVO();
//        fareComputeVO.setCurrentFareModel(21);
//        fareComputeVO.setBusinessType(1);
//        fareComputeVO.setDiscount(12.1);
//        fareComputeVO.setCouponPrice(new BigDecimal(9.54));
//        List<FareComputeVO> list = new ArrayList();
//        list.add(fareComputeVO);
//
//        PageResult<FareComputeVO> objectPageResult = new PageResult<>();
//        objectPageResult.setCurrPage(1);
//        objectPageResult.setPageSize(10);
//        objectPageResult.setTotalCount(1);
//        objectPageResult.setList(list);
//        return Response.createSuccess(objectPageResult);
//    }
//
//    @PostMapping(value = "/ttt8")
//    public Response<DemoDto> ttt8(@RequestBody DemoDto demoDto) throws ParseException {
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        demoDto.setTestField(dateFormat.parse("2019-11-12 11:12:11"));
//        demoDto.setTestField(new Date());
//        return Response.createSuccess(demoDto);
//    }
//
//
//    @PostMapping(value = "/ae")
//    public Response<TaxiFareComputeDTO> ae() {
//        TaxiFareComputeDTO taxiFareComputeDTO = new TaxiFareComputeDTO();
//        taxiFareComputeDTO.setActPaid(new BigDecimal(9.54));
//        return Response.createSuccess(taxiFareComputeDTO);
//    }
//
//    @PostMapping(value = "/ttt12")
//    public Response<String> ae12(@RequestParam(value = "file") MultipartFile file) {
//        long size = file.getSize();
//        System.out.println("file size " + size);
//
//        return Response.createSuccess("" + size);
//    }
}
