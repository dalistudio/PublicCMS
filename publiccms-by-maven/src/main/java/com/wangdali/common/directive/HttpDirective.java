package com.wangdali.common.directive;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * 
 * HttpServletDirective 接口指令
 *
 */
public interface HttpDirective {
    /**
     * 执行
     * 
     * @param httpMessageConverter
     * @param mediaType
     * @param request
     * @param callback
     * @param response
     * @throws IOException
     * @throws Exception
     */
    public void execute(HttpMessageConverter<Object> httpMessageConverter, MediaType mediaType, HttpServletRequest request,
            String callback, HttpServletResponse response) throws IOException, Exception;
}
