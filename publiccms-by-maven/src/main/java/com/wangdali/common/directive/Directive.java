package com.wangdali.common.directive;

import java.io.IOException;

import com.wangdali.common.handler.RenderHandler;

/**
 * 
 * BaseDirective 指令接口
 *
 */
public interface Directive {

    /**
     * 执行
     * 
     * @param handler
     * @throws IOException
     * @throws Exception
     */
    public abstract void execute(RenderHandler handler) throws IOException, Exception;
}
