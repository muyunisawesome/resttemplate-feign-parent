package com.cht.demo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cht.rst.feign.inner.logger.DefaultLogger;
import com.cht.rst.feign.inner.logger.FeignLoggerFactory;
import com.cht.rst.feign.inner.logger.Logger;
import com.cht.rst.feign.inner.logging.LogFactory;
import com.cht.rst.feign.inner.logging.Log;

import org.springframework.http.HttpMethod;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class MyFeignLoggerFactory implements FeignLoggerFactory {

    private Logger.Level loggerLever;

    private MyChtFeignLogger logger;

    public MyChtFeignLogger getLogger() {
        return logger;
    }


    public MyFeignLoggerFactory(Logger.Level loggerLever) {
        this.loggerLever = loggerLever;
    }

    @Override
    public Logger create(Class<?> type) {
        this.logger = new MyChtFeignLogger(type,
                Optional.ofNullable(loggerLever).orElse(Logger.Level.DEBUG));
        return logger;
    }

    class MyChtFeignLogger extends DefaultLogger {

        public static final String TRACE_ID = "traceId";

        private final Log log;
        private Consumer<String> logConsumer;

        public MyChtFeignLogger(Class<?> clazz, Logger.Level loggerLever) {

            log = LogFactory.getLog(clazz);
            changeLevel(loggerLever);
        }

        public void changeLevel(Logger.Level loggerLever) {

            if (loggerLever == Logger.Level.DEBUG) {
                this.logConsumer = log::debug;
            } else if (loggerLever == Logger.Level.ERROR) {
                this.logConsumer = log::error;
            } else if (loggerLever == Logger.Level.INFO) {
                this.logConsumer = log::info;
            } else if (loggerLever == Logger.Level.WARN) {
                this.logConsumer = log::warn;
            } else {
                throw new UnsupportedOperationException("We don't support this log level currently.");
            }
        }

        @Override
        public void logRequest(String configKey, HttpMethod method, String finalUrl, Object requestBody,
                               Map<String, String> headerParams) {
        }

        @Override
        public <T> void logResponse(String configKey, HttpMethod method, String finalUrl, Object requestBody,
                                    Map<String, String> headerParams, T t, long elapsedTime) {

            this.logConsumer.accept(Logger.methodTag(configKey)
                    + String.format("\n\t[cht-feign] invocation cost %s ms traceId=%s: "
                            + "\n\turl = %s \n\theaders = %s \n\trequestBoy = %s \n\tresult = %s",
                    elapsedTime,
                    "MDC.get(HttpTraceLogFilter.TRACE_ID)",
                    finalUrl,
                    headerParams,
                    JSONObject.toJSONString(requestBody),
                    JSONObject.toJSONString(t, SerializerFeature.WriteMapNullValue)));
        }
    }

}